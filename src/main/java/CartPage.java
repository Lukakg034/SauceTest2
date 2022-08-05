import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    public WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver=driver;
    }

    By checkoutButton=(By.name("checkout"));

    By continueShoppingButton=(By.id("continue-shopping"));

    By listOfItemsInYourCart=(By.xpath("//div[@class='inventory_item_name']"));

    public WebElement getCheckoutButton(){
        return driver.findElement(checkoutButton);
    }

    public WebElement getContinueShoppingButton(){
        return driver.findElement(continueShoppingButton);
    }

    public List<WebElement> getListOfItemsInYourCart(){
        return driver.findElements(listOfItemsInYourCart);
    }
}
