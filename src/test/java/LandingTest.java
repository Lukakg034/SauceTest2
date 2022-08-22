import org.junit.Assert;
import org.testng.annotations.Test;

public class LandingTest extends BaseTest{

    @Test(priority = 1)
    public void verifyValidUserLogin (){
    LandingPage landingPage=new LandingPage(driver);
    landingPage.getUsername().sendKeys("standard_user");
    landingPage.getPassword().sendKeys("secret_sauce");
    landingPage.getLoginButton().click();
    InventoryPage loginVerify=new InventoryPage(driver);
        Assert.assertTrue(loginVerify.getProductContainer().isDisplayed());
        Assert.assertEquals("PRODUCTS", loginVerify.getProductContainer().getText());
    }

    @Test(priority = 2)
    public void verifyInvalidUserLogin()  {
        LandingPage landingPage=new LandingPage(driver);
        landingPage.getUsername().sendKeys("locked_out_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", landingPage.getErrorMessage().getText());
    }
}

