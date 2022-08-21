import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class InventoryPageTest extends BaseTest{

    @Test
    public void AddToCartTest() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);

        inventoryPage.getSauceLabsBackpackAddButton().click();
        inventoryPage.getSauceLabsBoltTShirtAddButton().click();
        inventoryPage.getSauceLabsBikeLightAddButton().click();
        System.out.println(inventoryPage.getShoppingCartBadge().getText());

    }

    @Test
    public void CartContainsAddItemsTest(){

        LandingPage landingPage = new LandingPage(driver);
        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);

        inventoryPage.getSauceLabsBackpackAddButton().click();
        inventoryPage.getSauceLabsBoltTShirtAddButton().click();
        inventoryPage.getSauceLabsBikeLightAddButton().click();
    }

    @Test
    public void InventoryItemList(){
        LandingPage landingPage = new LandingPage(driver);

        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);

        List<WebElement> priceOfAllTheItems=inventoryPage.getInventoryListOfAllTheItems();
        List<String> priceOfAllItems=new ArrayList<>();
        for (WebElement itemPrice:priceOfAllTheItems){
            priceOfAllItems.add(itemPrice.getText());
        }

        List<Double> pricesWithoutDollar=new ArrayList<>();
        for (String item:priceOfAllItems){
            String[] removeDollar=item.split("[$]");
            String formatedItems=removeDollar[1].trim();
            Double priceWithoutSign=Double.valueOf(formatedItems);
            pricesWithoutDollar.add(priceWithoutSign);
        }

        inventoryPage.getDropdownLowToHighPrice().click();

        List<WebElement> lowToHighItemList=inventoryPage.getInventoryListOfAllTheItems();
        List<String> lowToHighPrices=new ArrayList<>();
        for (WebElement itemPrice:lowToHighItemList){
            lowToHighPrices.add(itemPrice.getText());
        }

        Assert.assertNotEquals(priceOfAllItems, lowToHighPrices, "Expected not to be equals because the second list is sorted from low to high price");

        List<Double> pricesWithoutDollarSorted=new ArrayList<>();
        for (String item:lowToHighPrices){
            String[] removeDollar=item.split("[$]");
            String formatedItems=removeDollar[1].trim();
            Double priceWithoutSign=Double.valueOf(formatedItems);
            pricesWithoutDollarSorted.add(priceWithoutSign);
        }

        Assert.assertEquals(pricesWithoutDollar, pricesWithoutDollarSorted);

        for (int i=0; i<pricesWithoutDollarSorted.size()-1; i++){
            double itemPrice=pricesWithoutDollarSorted.get(i);
            double nextItemPriceInList=pricesWithoutDollarSorted.get(i+1);
            Assert.assertTrue(itemPrice<=nextItemPriceInList, "Item prices are not in ascending order.");

        }
    }

    @Test
    public void itemDescriptionTextVerification() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);

        List<WebElement> itemDescriptionOfAllTheItems=inventoryPage.getItemDescriptionOfAllTheItems();
        List<String> inventoryItemListDescriptions=new ArrayList<>();
        for (WebElement singleItemDescription:itemDescriptionOfAllTheItems){
            inventoryItemListDescriptions.add(singleItemDescription.getText());
        }
        String bikeLightProductText=inventoryItemListDescriptions.get(1);

        inventoryPage.getBikeLightProductName().click();

        String bikeLightDetailDescriptionText = inventoryPage.getBikeLightDescriptionInDetailTextField().getText();

        Assert.assertEquals(bikeLightProductText, bikeLightDetailDescriptionText, "Descriptions do not match.");
        Assert.assertEquals(inventoryItemListDescriptions.get(1), bikeLightDetailDescriptionText, "Descriptions do not match.");

    }
}
