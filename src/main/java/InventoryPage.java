import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {

    public WebDriver driver;

    public InventoryPage(WebDriver driver){
        this.driver=driver;
    }

    By productsContainer=(By.cssSelector(".title"));

    By shoppingCartContainer=(By.id("shopping_cart_container"));

    By shoppingCartContainerBtn=(By.cssSelector("a[class='shopping_cart_link']"));

    By sauceLabsBackpack=(By.id("add-to-cart-sauce-labs-backpack"));

    By backpackLink=(By.linkText("Sauce Labs Backpack"));

   // By sauceLabsBackpackDescription=(By.cssSelector("div[class='inventory_item_desc']"));

    By sauceLabsBikeLight=(By.id("add-to-cart-sauce-labs-bike-light"));

    //By sauceLabsBikeLightDescription=()

    By sauceLabsBoltTShirt=(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));

    By sauceLabsFleeceJacket=(By.id("add-to-cart-sauce-labs-fleece-jacket"));

    By sauceLabsOnesie=(By.id("add-to-cart-sauce-labs-onesie"));

    By testAllTheThingsRed=(By.id("remove-test.allthethings()-t-shirt-(red)"));

    By shoppingCartContainerBadge=(By.xpath("//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']"));

    By inventoryListOfItems=(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_price']"));

    By productsSortContainer=(By.xpath("//select[@class='product_sort_container']"));

    By dropdownContainerSortOptions=(By.xpath("//select[@class='product_sort_container']//option[@value]"));

    By priceLowToHigh=(By.xpath("//option[@value='lohi']")); //- low to high

    By inventoryPageItemDescriptionText=(By.xpath("//*[@class='inventory_item_desc']"));

    By backpackDescriptionTxt=(By.cssSelector("div[class='inventory_details_desc large_size']"));

    public WebElement getProductContainer(){
        return driver.findElement(productsContainer);
    }

    public WebElement getCartContainer(){
        return driver.findElement(shoppingCartContainer);
    }

    public WebElement getSauceLabsBackpack(){
        return driver.findElement(sauceLabsBackpack);
    }

    public WebElement getSauceLabsBikeLight(){
        return driver.findElement(sauceLabsBikeLight);
    }

    public WebElement getSauceLabsBoltTShirt(){
        return driver.findElement(sauceLabsBoltTShirt);
    }

    public WebElement getSauceLabsFleeceJacket(){
        return driver.findElement(sauceLabsFleeceJacket);
    }

    public WebElement getSauceLabsOnesie(){
        return driver.findElement(sauceLabsOnesie);
    }

    public WebElement getAllTheThingsRed(){
        return driver.findElement(testAllTheThingsRed);
    }

    public WebElement getShoppingCartBadge(){
        return driver.findElement(shoppingCartContainerBadge);
    }

    public WebElement getShoppingCartBtn(){
        return driver.findElement(shoppingCartContainerBtn);
    }

    public List<WebElement> getInventoryListOfItems(){
        return  driver.findElements(inventoryListOfItems);
    }

    public WebElement getSortBtn(){
        return driver.findElement(productsSortContainer);
    }

    public List<WebElement> getContainerSortOptions(){
        return driver.findElements(dropdownContainerSortOptions);
    }

    public WebElement getLowToHighPrice(){
        return driver.findElement(priceLowToHigh);
    }

    public WebElement getItemDescription(){
        return driver.findElement(inventoryPageItemDescriptionText);
    }

    public WebElement getBackpackLink(){
        return driver.findElement(backpackLink);
    }

    public WebElement getBackpackDescriptionText(){
        return driver.findElement(backpackDescriptionTxt);
    }
}
