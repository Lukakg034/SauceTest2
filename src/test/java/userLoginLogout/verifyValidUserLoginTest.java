package userLoginLogout;
import baseTest.BaseTest;
import Pages.InventoryPage;
import Pages.LandingPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class verifyValidUserLoginTest extends BaseTest {
    @Test
    public void test(){
        LandingPage landingPage=new LandingPage(driver);
        landingPage.fillOutCredentials("standard_user","secret_sauce");
        landingPage.getLoginButton().click();
        InventoryPage loginVerify=new InventoryPage(driver);
        Assert.assertTrue(loginVerify.getProductContainer().isDisplayed());
        Assert.assertEquals("PRODUCTS", loginVerify.getProductContainer().getText());
    }
}
