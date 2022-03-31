package com.framework.uitests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OverviewTabTests extends BaseTestClass{

  @Test
  public void userNameIsCorrectOnOverviewTab(){

    driver.get(BASE_URL + user);
    String actualUsername = driver.findElement(By.xpath("//h1/span[1]")).getText();
    assertEquals(actualUsername, user,"Username does not match");


  }

}
