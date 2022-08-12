import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckoutPageTest extends BaseTest {

    @Test
    public void verifyFirstNameFieldIsMandatory(){

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
        checkoutPage.getLastName().sendKeys("ASDFG");
        checkoutPage.getPostalCode().sendKeys("58216");
        checkoutPage.getContinueBtn().click();
        String errorMessage=checkoutPage.getErrorMessage().getText();

    Assert.assertEquals("Error: First Name is required", errorMessage, "Messages do not match.");
    }

    @Test
    public void verifyLastNameFieldIsMandatory(){
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
        checkoutPage.getFirstName().sendKeys("ASDFG");
        checkoutPage.getPostalCode().sendKeys("58216");
        checkoutPage.getContinueBtn().click();
        String errorMessage=checkoutPage.getErrorMessage().getText();
        Assert.assertEquals("Error: Last Name is required", errorMessage, "Messages do not match.");
    }

    @Test
    public void verifyZipCodeFieldIsMandatory(){
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
        checkoutPage.getContinueBtn().click();
        String errorMessage=checkoutPage.getErrorMessage().getText();
        Assert.assertEquals("Error: Postal Code is required", errorMessage, "Messages do not match.");
    }

    @Test
    public void verifyIfAllFieldsAreFilled(){
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

        Assert.assertTrue(checkoutPage.getFinishBtn().isDisplayed(), "Finish button to make order is not displayed.");
    }
}
