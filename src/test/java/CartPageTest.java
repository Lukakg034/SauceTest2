import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class CartPageTest extends BaseTest{

    @Test()
    public void verifyUserAbleToRemoveItemFromCart(){

        LandingPage landingPage=new LandingPage(driver);
        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);

        inventoryPage.getSauceLabsBackpackAddButton().click();
        inventoryPage.getSauceLabsBoltTShirtAddButton().click();
        inventoryPage.getSauceLabsBikeLightAddButton().click();
        inventoryPage.getShoppingCartButton().click();

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

        List<WebElement> itemsToRemove=cartPage.getRemoveButtons();
        for (WebElement removeItem:itemsToRemove){
            removeItem.click();
        }

        Assert.assertTrue(cartPage.getListOfItemsInYourCart().isEmpty());
    }

    @Test
    public void verifyUserAbleToRemoveOnlyOneOfTheItems(){

        LandingPage landingPage=new LandingPage(driver);
        landingPage.getUsername().sendKeys("standard_user");
        landingPage.getPassword().sendKeys("secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);

        inventoryPage.getSauceLabsBackpackAddButton().click();
        inventoryPage.getSauceLabsBoltTShirtAddButton().click();
        inventoryPage.getSauceLabsBikeLightAddButton().click();
        inventoryPage.getShoppingCartButton().click();

        CartPage cartPage=new CartPage(driver);
        List<WebElement> cartItemList=cartPage.getListOfItemsInYourCart();
        List <String> itemList=new ArrayList<>();
        for (WebElement item:cartItemList){
            itemList.add(item.getText());
        }

        Assert.assertTrue(itemList.contains("Sauce Labs Backpack"));
        Assert.assertTrue(itemList.contains("Sauce Labs Bolt T-Shirt"));
        Assert.assertTrue(itemList.contains("Sauce Labs Bike Light"));

        cartPage.getRemoveBackpackItemFromCart().click();

        List<WebElement> cartItemListAfterRemovingItem=cartPage.getListOfItemsInYourCart();
        List<String> itemListWithoutRemovedItem=new ArrayList<>();
        for (WebElement item:cartItemListAfterRemovingItem){
            itemListWithoutRemovedItem.add(item.getText());
        }

        Assert.assertTrue(inventoryPage.getTShirtProductName().isDisplayed(), "TShirt item is not displayed ");
        Assert.assertFalse(cartPage.isBackpackVisible(), "Backpack item is displayed");
    }
}
