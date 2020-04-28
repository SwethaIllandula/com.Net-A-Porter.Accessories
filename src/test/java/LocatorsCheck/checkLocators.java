package LocatorsCheck;

import UtilitiesForElements.GenericMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class checkLocators {
    WebDriver driver;

    @Test
    public void testTheElements() {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.netaporter.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a.deliver-component-CloseButton.deliver-component-CloseButton--transparent")).click();
        WebElement designerlink = driver.findElement(By.cssSelector("a[href*='Shop/AZDesigners?cm_sp=topnav-_-designers-_-topbar']"));
        // WebElement moveToAccessories =driver.findElement(By.cssSelector("a[href*='Shop/Accessories?']"));
        Actions action = new Actions(driver);
        action.moveToElement(designerlink).build().perform();
        selectFromFeaturedDesigners("Gucci");
       /* driver.findElement(By.linkText("All Accessories")).click();
        //driver.findElement(By.xpath("(//span[@class='AccordionSection2__arrowIcon arrowIcon'])[4]")).click();
        driver.findElement(By.xpath("(//label[@class='AccordionSection2__heading openLabel'])[1]")).click();
        driver.findElement(By.linkText("Sunglasses")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("(//label[@class='AccordionSection2__heading openLabel'])[2]")).click();
        List<WebElement> sunglasses = driver.findElements(By.cssSelector("a[href ^='/en-gb/shop/accessories/sunglasses/']"));
        System.out.println(sunglasses.size());
        int typesOfSunGlasses = GenericMethods.randomNumberHelper(sunglasses.size());
        WebElement chooseSunGlasses = sunglasses.get(typesOfSunGlasses);
        chooseSunGlasses.click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("(//label[@class='AccordionSection2__heading openLabel'])[3]")).click();
        //List<WebElement>  categories= driver.findElements(By.cssSelector(".PLPAccordionSection43--active.override .AccordionSection2__content.content a span.Filter43__filterLineCheckbox.radioButton"));

        List<WebElement> colours = driver.findElements(By.cssSelector(".Swatch6.Filter43__swatch"));
        // driver.navigate().refresh();
        System.out.println(colours.size());
        int chooseColour = GenericMethods.randomNumberHelper(colours.size());
        WebElement randomColour = colours.get(chooseColour);
        randomColour.click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("(//label[@class='AccordionSection2__heading openLabel'])[4]")).click();
        List<WebElement> brands = driver.findElements(By.cssSelector(".DesignerFilterGroup43__list div a"));
        System.out.println(brands.size());
        int brandAccs = GenericMethods.randomNumberHelper(brands.size());
        WebElement selectBrands = brands.get(brandAccs);
        selectBrands.click();
        driver.navigate().refresh();*/
    }

        /*List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
        totalLinks.addAll(driver.findElements(By.tagName("img")));
        System.out.println("total links are :"+totalLinks.size());
        List<WebElement> activeLinks = new ArrayList<WebElement>();
        for (int i = 0; i < totalLinks.size(); i++) {
         // System.out.println(totalLinks.get(i).getAttribute("href"));
          if(totalLinks.get(i).getAttribute("href") !=null){
              activeLinks.add(totalLinks.get(i));}}
        System.out.println("total active links are: "+activeLinks.size());

        for(int j=0;j<activeLinks.size();j++){
            try {
               HttpURLConnection connection= (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
               connection.connect();
               int response=connection.getResponseCode();
               System.out.println(activeLinks.get(j).getAttribute("href")+ "-->"+ response);
               connection.disconnect();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }*/


        public void selectFromFeaturedDesigners (String designers){
           WebElement gucci= driver.findElement(By.linkText("Gucci"));
            int counter=0;
            List<WebElement> featuredDesigners = driver.findElements(By.cssSelector(".sf-nav__featured-designers ul li"));
            int designerList = featuredDesigners.size();
            System.out.println(designerList);
            for (WebElement Designers : featuredDesigners) {
                System.out.println(Designers.getText());
                //if(Designers.)
               if (Designers.getText().equalsIgnoreCase(designers)) {
                   // gucci.click();
                    break;
                }

                if (designerList == 0) {
                    TestCase.fail("Designer is not Available");
                }

            }
        }


    }



      //Thread.sleep(3000);
    /*Alert alert= driver.switchTo().alert();
    // alert.dismiss();
      driver.findElement(By.cssSelector("a.deliver-component-CloseButton.deliver-component-CloseButton--transparent")).click();
     WebElement moveToAccessories =driver.findElement(By.cssSelector("a[href*='Shop/Accessories?']"));
     Actions action= new Actions(driver);
     action.moveToElement(moveToAccessories).build().perform();
     driver.findElement(By.linkText("All Accessories")).click();
      List<WebElement> randomAccessories =driver.findElements(By.cssSelector(".ProductListingPage43__layoutGrid a"));*/
     // Random rand = new Random();
    // int products= rand.nextInt(randomAccessories.size());
     // WebElement randomProducts = randomAccessories.get(products);
      //randomProducts.click();
      /*driver.findElement(By.cssSelector("button.Button10.Button10--primary.AsyncButton10.CTAButtons77__addToBag.primaryButton ")).click();
      driver.findElement(By.cssSelector("a[title='Shopping bag']")).click();
      driver.findElement(By.cssSelector(".primary-button-medium-wide.proceed-to-purchase.position-top")).click();
      driver.findElement(By.cssSelector(".test-guest-customer-email")).sendKeys("swetha.illan@gmail.com");
      driver.findElement(By.xpath("//input[@class='emailSignupRadioButton' and @value='false']")).click();
      driver.findElement(By.cssSelector("#purchasePathSubmit")).click();


    //Actions action = new Actions(driver);
    driver.findElement(By.xpath("(//div[@class='sf-search'])[2]")).click();
    driver.findElement(By.xpath("(//div[@class='sf-search__header'])[2]/form/input[@name='keywords']")).sendKeys("belts");
    driver.findElement(By.xpath("(//div[@class='sf-search__header'])[2]/form/input[@type='submit']")).click();
   List<WebElement> products= driver.findElements(By.cssSelector(".ProductListingPage43__layoutGrid a"));
    int bags= GenericMethods.randomNumberHelper(products.size());
    WebElement randomProducts = products.get(bags);
   randomProducts.click();
  // List<WebElement> colours = driver.findElements(By.cssSelector(".ProductDetailsColours77__coloursList ul li"));
     //int randomColour =GenericMethods.randomNumberHelper(colours.size()-1);
    // WebElement randomColourBags = colours.get(randomColour);
    // randomColourBags.click();
      driver.findElement(By.cssSelector("button.Button10.Button10--primary.AsyncButton10.CTAButtons77__addToBag.primaryButton ")).click();*/


   //action.moveToElement(search).build().perform();
   //search.click();

   //driver.findElement(By.xpath("//div[@class='sf-search__popup sf-search__popup--open']//input[@type='text']")).click();
   // driver.findElement(By.cssSelector(".sf-search__popup.sf-search__popup--open form)).sendKeys("bags");
    //driver.findElement(By.cssSelector(".sf-nav.sf-hover div form input.sf-search__icon.sf-search__icon--nav")).click();




    /* List<WebElement> links = driver.findElements(By.cssSelector(".sf-nav__level1 li a"));
      System.out.println("Total Amenities "  + links.size());
      int statusCode=0;
      HttpURLConnection connection = null;
      try
      {
          for (WebElement link : links)
          {
              String href = link.getAttribute("href");
              System.out.println(link.getAttribute("href"));
              connection = (HttpURLConnection) new URL(href).openConnection();
              connection.connect();
              statusCode = connection.getResponseCode();
              Assert.assertEquals("Broken link " + href + " - response code  :" + statusCode , 200, statusCode);
              System.out.println(href + " - response code :" + statusCode);
          }
      }
      catch(Exception e)
      {
          System.out.println(e.getMessage());
      }
      finally
      {
         // connection.disconnect();
      }
 */









