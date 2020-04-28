package webdriverbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

    public class DriverManager {

    public static WebDriver driver;

   public DriverManager(){

       PageFactory.initElements(driver,this);
    }

    public void openBrowser(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.net-a-porter.com/gb/en/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public void quitBrowser(){
        driver.quit();
    }


   public String getCurrentURL(){
     return  driver.getCurrentUrl();
   }



}







