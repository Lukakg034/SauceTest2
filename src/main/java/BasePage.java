import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    public WebDriver driver;

    public WebDriver initializeDriver(){

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;

    }
}
