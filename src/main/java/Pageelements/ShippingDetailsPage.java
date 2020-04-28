package Pageelements;

import UtilitiesForElements.GenericMethods;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriverbase.DriverManager;

import java.util.List;

public class ShippingDetailsPage extends DriverManager {

  @FindBy(css="#titleSelect")
  private WebElement title;

  @FindBy(xpath = "//input[@id='address.firstName']")
  private WebElement firstname;

  @FindBy(xpath = "//input[@id='address.lastName']")
  private WebElement lastname;

  @FindBy(css = "#country")
  private WebElement country;

  @FindBy(xpath = "//input[@id='address.address1']")
  private WebElement address1;

  @FindBy(id="address.towncity")
  private WebElement townCity;

  @FindBy(id="address.postcode")
  private WebElement postcode;

  @FindBy(id="address.work")
  private WebElement telePhone;

  @FindBy(css ="#billing_same")
  private WebElement radioBillingSameAddress;

  @FindBy(css="input#purchasenow")
  private WebElement proceedToPurchase;

  @FindBy(xpath = "//div/h1/span[contains(text(),'SHIPPING ADDRESS')]")
  WebElement pageTitle;

  @FindBy(className = "product-manufacturer")
  WebElement productSummary;

  @FindBy(id="proceedToPurchase")
  WebElement confirmPurchase;

  @FindBy(xpath = "//div[@id='shipping_address']//div")
  WebElement shippingInfo;

  @FindBy(css = "div.shipping-address-container")
  WebElement finalShippingInfo;


  public String titleOfThePage(){
      return pageTitle.getText();
  }

    public void fillShippingForm(String Firstname, String Lastname, String Address1, String TownCity,String Postcode, String Telephone){

      GenericMethods.dropDownWithSelect(title,"Mrs");
      firstname.sendKeys(Firstname);
      lastname.sendKeys(Lastname);
      GenericMethods.dropDownWithSelect(country,"United Kingdom");
      address1.sendKeys(Address1);
      townCity.sendKeys(TownCity);
      postcode.sendKeys(Postcode);
      telePhone.sendKeys(Telephone);
      radioBillingSameAddress.click();
  }

public void checkoutForPurchase(){
    proceedToPurchase.click();

}
 public String productSummary(){
    return productSummary.getText();
 }

 public void confirmPurchase(){
    confirmPurchase.click();
 }

 public String getShippingInfo(){
   return shippingInfo.getText();
 }

 public String finalInfo(){
    return finalShippingInfo.getText();
 }
}
