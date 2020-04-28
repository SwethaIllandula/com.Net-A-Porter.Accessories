package UtilitiesForElements;

import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GenericMethods {


public static void actionsToMoveElement(WebDriver driver, WebElement element){
    Actions action = new Actions(driver);
    action.moveToElement(element).build().perform();
}

public void actionsToClickElement(WebDriver driver, WebElement element){
    Actions actions = new Actions(driver);
    actions.click(element);
}
public void actionsToContextClick(WebDriver driver, WebElement element){
    Actions clickActions= new Actions(driver);
    clickActions.contextClick(element); }


    public static void dropDownWithSelect(WebElement element,String text){
        Select select = new Select(element);
         select.selectByVisibleText(text);

    }

  public void dropDownByIndex(WebElement element,int value) {
    Select select = new Select(element);
    select.selectByIndex(value);
  }

public static void dropDownByValue(WebElement element, String value){
    Select select= new Select(element);
    select.selectByValue(value);
}

public static int randomNumberHelper(int size){

  return new Random().nextInt(size-1);

}

public static void explicitWait(WebDriver driver ,int time,WebElement element){
    WebDriverWait wait = new WebDriverWait( driver,20);
    wait.until(ExpectedConditions.visibilityOf(element));
    element.click();

}
public static void refreshPage(WebDriver driver){

    driver.navigate().refresh();
}

public static String getTitle(WebDriver driver){
  return driver.getTitle();
}





}
