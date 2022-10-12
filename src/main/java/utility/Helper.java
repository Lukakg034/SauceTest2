package utility;
import org.openqa.selenium.NoSuchElementException;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebElement;

//This class contains all helper methods
public class Helper {

    public String getRenamedItemString(String itemName){
        return itemName.toLowerCase().replace(" ","-");
    }
}
