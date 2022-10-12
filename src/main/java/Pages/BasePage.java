package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class BasePage {


    public WebDriver driver;

    public BasePage(WebDriver driver) {this.driver=driver;}

    public List<String> extractItemTextFromVisibleElements(List<WebElement> randomFandomItemList){

        List<String> myList = new ArrayList<>();
        for (WebElement item : randomFandomItemList) {
            myList.add(item.getText());
        }
        return myList;
    }

    public List<String> removingDollarSignFromString(List<String> inventoryItemPricesWithDollar){
        List<String> inventoryItemPricesWithoutDollar = new ArrayList<>();
        for (String item:inventoryItemPricesWithDollar){
            String[] removeDollar = item.split("[$]");
            String formatedItems = removeDollar[1].trim();
            inventoryItemPricesWithoutDollar.add(formatedItems);
        }
        return inventoryItemPricesWithoutDollar;
    }

    public List<Double> convertingPricesFromStringToDouble(List<String> inventoryItemsWithoutDollar){
        List<Double> itemPricesToConvert = new ArrayList<>();
        for (String item:inventoryItemsWithoutDollar){
            Double itemPrices = Double.valueOf(item);
            itemPricesToConvert.add(itemPrices);
        }
        return itemPricesToConvert;
    }
}
