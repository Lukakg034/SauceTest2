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


public class verifyUserAbleToRemoveItemFromCartTest extends BaseTest {

    @Test
    public void test() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.fillOutCredentials("standard_user","secret_sauce");
        landingPage.getLoginButton().click();
        Helper helper = new Helper();
        InventoryPage inventoryPage = new InventoryPage(driver);

        //This block will locate add to cart button with formatted item name
        inventoryPage.getAddToCartButton(helper.getRenamedItemString(Constants.SAUCE_BACKPACK)).click();
        inventoryPage.getAddToCartButton(helper.getRenamedItemString(Constants.SAUCE_BIKE_LIGHT)).click();
        inventoryPage.getAddToCartButton(helper.getRenamedItemString(Constants.SAUCE_TSHIRT)).click();

        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage = new CartPage(driver);

        List<WebElement> cartItemList = cartPage.getListOfItemsInYourCart();

        List<String> itemNameList=cartPage.extractItemTextFromVisibleElements(cartItemList);

        //This assertion will validate if the items are contained in product cart
        Assert.assertTrue(itemNameList.contains("Sauce Labs Bolt T-Shirt"));
        Assert.assertTrue(itemNameList.contains("Sauce Labs Backpack"));
        Assert.assertTrue(itemNameList.contains("Sauce Labs Bike Light"));

        List<WebElement> itemsToRemove = cartPage.getRemoveButtons();
        for (WebElement removeItem : itemsToRemove) {
            removeItem.click();
        }
        //This assertion will validate that all the items from previous block are removed from cart
        Assert.assertTrue(cartPage.getListOfItemsInYourCart().isEmpty());
    }
}
