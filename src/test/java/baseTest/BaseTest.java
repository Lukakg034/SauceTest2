package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void initialize(){

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver_106\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

    }
    @AfterMethod
    public void TeardownTest() {
        //driver.close(); //In version 106 of Chromedriver and version 105 of Chrome, this line causes occasional lag in tests
        //                  while trying to close browser.
        //                  Random tests are throwing  [WARNING]: Timed out connecting to Chrome, retrying...
        driver.quit();
    }

}



