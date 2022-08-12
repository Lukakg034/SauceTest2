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
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;

    }
}
