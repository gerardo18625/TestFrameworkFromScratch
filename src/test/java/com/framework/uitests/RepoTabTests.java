package com.framework.uitests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RepoTabTests extends BaseTestClass{

  String repoName = "automated-tests-in-java-with-fluent-interface-using-webdriver-selenium";

  @Test
  public void repoLinkGoesToCorrectRepo(){

    String expectedUrl = BASE_URL + user + "/" + repoName;
    driver.get(BASE_URL + user);
    driver.findElement(By.xpath("//a/span[@title='automated-tests-in-java-with-fluent-interface-using-webdriver-selenium']")).click();
    String actualUrl = driver.getCurrentUrl();
    assertEquals(actualUrl,expectedUrl,"Expected URL does not match");
  }

  @Test
  public void repositoryCountIsCorrect(){

    driver.get(BASE_URL + user + "?tab=repositories");
    int actualNumOfRepos = driver.findElements(By.xpath("//div[@id='user-repositories-list']/ul/li")).size();
    assertEquals(actualNumOfRepos,10,"Number of repos does not match");
  }

}
