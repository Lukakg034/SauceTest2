package shoppingCartCheckout;
import baseTest.BaseTest;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.InventoryPage;
import Pages.LandingPage;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Helper;

public class verifyLastNameFieldIsMandatoryTest extends BaseTest {
    @Test
    public void test(){ LandingPage landingPage=new LandingPage(driver);
        landingPage.fillOutCredentials("standard_user","secret_sauce");

        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);
        Helper helper = new Helper();

        inventoryPage.getAddToCartButton(helper.getRenamedItemString(Constants.SAUCE_BACKPACK)).click();
        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage=new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.fillOutCheckoutInputFields("ASDFG","","58216");
        checkoutPage.getContinueButton().click();

        Assert.assertEquals("Error: Last Name is required", checkoutPage.getErrorMessage().getText(), "Messages do not match.");
    }
}
