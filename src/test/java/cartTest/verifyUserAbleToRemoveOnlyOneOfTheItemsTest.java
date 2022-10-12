package cartTest;
import utility.Helper;
import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LandingPage;
import baseTest.BaseTest;
import constants.Constants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class verifyUserAbleToRemoveOnlyOneOfTheItemsTest extends BaseTest {

    @Test
    public void test() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.fillOutCredentials("standard_user","secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage = new InventoryPage(driver);
        Helper helper = new Helper();

        inventoryPage.getAddToCartButton(helper.getRenamedItemString(Constants.SAUCE_BACKPACK)).click();
        inventoryPage.getAddToCartButton(helper.getRenamedItemString(Constants.SAUCE_TSHIRT)).click();
        inventoryPage.getAddToCartButton(helper.getRenamedItemString(Constants.SAUCE_BIKE_LIGHT)).click();
        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage = new CartPage(driver);

        List<String> itemList = cartPage.extractItemTextFromVisibleElements(cartPage.getListOfItemsInYourCart());

        Assert.assertTrue(itemList.contains("Sauce Labs Backpack"));
        Assert.assertTrue(itemList.contains("Sauce Labs Bolt T-Shirt"));
        Assert.assertTrue(itemList.contains("Sauce Labs Bike Light"));

        cartPage.getRemoveBackpackItemFromCart().click();

        List<WebElement> cartItemListAfterRemovingItem = cartPage.getListOfItemsInYourCart();
        List <String> updatedListOfItems=cartPage.extractItemTextFromVisibleElements(cartItemListAfterRemovingItem);

        Assert.assertFalse(updatedListOfItems.contains("Sauce Labs Backpack"));
        Assert.assertTrue(updatedListOfItems.contains("Sauce Labs Bolt T-Shirt"));
        Assert.assertTrue(updatedListOfItems.contains("Sauce Labs Bike Light"));

        Assert.assertTrue(inventoryPage.getProductName(Constants.SAUCE_TSHIRT).isDisplayed(),"TShirt item is not displayed ");
        Assert.assertFalse(cartPage.isProductVisible(Constants.SAUCE_BACKPACK));
    }
}

