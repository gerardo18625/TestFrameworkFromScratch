package com.framework.uitests;

import static com.framework.DriverFactory.getChromeDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestClass {

  public static final String BASE_URL = "https://github.com/";
  public static String user = "andrejs-ps";
  public static WebDriver driver;

  @BeforeTest
  public static void setUp(){
    driver = getChromeDriver();
  }

  @AfterTest
  public static void TearDown(){
    System.out.println("Being called after test");
    driver.close();
  }

}
