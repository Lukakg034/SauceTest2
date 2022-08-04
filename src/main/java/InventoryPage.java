import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    public WebDriver driver;
    public InventoryPage(WebDriver driver){
        this.driver=driver;
    }


    //By productsContainer=(By.linkText("Products"));
    By productsContainer=(By.cssSelector(".title"));
    By shoppingCartContainer=(By.id("shopping_cart_container"));

    By shoppingCartContainerBtn=(By.cssSelector("a[class='shopping_cart_link']"));

    By sauceLabsBackpack=(By.id("add-to-cart-sauce-labs-backpack"));

    By sauceLabsBikeLight=(By.id("add-to-cart-sauce-labs-bike-light"));

    By sauceLabsBoltTShirt=(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));

    By sauceLabsFleeceJacket=(By.id("add-to-cart-sauce-labs-fleece-jacket"));

    By sauceLabsOnesie=(By.id("add-to-cart-sauce-labs-onesie"));

    By testAllTheThingsRed=(By.id("remove-test.allthethings()-t-shirt-(red)"));

    By shoppingCartContainerBadge=(By.xpath("//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']"));


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

    }
