import org.junit.Assert;
import org.testng.annotations.Test;

public class LandingTest extends BaseTest{

    @Test(priority = 1)
    public void verifyValidUserLogin () throws InterruptedException {
    LandingPage landingPage=new LandingPage(driver);
    landingPage.getUsername().sendKeys("standard_user");
    landingPage.getPassword().sendKeys("secret_sauce");
    landingPage.getLoginButton().click();
    InventoryPage loginVerify=new InventoryPage(driver);
    Thread.sleep(2000);
        Assert.assertTrue(loginVerify.getProductContainer().isDisplayed());
        Assert.assertEquals("PRODUCTS", loginVerify.getProductContainer().getText());
    }

    @Test(priority = 2)
    public void verifyInvalidUserLogin() throws InterruptedException {
        LandingPage landingPage=new LandingPage(driver);
        landingPage.getUsername().sendKeys("locked_out_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();
        Thread.sleep(2000);
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", landingPage.getErrorMessage().getText());
    }
}

