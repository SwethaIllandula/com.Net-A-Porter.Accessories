package com;

import Pageelements.HomePage;
import cucumber.api.java.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webdriverbase.DriverManager;

public class RegressionSuite {

    WebDriver driver;
    DriverManager driverManager ;
    HomePage homePage;




    public void searchTest(){
    driverManager = new DriverManager();
    driverManager.openBrowser();
    homePage = new HomePage();
    String products = "bags";
    homePage.searchWithKeywords(products);

}
}
