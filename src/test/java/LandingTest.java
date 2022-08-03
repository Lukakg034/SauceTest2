import org.junit.Assert;
import org.testng.annotations.Test;

public class LandingTest extends BaseTest{


    @Test
    public void verifyValidUserLogin (){
    LandingPage landingPage=new LandingPage(driver);
    landingPage.getUsername().sendKeys("standard_user");
    landingPage.getPassword().sendKeys("secret_sauce");
    landingPage.getLoginButton().click();
    ProductPage loginVerify=new ProductPage(driver);
        Assert.assertTrue(loginVerify.getProductContainer().isDisplayed());
        Assert.assertEquals("PRODUCTS", loginVerify.getProductContainer().getText());

    }
}

