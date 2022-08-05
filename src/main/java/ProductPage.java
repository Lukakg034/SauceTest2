import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    public WebDriver driver;

    //By productsContainer=(By.linkText("Products"));
    By productsContainer=(By.cssSelector(".title"));


    public ProductPage(WebDriver driver){this.driver=driver;}


     public WebElement getProductContainer(){return driver.findElement(productsContainer);}

    }
