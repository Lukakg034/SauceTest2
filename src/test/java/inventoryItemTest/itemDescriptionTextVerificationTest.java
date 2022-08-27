package inventoryItemTest;

import Pages.InventoryPage;
import Pages.LandingPage;
import baseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class itemDescriptionTextVerificationTest extends BaseTest {
    @Test
    public void test(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.fillOutCredentials("standard_user","secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage=new InventoryPage(driver);

        List<WebElement> itemDescriptionOfAllTheItems=inventoryPage.getItemDescriptionTextOfAllTheItems();
        List<String> inventoryItemListDescriptions = inventoryPage.extractItemTextFromVisibleElements(itemDescriptionOfAllTheItems);

        String bikeLightProductText=inventoryItemListDescriptions.get(1);

        inventoryPage.getBikeLightProductName().click();

        String bikeLightDetailDescriptionText = inventoryPage.getBikeLightDescriptionInDetailTextField().getText();

        Assert.assertEquals(bikeLightProductText, bikeLightDetailDescriptionText, "Descriptions do not match.");
        Assert.assertEquals(inventoryItemListDescriptions.get(1), bikeLightDetailDescriptionText, "Descriptions do not match.");

    }
}
