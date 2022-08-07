import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
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
        List<WebElement> cartItemList=cartPage.getListOfItemsInYourCart();
        List<String> itemNameList=new ArrayList<>();
        for (WebElement item:cartItemList){
            itemNameList.add(item.getText());
        }

        Assert.assertTrue(itemNameList.contains("Sauce Labs Bolt T-Shirt"));
        Assert.assertTrue(itemNameList.contains("Sauce Labs Backpack"));
        Assert.assertTrue(itemNameList.contains("Sauce Labs Bike Light"));

        Assert.assertEquals(itemNameList.get(1) ,"Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(itemNameList.get(0) ,("Sauce Labs Backpack"));
        Assert.assertEquals(itemNameList.get(2),("Sauce Labs Bike Light"));

//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(1));

        List<WebElement> itemsToRemove=cartPage.getRemoveButtons();
        for (WebElement removeItem:itemsToRemove){
//            driver.wait();
            removeItem.click();
        }

        Assert.assertTrue(cartPage.getListOfItemsInYourCart().isEmpty());
        //Optional assert
        // Assert.assertFalse(cartPage.getRemoveBtn().isDisplayed());

    }
}
