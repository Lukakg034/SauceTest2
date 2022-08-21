import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutFlowTest extends BaseTest{
    @Test
    public void verifyUserIsAbleToCompleteCheckoutFlow(){

        LandingPage landingPage=new LandingPage(driver);
        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);
        inventoryPage.getSauceLabsBackpackAddButton().click();
        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage=new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.getFirstNameInputField().sendKeys("QWERTY");
        checkoutPage.getLastNameInputField().sendKeys("asdeqwe");
        checkoutPage.getPostalCodeInputField().sendKeys("58216");
        checkoutPage.getContinueBtn().click();
        checkoutPage.getFinishBtn().click();

        Assert.assertEquals(checkoutPage.getFinishText().getText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!", "Order is not complete.");
    }
}
