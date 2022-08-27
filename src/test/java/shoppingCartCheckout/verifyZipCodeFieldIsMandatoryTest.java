package shoppingCartCheckout;
import baseTest.BaseTest;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.InventoryPage;
import Pages.LandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyZipCodeFieldIsMandatoryTest extends BaseTest {
    @Test
    public void test(){
        LandingPage landingPage=new LandingPage(driver);
        landingPage.fillOutCredentials("standard_user","secret_sauce");

        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);
        inventoryPage.getSauceLabsBackpackAddButton().click();
        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage=new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.fillOutCheckoutInputFields("QWERTY","asdeqwe","");
        checkoutPage.getContinueButton().click();

        Assert.assertEquals("Error: Postal Code is required", checkoutPage.getErrorMessage().getText(), "Messages do not match.");
    }
}
