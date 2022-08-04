import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CartPageTest extends BaseTest{

    @Test()
    public void verifyUserAbleToRemoveItemFromCart() throws InterruptedException {

        LandingPage landingPage=new LandingPage(driver);
        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);

        //Adding 3 items to cart
        inventoryPage.getSauceLabsBackpack().click();
        inventoryPage.getSauceLabsBoltTShirt().click();
        inventoryPage.getSauceLabsBikeLight().click();
        inventoryPage.getShoppingCartBtn().click();
        Thread.sleep(3000);

        CartPage cartPage=new CartPage(driver);
        List<WebElement> cartItemList=cartPage.getListOfItemsInYourCart(); //kako da izolujem lokator da nadje samo naziv itema?
        for (WebElement itemName:cartItemList){
            System.out.println(itemName.getText());
        }

        //String items=cartPage.getListOfItemsInYourCart().getText();

    }
}
