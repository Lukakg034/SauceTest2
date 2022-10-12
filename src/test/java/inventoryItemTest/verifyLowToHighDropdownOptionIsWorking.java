package inventoryItemTest;
import Pages.InventoryPage;
import Pages.LandingPage;
import baseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class verifyLowToHighDropdownOptionIsWorking extends BaseTest {
    @Test
    public void test() {
        LandingPage landingPage = new LandingPage(driver);

        landingPage.fillOutCredentials("standard_user","secret_sauce");
        landingPage.getLoginButton().click();

        InventoryPage inventoryPage = new InventoryPage(driver);

        List<WebElement> priceOfAllTheItems = inventoryPage.getPricesOfVisibleItems();
        List<String> priceOfAllItems = inventoryPage.extractItemTextFromVisibleElements(priceOfAllTheItems);
        List<String> pricesWithoutDollar= inventoryPage.removingDollarSignFromString(priceOfAllItems);
        List<Double> itemPricesUnsorted= inventoryPage.convertingPricesFromStringToDouble(pricesWithoutDollar);

        inventoryPage.getDropdownMenuLowToHighPriceSorter().click();

        List<WebElement> lowToHighItemList = inventoryPage.getPricesOfVisibleItems();
        List<String>lowToHighPrices = inventoryPage.extractItemTextFromVisibleElements(lowToHighItemList);
        List<String> pricesWithoutDollarSorted = inventoryPage.removingDollarSignFromString(lowToHighPrices);
        List<Double> pricesWithoutSignSorted = inventoryPage.convertingPricesFromStringToDouble(pricesWithoutDollarSorted);

        Assert.assertNotEquals(itemPricesUnsorted, pricesWithoutSignSorted, "Expected not to be equals because the second list is sorted from low to high price");

        for (int i = 0; i < pricesWithoutSignSorted.size() - 1; i++) {
            double itemPrice = pricesWithoutSignSorted.get(i);
            double nextItemPriceInList = pricesWithoutSignSorted.get(i + 1);
            Assert.assertTrue(itemPrice <= nextItemPriceInList, "Item prices are not in ascending order.");
        }
    }
}
