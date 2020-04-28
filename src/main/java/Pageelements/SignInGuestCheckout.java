package Pageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriverbase.DriverManager;

public class SignInGuestCheckout extends DriverManager {

    @FindBy(css = ".test-guest-customer-email")
    private WebElement guestEmail;

    @FindBy(xpath= "//input[@class='emailSignupRadioButton' and @value='false']")
    private WebElement RadioButton;

    @FindBy(css = "#purchasePathSubmit")
    private WebElement continueAsGuest;


    public void guestCheckOut(){
        guestEmail.sendKeys("swetha.illan@gmail.com");
        RadioButton.click();
        continueAsGuest.click();

    }




}
