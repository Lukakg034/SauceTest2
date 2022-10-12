package cartTest;
import Pages.CartPage;
import baseTest.BaseTest;
import Pages.InventoryPage;
import Pages.LandingPage;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Helper;

public class verifyUserIsAbleToAddItemsToTheEmptyCart extends BaseTest {
    @Test
    public void test(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.fillOutCredentials("standard_user","secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);

        CartPage cartPage=new CartPage(driver);

        inventoryPage.getShoppingCartButton().click();

        Assert.assertFalse(cartPage.isBackpackVisible(),"Backpack is visible");
        Assert.assertFalse(cartPage.isBikeLightVisible(), "Bike light is visible");
        Assert.assertFalse(cartPage.isTShirtVisible(), "T-shirt is visible");

        cartPage.getContinueShoppingButton().click();
        Helper helper = new Helper();

        inventoryPage.getAddToCartButton(helper.getRenamedItemString(Constants.SAUCE_BACKPACK)).click();
        inventoryPage.getAddToCartButton(helper.getRenamedItemString(Constants.SAUCE_TSHIRT)).click();
        inventoryPage.getAddToCartButton(helper.getRenamedItemString(Constants.SAUCE_BIKE_LIGHT)).click();

        inventoryPage.getShoppingCartButton().click();

        Assert.assertTrue(cartPage.isBackpackVisible(),"Backpack is not visible");
        Assert.assertTrue(cartPage.isBikeLightVisible(), "Bike light is not visible");
        Assert.assertTrue(cartPage.isTShirtVisible(), "T-shirt is not visible");
    }
}
