package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage{

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    By firstNameInputField = By.id("first-name");

    By lastNameInputField = By.id("last-name");

    By postalCodeInputField = By.id("postal-code");

    By continueButton = By.id("continue");

    By errorMessage = By.xpath("//div[@class='error-message-container error']");

    By finishOrderButton = By.id("finish");

    By finishOrderDisplayText = By.xpath("//div[@class='complete-text']");

    public WebElement getFirstNameInputField(){
        return driver.findElement(firstNameInputField);
    }

    public WebElement getLastNameInputField(){
        return driver.findElement(lastNameInputField);
    }

    public WebElement getPostalCodeInputField(){
        return driver.findElement(postalCodeInputField);
    }

    public WebElement getContinueButton(){
        return driver.findElement(continueButton);
    }

    public WebElement getErrorMessage(){
        return driver.findElement(errorMessage);
    }

    public WebElement getFinishOrderButton(){
        return driver.findElement(finishOrderButton);
    }

    public WebElement getFinishOrderDisplayText(){
        return driver.findElement(finishOrderDisplayText);
    }

    public void fillOutCheckoutInputFields(String firstName, String lastName, String postalCode){
        getFirstNameInputField().sendKeys(firstName);
        getLastNameInputField().sendKeys(lastName);
        getPostalCodeInputField().sendKeys(postalCode);
    }
}
