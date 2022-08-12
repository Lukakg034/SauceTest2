import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;

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
    }

    @Test
    public void InventoryItemList() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);

        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);
        System.out.println(inventoryPage.getInventoryListOfItems().size());

        List<WebElement> priceOfAllTheItems=inventoryPage.getInventoryListOfItems();
        List<String> priceOfAllItems=new ArrayList<>();
        for (WebElement itemPrice:priceOfAllTheItems){
            priceOfAllItems.add(itemPrice.getText());
        }
        System.out.println(priceOfAllItems);

        inventoryPage.getLowToHighPrice().click();
        List<WebElement> lowToHighItemList=inventoryPage.getInventoryListOfItems();
        List<String> lowToHighPrices=new ArrayList<>();
        for (WebElement itemPrice:lowToHighItemList){
            lowToHighPrices.add(itemPrice.getText());
        }

        System.out.println(lowToHighPrices);
        Assert.assertNotEquals(priceOfAllItems, lowToHighPrices, "Expected not to be equals because the second list is sorted from low to high price");

        //remove $ and convert to Double
        List<Double> pricesWithoutDollar=new ArrayList<>();
        for (String item:lowToHighPrices){
            String[] removeDollar=item.split("[$]");
            String formatedItems=removeDollar[1].trim();
            Double priceWithoutSign=Double.valueOf(formatedItems);
            pricesWithoutDollar.add(priceWithoutSign);
        }

        //Assert.assertEquals(pricesWithoutDollar,);
        System.out.println(pricesWithoutDollar);

//        for (double i = 0.0; i<pricesWithoutDollar; i++){
//            assertTrue(pricesWithoutDollar.get(i) < (pricesWithoutDollar(i++)));
//
//        }


//        inventoryPage.getSortBtn().click();
//        List<WebElement> sortItemsList=inventoryPage.getContainerSortOptions();
//        for (WebElement sortItems:sortItemsList){
//            sortItems.click();
//        }

        Thread.sleep(2000);


      /*
         List<WebElement> cartItemList=cartPage.getListOfItemsInYourCart();
        List<String> itemNameList=new ArrayList<>();
        for (WebElement item:cartItemList){
            itemNameList.add(item.getText());
        }
         */

    }
    @Test
    public void itemDescriptionTextVerification() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);
        String descriptionTxt=inventoryPage.getItemDescription().getText();
        System.out.println(descriptionTxt);

        inventoryPage.getBackpackLink().click();

        Thread.sleep(1000);

        String backpackDescTxt=inventoryPage.getBackpackDescriptionText().getText();
        System.out.println(backpackDescTxt);

        Assert.assertEquals(descriptionTxt, backpackDescTxt, "Descriptions do not match.");
        //checking if the order affects the assertation
        driver.navigate().back();
        Thread.sleep(1000);
        inventoryPage.getLowToHighPrice().click();
        Assert.assertEquals(descriptionTxt, backpackDescTxt, "Descriptions do not match.");
    }
}
