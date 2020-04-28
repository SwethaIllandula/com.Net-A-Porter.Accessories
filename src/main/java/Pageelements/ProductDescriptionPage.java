package Pageelements;

import UtilitiesForElements.GenericMethods;
import junit.framework.TestCase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriverbase.DriverManager;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static junit.framework.TestCase.fail;

public class ProductDescriptionPage extends DriverManager{


      @FindBy(css = ".ProductListingPage43__layoutGrid a")
      private List<WebElement> accessoriesList;

      @FindBy(xpath = "//div[@class='ProductListingPage43__layoutGrid']/div/a")
      private List<WebElement> listAccessories;

      @FindBy(css=".CombinedSelect11__customizedSelect ul li")
      private List<WebElement> randomSize;

      @FindBy(css = "button[class$='addToBag primaryButton']")
     // css = "button.Button10.Button10--primary.AsyncButton10.CTAButtons77__addToBag.primaryButton ")
      private WebElement addToBag;

      @FindBy(xpath = "(//label[@class='AccordionSection2__heading openLabel'])[3]")
      private WebElement filterColours;

      @FindBy(xpath = "(//label[@class='AccordionSection2__heading openLabel'])[4]")
      private WebElement filterBrands;

      @FindBy(xpath = "(//label[@class='AccordionSection2__heading openLabel'])[1]")
      private WebElement filterCategories;

      @FindBy(xpath = "(//label[@class='AccordionSection2__heading openLabel'])[2]")
      private WebElement filterAccessories;

      @FindBy(css= ".Swatch6.Filter43__swatch")
      private List<WebElement>colours;

      @FindBy(css = ".DesignerFilterGroup43__list div a")
      private List<WebElement> brands;

      @FindBy(css="a[href ^='/en-gb/shop/accessories/sunglasses/']")
      private List<WebElement> typesOfSunglasses;

      @FindBy(linkText = "Sunglasses")
      private WebElement sunGlasses;

      @FindBy(className = "Header5__title")
      private WebElement pageTitleElement;

      @FindBy(className = "Header5__headingsContainer")
      private WebElement titleOfThePage;

      @FindBy(className = "ProductInformation77__designer")
      private WebElement productTitle;

    @FindBy(css = "a[title='Shopping bag']")
    private WebElement checkShoppingBag;




public String getProductTitle(){
   return productTitle.getText();
}



public void productsOnThePage(){

    int productsAvailable = listAccessories.size();
    System.out.println("Products available are :"+productsAvailable);
    if(productsAvailable==0){
        fail("No Products Available on page");
    }
int products=  GenericMethods.randomNumberHelper(productsAvailable);
 WebElement randomProduct= listAccessories.get(products);
 System.out.println("Product Selected is  "  +randomProduct.getText());
 randomProduct.click();

 //int Size =GenericMethods.randomNumberHelper(randomSize.size());
 //WebElement chooseSize = randomSize.get(Size);
 //chooseSize.click();


}



    public void selectRandomProduct(){
    int Products =GenericMethods.randomNumberHelper(listAccessories.size());
    if(Products==0){
    TestCase.fail("No Products Available");}
    WebElement chooserandomProduct  = listAccessories.get(Products);
    chooserandomProduct.click();
    GenericMethods.refreshPage(driver);

}

    public String pageTitle(){
    return titleOfThePage.getText();
}

public void addProductToBag() throws InterruptedException {
GenericMethods.refreshPage(driver);
    addToBag.click();
    checkShoppingBag.click();
    if(checkShoppingBag.equals("out of stock")){
    fail("Item is out of stock");}
    GenericMethods.refreshPage(driver);

}


}
