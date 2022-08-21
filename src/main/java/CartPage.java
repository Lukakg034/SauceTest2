import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class CartPage {

    public WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver=driver;
    }

    By checkoutButton = By.name("checkout");

    By continueShoppingButton = By.id("continue-shopping");

    By listOfItemsInYourCart = By.xpath("//div[@class='inventory_item_name']");

    By removeBtn = By.xpath("//div[@class='btn btn_secondary btn_small cart_button']");

    By removeButtons = By.cssSelector("button[id*='remove']");

    By cartList = By.xpath("//div[@class='cart_list']");

    By removeBackpackItemFromCart = By.id("remove-sauce-labs-backpack");

    By sauceLabsBackpackCartItem = By.xpath("//div[text()='Sauce Labs Backpack']");

    public WebElement getCheckoutButton(){
        return driver.findElement(checkoutButton);
    }

    public WebElement getContinueShoppingButton(){
        return driver.findElement(continueShoppingButton);
    }

    public List<WebElement> getListOfItemsInYourCart(){
        return driver.findElements(listOfItemsInYourCart);
    }

    public List<WebElement> getRemoveButtons(){
        return driver.findElements(removeButtons);
    }

    public WebElement getRemoveBtn(){
        return driver.findElement(removeBtn);
    }

    public WebElement getCartList(){
        return driver.findElement(cartList);
    }

    public WebElement getRemoveBackpackItemFromCart(){
        return driver.findElement(removeBackpackItemFromCart);
    }

    public WebElement getSauceLabsBackpackCartItem(){
        return driver.findElement(sauceLabsBackpackCartItem);
    }

    public boolean isBackpackVisible(){
        try {
            driver.findElement(sauceLabsBackpackCartItem);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }


}
