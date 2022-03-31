package com.framework.java11HttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Java11GetHeadersTest {

  private static final String BASE_URL = "https://api.github.com/";

  @Test
  public void getReturns200() throws IOException, InterruptedException {

    // Arrange
    HttpClient httpClient = HttpClient.newBuilder().build();
    HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
        .GET()
        .setHeader("User-Agent","Java 11 Http bot")
        .build();

    //Act
    HttpResponse<Void> response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
    int actualStatusCode = response.statusCode();

    //Assert
    Assert.assertEquals(actualStatusCode,200);
  }

  @Test
  public void contentTypeIsJson() throws IOException, InterruptedException {

    //Arrange
    HttpClient client = HttpClient.newBuilder().build();
    HttpRequest get =  HttpRequest.newBuilder(URI.create(BASE_URL))
        .setHeader("User-Agent","Java 11 Http bot")
        .build();

    //Act
    HttpResponse<Void> response = client.send(get,HttpResponse.BodyHandlers.discarding());
    String actualContentType = response.headers().firstValue("content-type").get();

    //Assert
    Assert.assertEquals(actualContentType,"application/json; charset=utf-8","Header content type does not match");
  }

  @Test
  public void xRateLimitIsPresent() throws IOException, InterruptedException {

    //Arrange
    HttpClient client = HttpClient.newBuilder().build();
    HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
        .setHeader("User-Agent","Java 11 Http bot")
        .build();

    //Act
    HttpResponse<Void> response = client.send(get,HttpResponse.BodyHandlers.discarding());
    String actualXRate = response.headers().firstValue("x-ratelimit-limit").get();

    //Assert
    Assert.assertEquals(actualXRate,"60","xrate limit does not match");
  }
}
