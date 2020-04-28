package com;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import webdriverbase.DriverManager;

public class Hooks {
    DriverManager driverManager = new DriverManager();

@Before
  public void driverSetUp(){
      driverManager.openBrowser();

  }
  @After
public void tearDown(){
    driverManager.quitBrowser();
}

}
