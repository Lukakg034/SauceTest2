package cartTest;
import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LandingPage;
import baseTest.BaseTest;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Helper;

public class verifyItemsArePresentInCartAfterAdd extends BaseTest {
    @Test
    public void test(){

        LandingPage landingPage = new LandingPage(driver);
        landingPage.fillOutCredentials("standard_user","secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);

        CartPage cartPage=new CartPage(driver);
        Helper helper = new Helper();

        inventoryPage.getAddToCartButton(helper.getRenamedItemString(Constants.SAUCE_BACKPACK)).click();
        inventoryPage.getAddToCartButton(helper.getRenamedItemString(Constants.SAUCE_TSHIRT)).click();
        inventoryPage.getAddToCartButton(helper.getRenamedItemString(Constants.SAUCE_BIKE_LIGHT)).click();

        Assert.assertTrue(cartPage.isBackpackVisible());
        Assert.assertTrue(cartPage.isBikeLightVisible());
        Assert.assertTrue(cartPage.isTShirtVisible());
    }
}
