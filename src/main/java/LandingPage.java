import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasePage{

    By username = By.cssSelector("input[placeholder='Username']");

    By password = By.id("password");

    By loginButton = By.id("login-button");

    By errorMessage = By.cssSelector("div[class='error-message-container error']");

    public LandingPage(WebDriver driver){

        this.driver=driver;
    }

    public WebElement getUsername(){

        return driver.findElement(username);
    }

    public WebElement getPassword(){
        return driver.findElement(password);
    }

    public WebElement getLoginButton(){
        return driver.findElement(loginButton);
    }

    public WebElement getErrorMessage(){
        return driver.findElement(errorMessage);
    }
}
