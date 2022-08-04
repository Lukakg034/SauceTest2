import org.testng.annotations.Test;

import java.util.List;

public class InventoryPageTest extends BaseTest{


    @Test
    public void AddToCartTest() {


        LandingPage landingPage = new LandingPage(driver);
        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);

        //Adding 3 items to cart
        inventoryPage.getSauceLabsBackpack().click();
        inventoryPage.getSauceLabsBoltTShirt().click();
        inventoryPage.getSauceLabsBikeLight().click();
        System.out.println(inventoryPage.getShoppingCartBadge().getText());

    }

    @Test
    public void CartContainsAddItemsTest(){

        LandingPage landingPage = new LandingPage(driver);
        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);

        //Adding 3 items to cart
        inventoryPage.getSauceLabsBackpack().click();
        inventoryPage.getSauceLabsBoltTShirt().click();
        inventoryPage.getSauceLabsBikeLight().click();


        //String itemsInCart=inventoryPage.getShoppingCartBadge().getText();



    }
}
