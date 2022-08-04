import org.junit.Assert;
import org.testng.annotations.Test;

public class LandingTest extends BaseTest{


    @Test
    public void verifyValidUserLogin (){
    LandingPage landingPage=new LandingPage(driver);
    landingPage.getUsername().sendKeys("standard_user");
    landingPage.getPassword().sendKeys("secret_sauce");
    landingPage.getLoginButton().click();
    InventoryPage loginVerify=new InventoryPage(driver);
        Assert.assertTrue(loginVerify.getProductContainer().isDisplayed());
        Assert.assertEquals("PRODUCTS", loginVerify.getProductContainer().getText());

    }

    @Test
    public void verifyInvalidUserLogin() throws InterruptedException {
        LandingPage landingPage=new LandingPage(driver);
        landingPage.getUsername().sendKeys("locked_out_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();
       // InventoryPage loginVerify=new InventoryPage(driver);
        Thread.sleep(2000);
        //System.out.println(landingPage.getErrorMessage().getText());
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", landingPage.getErrorMessage().getText());
        //kako asertovati da se element ne vidi jer login nije prosao?
        //Assert.assertFalse(loginVerify.getProductContainer().isDisplayed());

    }
}
