import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    public WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    By firstName = By.id("first-name");

    By lastName = By.id("last-name");

    By postalCode = By.id("postal-code");

    By continueBtn = By.id("continue");

    By errorMessageContainer = By.xpath("//div[@class='error-message-container error']");

    By finishBtn = By.id("finish");

    By finishDisplayText = By.xpath("//div[@class='complete-text']");

    public WebElement getFirstNameInputField(){
        return driver.findElement(firstName);
    }

    public WebElement getLastNameInputField(){
        return driver.findElement(lastName);
    }

    public WebElement getPostalCodeInputField(){
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
