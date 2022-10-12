package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(WebDriver driver){
        super(driver);
    }


    By productPageDetails = By.cssSelector("div[class='inventory_details_desc large_size']");
    By backToProductsButton = By.id("back-to-products");



    public WebElement getProductDetails(){
        return driver.findElement(productPageDetails);
    }
    public WebElement getBackButton(){return driver.findElement(backToProductsButton);}
}
