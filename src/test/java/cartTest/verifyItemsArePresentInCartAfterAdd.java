package cartTest;
import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LandingPage;
import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyItemsArePresentInCartAfterAdd extends BaseTest {
    @Test
    public void test(){

        LandingPage landingPage = new LandingPage(driver);
        landingPage.fillOutCredentials("standard_user","secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);

        CartPage cartPage=new CartPage(driver);

        inventoryPage.addBackpackTShirtBikeLightToCart();

        Assert.assertTrue(cartPage.isBackpackVisible());
        Assert.assertTrue(cartPage.isBikeLightVisible());
        Assert.assertTrue(cartPage.isTShirtVisible());
    }
}
