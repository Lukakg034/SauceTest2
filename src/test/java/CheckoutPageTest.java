import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutPageTest extends BaseTest {

    @Test
    public void verifyFirstNameFieldIsMandatory(){

        LandingPage landingPage=new LandingPage(driver);
        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);
        inventoryPage.getSauceLabsBackpackAddButton().click();
        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage=new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.getLastNameInputField().sendKeys("ASDFG");
        checkoutPage.getPostalCodeInputField().sendKeys("58216");
        checkoutPage.getContinueBtn().click();

        Assert.assertEquals("Error: First Name is required", checkoutPage.getErrorMessage().getText(), "Messages do not match.");
    }

    @Test
    public void verifyLastNameFieldIsMandatory(){
        LandingPage landingPage=new LandingPage(driver);
        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);
        inventoryPage.getSauceLabsBackpackAddButton().click();
        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage=new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.getFirstNameInputField().sendKeys("ASDFG");
        checkoutPage.getPostalCodeInputField().sendKeys("58216");
        checkoutPage.getContinueBtn().click();

        Assert.assertEquals("Error: Last Name is required", checkoutPage.getErrorMessage().getText(), "Messages do not match.");
    }

    @Test
    public void verifyZipCodeFieldIsMandatory(){
        LandingPage landingPage=new LandingPage(driver);
        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);
        inventoryPage.getSauceLabsBackpackAddButton().click();
        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage=new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.getFirstNameInputField().sendKeys("QWERTY");
        checkoutPage.getLastNameInputField().sendKeys("asdeqwe");
        checkoutPage.getContinueBtn().click();

        Assert.assertEquals("Error: Postal Code is required", checkoutPage.getErrorMessage().getText(), "Messages do not match.");
    }

    @Test
    public void verifyIfAllFieldsAreFilled(){
        LandingPage landingPage=new LandingPage(driver);
        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);
        inventoryPage.getSauceLabsBackpackAddButton().click();
        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage=new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage=new CheckoutPage(driver);
        checkoutPage.getFirstNameInputField().sendKeys("QWERTY");
        checkoutPage.getLastNameInputField().sendKeys("asdeqwe");
        checkoutPage.getPostalCodeInputField().sendKeys("58216");
        checkoutPage.getContinueBtn().click();

        Assert.assertTrue(checkoutPage.getFinishBtn().isDisplayed(), "Finish button to make order is not displayed.");
    }
}
