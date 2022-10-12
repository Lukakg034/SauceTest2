package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class InventoryPage extends BasePage{

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    By productsPageTitle = By.cssSelector(".title");

    By shoppingCartIcon = By.id("shopping_cart_container");

    By shoppingCartContainerBtn = By.cssSelector("a[class='shopping_cart_link']");

    By backpackProductName = By.linkText("Sauce Labs Backpack");

    By bikeLightProductName = By.linkText("Sauce Labs Bike Light");

    By tShirtProductName = By.linkText("Sauce Labs Bolt T-Shirt");

    By onesieProductName = By.linkText("Sauce Labs Onesie");

    By sauceLabsBackpackAddButton = By.id("add-to-cart-sauce-labs-backpack");

    By sauceLabsBikeLightAddButton = By.id("add-to-cart-sauce-labs-bike-light");

    By sauceLabsBoltTShirtAddButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");

    By sauceLabsFleeceJacketAddButton = By.id("add-to-cart-sauce-labs-fleece-jacket");

    By sauceLabsOnesieAddButton = By.id("add-to-cart-sauce-labs-onesie");

    By testAllTheThingsRed = By.id("remove-test.allthethings()-t-shirt-(red)");

    By shoppingCartIconBadge = By.xpath("//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']");

    By inventoryListOfItemPrices = By.xpath("//div[@class='inventory_item_price']");

    By productsSortDropdown = By.xpath("//select[@class='product_sort_container']");

    By dropdownMenuLowToHighPriceSorter = By.xpath("//option[@value='lohi']"); //- low to high

    By ItemDescriptionTextOfAllTheItems = By.xpath("//*[@class='inventory_item_desc']");

    By backpackDescriptionInDetailTextField = By.cssSelector("div[class='inventory_details_desc large_size']");

    By bikeLightProductDetail1 = By.xpath("//a[@id='item_0_title_link']/parent::div/div");

    By bikeLightProductDetail2 = By.xpath("//a[@id='item_0_title_link']/following-sibling::div");

    By bikeLightProductDetail3 = By.xpath("//div[text()='Sauce Labs Bike Light']/parent::a/following-sibling::div");

    By onesieProductDetail = By.xpath("//div[text()='Sauce Labs Onesie']/parent::a/following-sibling::div");

//    public WebElement getProductDescriptionInDetailTextField(String itemText){
//
//        return driver.findElement(By.xpath(String.format("//div[text()='%s']/parent::a/following-sibling::div",itemText)));
//    }
    public WebElement getAddToCartButton(String itemText){
        return driver.findElement(By.xpath(String.format("//button[@id='add-to-cart-%s']", itemText)));
    }

    public WebElement getProductContainer(){
        return driver.findElement(productsPageTitle);
    }

    public WebElement getSauceLabsBackpackAddButton(){
        return driver.findElement(sauceLabsBackpackAddButton);
    }

    public WebElement getSauceLabsBikeLightAddButton(){
        return driver.findElement(sauceLabsBikeLightAddButton);
    }

    public WebElement getSauceLabsBoltTShirtAddButton(){
        return driver.findElement(sauceLabsBoltTShirtAddButton);
    }

    public WebElement getShoppingCartBadge(){
        return driver.findElement(shoppingCartIconBadge);
    }

    public WebElement getShoppingCartButton(){
        return driver.findElement(shoppingCartContainerBtn);
    }

    public List<WebElement> getPricesOfVisibleItems(){
        return  driver.findElements(inventoryListOfItemPrices);
    }

    public WebElement getDropdownMenuLowToHighPriceSorter(){
        return driver.findElement(dropdownMenuLowToHighPriceSorter);
    }

    public List <WebElement> getItemDescriptionTextOfAllTheItems(){
        return driver.findElements(ItemDescriptionTextOfAllTheItems);
    }

    public WebElement getBikeLightProductName(){
        return driver.findElement(bikeLightProductName);
    }

    public WebElement getProductDescriptionInDetailTextField(String itemText){

        return driver.findElement(By.xpath(String.format("//div[text()='%s']/parent::a/following-sibling::div",itemText)));
    }

    public WebElement getOnesieDescriptionInDetailTextField(){
        return driver.findElement(onesieProductDetail);
    }

    public WebElement getOnesieAddToCartButton(){
        return driver.findElement(sauceLabsOnesieAddButton);
    }

    public WebElement getProductName(String productText){

        return driver.findElement(By.xpath(String.format("//div[text()='%s']", productText)));
        //return driver.findElement(By.xpath(String.format("//div[text()='%s']/parent::a/following-sibling::div",productText)));
    }
    public WebElement getProductItemName(String itemName) {
        return driver.findElement(By.xpath(String.format("//button[@id='add-to-cart-%s']", itemName)));
    }

    public WebElement getTShirtProductName(){
        return driver.findElement(tShirtProductName);
    }

    public void addBackpackTShirtBikeLightToCart(){
        getSauceLabsBackpackAddButton().click();
        getSauceLabsBoltTShirtAddButton().click();
        getSauceLabsBikeLightAddButton().click();
    }
}
