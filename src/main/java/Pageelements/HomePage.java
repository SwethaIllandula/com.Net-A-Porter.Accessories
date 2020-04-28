package Pageelements;

import UtilitiesForElements.GenericMethods;
import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;
import webdriverbase.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends DriverManager {

    public static String searchProducts;


    @FindBy(css = "a[title='NET-A-PORTER']")
    private WebElement title;

    @FindBy(css ="a.deliver-component-CloseButton.deliver-component-CloseButton--transparent")
    private WebElement closeLink;

    @FindBy(css = "a[href*='Shop/Accessories?']")
    private WebElement moveToAccessories;

   @FindBy(linkText = "All Accessories")
    private WebElement clickAllAccessories;

    @FindBy(linkText = "Hair Accessories")
    private WebElement hairAccessorieslink;

    @FindBy(xpath = "(//div[@class='sf-search'])[2]")
    private WebElement search;

    @FindBy(xpath = "(//div[@class='sf-search__header'])[2]/form/input[@name='keywords']")
    private WebElement searchBox;

    @FindBy(xpath = "(//div[@class='sf-search__header'])[2]/form/input[@type='submit']")
    private WebElement searchButton;

    @FindBy(css = ".sf-nav__featured-designers ul li")
    private List<WebElement> featuredDesigners;


   public HomePage(){
   }


   public String getPageTitle(){
    return GenericMethods.getTitle(driver);}


    public void searchWithKeywords(String products){
    closeLink.click();
    search.click();
    searchBox.clear();
    searchProducts = products;
    enterSearchItem(products);
    searchButton.click();
      }

  public void enterSearchItem(String products){
        searchBox.sendKeys(products);}




   public void  moveToHairAccessories(){
       closeLink.click();
       GenericMethods.actionsToMoveElement(driver,moveToAccessories);
      hairAccessorieslink.click();

   }

public void allAccessories(){
       closeLink.click();
       GenericMethods.actionsToMoveElement(driver,moveToAccessories);
       clickAllAccessories.click();

}


public void selectFromFeaturedDesigners(String designers){
          int designerList= featuredDesigners.size();
       for(WebElement Designers:featuredDesigners){
           if(Designers.getText().equalsIgnoreCase("Gucci")){
               System.out.println(Designers.getText());
               Designers.click();
               break;
           }

       if(designerList==0){
           TestCase.fail("Designer is not Available");
       }

       }
}


}
