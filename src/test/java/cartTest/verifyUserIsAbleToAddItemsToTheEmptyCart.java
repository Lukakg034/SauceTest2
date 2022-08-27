package cartTest;
import Pages.CartPage;
import baseTest.BaseTest;
import Pages.InventoryPage;
import Pages.LandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyUserIsAbleToAddItemsToTheEmptyCart extends BaseTest {
    @Test
    public void test(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.fillOutCredentials("standard_user","secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);

        CartPage cartPage=new CartPage(driver);

        inventoryPage.getShoppingCartButton().click();

        Assert.assertFalse(cartPage.isBackpackVisible(),"Backpack is not visible");
        Assert.assertFalse(cartPage.isBikeLightVisible(), "Bike light is not visible");
        Assert.assertFalse(cartPage.isTShirtVisible(), "T-shirt is not visible");

        cartPage.getContinueShoppingButton().click();

        inventoryPage.addBackpackTShirtBikeLightToCart();

        cartPage.getListOfItemsInYourCart();

        Assert.assertTrue(cartPage.isBackpackVisible(),"Backpack is not visible");
        Assert.assertTrue(cartPage.isBikeLightVisible(), "Bike light is not visible");
        Assert.assertTrue(cartPage.isTShirtVisible(), "T-shirt is not visible");
    }
}
