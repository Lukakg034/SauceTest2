import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    public WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }


    //Da li je ok pokupiti sve lokatore sa stranice iako nisu inicijalno potrebni?
    //Cisto da postoje za eventualno kasnije testiranje?

    By firstName=(By.id("first-name"));

    By lastName=(By.id("last-name"));

    By postalCode=(By.id("postal-code"));

    By continueBtn=(By.id("continue"));

    By errorMessageContainer=(By.xpath("//div[@class='error-message-container error']"));

    By finishBtn=(By.id("finish"));

    By finishDisplayText=(By.xpath("//div[@class='complete-text']"));
    public WebElement getFirstName(){
        return driver.findElement(firstName);
    }

    public WebElement getLastName(){
        return driver.findElement(lastName);
    }

    public WebElement getPostalCode(){
        return driver.findElement(postalCode);
    }

    public WebElement getContinueBtn(){
        return driver.findElement(continueBtn);
    }

    public WebElement getErrorMessage(){
        return driver.findElement(errorMessageContainer);
    }

    public WebElement getFinishBtn(){
        return driver.findElement(finishBtn);
    }

    public WebElement getFinishText(){
        return driver.findElement(finishDisplayText);
    }
}
