package Pageelements;

import UtilitiesForElements.GenericMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriverbase.DriverManager;
import static junit.framework.TestCase.fail;

import java.util.List;

public class ShoppingBagPage extends DriverManager {


    @FindBy(css = ".primary-button-medium-wide.proceed-to-purchase.position-top")
    private WebElement proceedToPurchase;


    @FindBy(className = "basket-item-designer")
    private WebElement productInBag;




   public void proceedToPurchase() {
       proceedToPurchase.click();
       GenericMethods.refreshPage(driver);

   }

   public String productTitle(){
       return productInBag.getText();

}





}
