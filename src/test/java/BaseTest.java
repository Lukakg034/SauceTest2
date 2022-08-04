import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public WebDriver driver;

    @BeforeTest
    public void initialize(){

        System.setProperty("webdriver.chrome.driver", "d:\\QA Projects\\QAPractiseTests\\src\\main\\resources\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

    }

    @AfterTest
    public void TeardownTest() {
        driver.close();
        driver.quit();
    }
}



