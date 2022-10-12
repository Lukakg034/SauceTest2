package userLoginLogout;
import baseTest.BaseTest;
import Pages.LandingPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class verifyInvalidUserLoginTest extends BaseTest {
    @Test
    public void test(){
        LandingPage landingPage=new LandingPage(driver);

        landingPage.fillOutCredentials("locked_out_user","secret_sauce");
        landingPage.getLoginButton().click();

        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", landingPage.getErrorMessage().getText());
    }
}
