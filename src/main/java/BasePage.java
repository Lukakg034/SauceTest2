import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    public WebDriver driver;

    public Properties prop;

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("src\\main\\resources\\data.properties");
        prop.load(fis);
//    String browserName="chrome";
        driver=new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "d:\\QA Projects\\QAPractiseTests\\src\\main\\resources\\chromedriver.exe");
        //ChromeOptions options = new ChromeOptions();

        driver.manage().window().maximize();
        return driver;
//    if (browserName.contains("chrome")){
//        System.setProperty("webdriver.chrome.driver", "D:\\QA Projects\\chromedriver.exe");
//        ChromeOptions options=new ChromeOptions();
//        driver=new ChromeDriver(options);
//    } else if (browserName.contains("firefox")) {
//        System.setProperty("webdriver.gecko.driver", "D:\\QA Projects\\geckodriver.exe");
//        FirefoxOptions options=new FirefoxOptions();
//        driver=new FirefoxDriver(options);
//    }
//    driver.manage().window().maximize();
//    return driver;
//    }
    }
}
