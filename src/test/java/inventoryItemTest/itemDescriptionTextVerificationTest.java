package inventoryItemTest;

import Pages.InventoryPage;
import Pages.LandingPage;
import Pages.ProductDetailPage;
import baseTest.BaseTest;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class itemDescriptionTextVerificationTest extends BaseTest {
    @Test
    public void test(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.fillOutCredentials("standard_user","secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);
        ProductDetailPage productDetailPage=new ProductDetailPage(driver);

        String bikeLightInvPageDetails=inventoryPage.getProductDescriptionInDetailTextField("Sauce Labs Bike Light").getText();
        String onesieInvPageDetails=inventoryPage.getProductDescriptionInDetailTextField("Sauce Labs Onesie").getText();

        inventoryPage.getProductName(Constants.SAUCE_BIKE_LIGHT).click();

        String bikeLightProductPageDetails = productDetailPage.getProductDetails().getText();

        Assert.assertEquals(bikeLightInvPageDetails, bikeLightProductPageDetails);

        productDetailPage.getBackButton().click();

        inventoryPage.getProductName("Sauce Labs Onesie").click();
        String onesieProductPageDetails =productDetailPage.getProductDetails().getText();

        Assert.assertEquals(onesieInvPageDetails, onesieProductPageDetails);
    }
}
