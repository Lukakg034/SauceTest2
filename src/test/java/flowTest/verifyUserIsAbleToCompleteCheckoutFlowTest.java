package flowTest;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.InventoryPage;
import Pages.LandingPage;
import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyUserIsAbleToCompleteCheckoutFlowTest extends BaseTest {

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
        checkoutPage.fillOutCheckoutInputFields("QWERTY","asdeqwe","58216");
        checkoutPage.getContinueButton().click();
        checkoutPage.getFinishOrderButton().click();

        Assert.assertEquals(checkoutPage.getFinishOrderDisplayText().getText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!", "Order is not complete.");
    }
}
