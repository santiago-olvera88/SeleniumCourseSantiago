package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestCase {
	
    public static WebDriver driver;
    public static String Url = "https://www.google.com/intl/es/gmail/about/";
    public static String mail = "coapan23@gmail.com";
    public static String pass = "eliseos88*O";
    
    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Url);
        System.out.println("---- Before done ----");
    }    
    
  @Test
  public void Test() {
      driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
      driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(mail);
      driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
      
      //Explicit Wait by Lacated
      WebDriverWait wait = new WebDriverWait(driver, 10);
      WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
      passField.sendKeys(pass);
      
      driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
      
      //Explicit Wait by Visibility
      WebElement closeSession = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='gb_db gbii']")));
      closeSession.click();
      
      driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();
      System.out.println("---- Test done ----");
  }


  @AfterMethod
  public void afterMethod() {
      driver.close();
      System.out.println("---- After done ----");
  }

}
