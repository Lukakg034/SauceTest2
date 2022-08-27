package cartTest;

import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LandingPage;
import baseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class verifyUserAbleToRemoveItemFromCartTest extends BaseTest {

    @Test
    public void test() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.fillOutCredentials("standard_user","secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackTShirtBikeLightToCart();
        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage = new CartPage(driver);

        List<WebElement> cartItemList = cartPage.getListOfItemsInYourCart();

        List<String> itemNameList=cartPage.extractItemTextFromVisibleElements(cartItemList);

        Assert.assertTrue(itemNameList.contains("Sauce Labs Bolt T-Shirt"));
        Assert.assertTrue(itemNameList.contains("Sauce Labs Backpack"));
        Assert.assertTrue(itemNameList.contains("Sauce Labs Bike Light"));

        Assert.assertEquals(itemNameList.get(1), "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(itemNameList.get(0), ("Sauce Labs Backpack"));
        Assert.assertEquals(itemNameList.get(2), ("Sauce Labs Bike Light"));

        List<WebElement> itemsToRemove = cartPage.getRemoveButtons();
        for (WebElement removeItem : itemsToRemove) {
            removeItem.click();
        }
        Assert.assertTrue(cartPage.getListOfItemsInYourCart().isEmpty());
    }
}
