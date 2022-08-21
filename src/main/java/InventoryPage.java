import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {

    public WebDriver driver;

    public InventoryPage(WebDriver driver){
        this.driver=driver;
    }

    By productsPageTitle = By.cssSelector(".title");

    By shoppingCartContainer = By.id("shopping_cart_container");

    By shoppingCartContainerBtn = By.cssSelector("a[class='shopping_cart_link']");

    By sauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");

    By backpackProductName = By.linkText("Sauce Labs Backpack");

    By bikeLightProductName = By.linkText("Sauce Labs Bike Light");

    By tShirtProductName = By.linkText("Sauce Labs Bolt T-Shirt");

    By sauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");

    By sauceLabsBoltTShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");

    By sauceLabsFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");

    By sauceLabsOnesie = By.id("add-to-cart-sauce-labs-onesie");

    By testAllTheThingsRed = By.id("remove-test.allthethings()-t-shirt-(red)");

    By shoppingCartContainerBadge = By.xpath("//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']");

    By inventoryListOfItems = By.xpath("//div[@class='inventory_item_price']");

    By productsSortContainer = By.xpath("//select[@class='product_sort_container']");

    By dropdownLowToHighSorter = By.xpath("//option[@value='lohi']"); //- low to high

    By inventoryPageItemDescriptionText = By.xpath("//*[@class='inventory_item_desc']");

    By backpackDescriptionInDetailTextField = By.cssSelector("div[class='inventory_details_desc large_size']");

    By bikeLightDescriptionInDetailTextField = By.cssSelector("div[class='inventory_details_desc large_size']");

    public WebElement getProductContainer(){
        return driver.findElement(productsPageTitle);
    }

    public WebElement getCartContainer(){
        return driver.findElement(shoppingCartContainer);
    }

    public WebElement getSauceLabsBackpackAddButton(){
        return driver.findElement(sauceLabsBackpack);
    }

    public WebElement getSauceLabsBikeLightAddButton(){
        return driver.findElement(sauceLabsBikeLight);
    }

    public WebElement getSauceLabsBoltTShirtAddButton(){
        return driver.findElement(sauceLabsBoltTShirt);
    }

    public WebElement getSauceLabsFleeceJacketAddButton(){
        return driver.findElement(sauceLabsFleeceJacket);
    }

    public WebElement getSauceLabsOnesieAddButton(){
        return driver.findElement(sauceLabsOnesie);
    }

    public WebElement getAllTheThingsRedAddButton(){
        return driver.findElement(testAllTheThingsRed);
    }

    public WebElement getShoppingCartBadge(){
        return driver.findElement(shoppingCartContainerBadge);
    }

    public WebElement getShoppingCartButton(){
        return driver.findElement(shoppingCartContainerBtn);
    }

    public List<WebElement> getInventoryListOfAllTheItems(){
        return  driver.findElements(inventoryListOfItems);
    }

    public WebElement getSortBtn(){
        return driver.findElement(productsSortContainer);
    }

    public WebElement getDropdownLowToHighPrice(){
        return driver.findElement(dropdownLowToHighSorter);
    }

    public List <WebElement> getItemDescriptionOfAllTheItems(){
        return driver.findElements(inventoryPageItemDescriptionText);
    }

    public WebElement getBackpackProductName(){
        return driver.findElement(backpackProductName);
    }
    public WebElement getBikeLightProductName(){
        return driver.findElement(bikeLightProductName);
    }

    public WebElement getbackpackDescriptionInDetailTextField(){
        return driver.findElement(backpackDescriptionInDetailTextField);
    }

    public WebElement getBikeLightDescriptionInDetailTextField(){
        return driver.findElement(bikeLightDescriptionInDetailTextField);
    }

    public WebElement getTShirtProductName(){
        return driver.findElement(tShirtProductName);
    }

}
