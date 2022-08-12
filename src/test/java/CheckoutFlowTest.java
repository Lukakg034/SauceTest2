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
        inventoryPage.getSauceLabsBackpack().click();
        inventoryPage.getShoppingCartBtn().click();

        CartPage cartPage=new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.getFirstName().sendKeys("QWERTY");
        checkoutPage.getLastName().sendKeys("asdeqwe");
        checkoutPage.getPostalCode().sendKeys("58216");
        checkoutPage.getContinueBtn().click();
        checkoutPage.getFinishBtn().click();

        String finalOrderText=checkoutPage.getFinishText().getText();
        System.out.println(finalOrderText);
        Assert.assertEquals(finalOrderText, "Your order has been dispatched, and will arrive just as fast as the pony can get there!", "Order is not complete.");
    }
}
