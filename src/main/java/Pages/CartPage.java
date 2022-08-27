package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class CartPage extends BasePage {


    public CartPage(WebDriver driver){
        super(driver);
    }

    By checkoutButton = By.name("checkout");

    By continueShoppingButton = By.id("continue-shopping");

    By listOfItemsInYourCart = By.xpath("//div[@class='inventory_item_name']");

    By removeBtn = By.xpath("//div[@class='btn btn_secondary btn_small cart_button']");

    By removeButtons = By.cssSelector("button[id*='remove']");

    By cartList = By.xpath("//div[@class='cart_list']");

    By removeBackpackItemFromCart = By.id("remove-sauce-labs-backpack");

    By sauceLabsBackpackCartItem = By.xpath("//div[text()='Sauce Labs Backpack']");

    By sauceLabsBikeLightCartItem = By.xpath("//div[text()='Sauce Labs Bike Light']");

    By sauceLabsTShirtCartItem = By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");

    public WebElement getCheckoutButton(){
        return driver.findElement(checkoutButton);
    }

    public List<WebElement> getListOfItemsInYourCart(){
        return driver.findElements(listOfItemsInYourCart);
    }

    public List<WebElement> getRemoveButtons(){
        return driver.findElements(removeButtons);
    }

    public WebElement getRemoveBackpackItemFromCart(){
        return driver.findElement(removeBackpackItemFromCart);
    }

    public WebElement getContinueShoppingButton(){
        return driver.findElement(continueShoppingButton);
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

    public boolean isBikeLightVisible(){
        try{
            driver.findElement(sauceLabsBikeLightCartItem);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean isTShirtVisible(){
        try{
            driver.findElement(sauceLabsTShirtCartItem);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
