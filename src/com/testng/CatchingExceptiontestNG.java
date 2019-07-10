package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class CatchingExceptiontestNG {
    private WebDriver driver;
    private WebDriverWait wait;
    private String email = "coapan_17@hotmail.com";
    private String pass = "eliseos88*OO";
    //private List <WebElement> products;
    
   
    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }
    
    @Test
    public void twitterTest () throws InterruptedException {
        Log_in_Test();
        Log_out_Test();
    }
    public void Log_in_Test() throws InterruptedException {
           	
    	driver.get("https://twitter.com/");
    	Thread.sleep(2000);
        
        wait.until(titleIs("Twitter. It's what's happening."));
        
        try {
        	driver.findElement(By.name("session[username_or_emailD]")).sendKeys(email);
            } catch (NoSuchElementException ex) {
                System.out.println("Error! Field User not found");
                driver.findElement(By.name("session[username_or_email]")).sendKeys(email);
            }
        
        driver.findElement(By.name("session[password]")).sendKeys(pass);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    
    public void Log_out_Test() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='user-dropdown-toggle']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='signout-button']/button")).click();
        wait.until(titleIs("Twitter. It's what's happening."));
    }
    
    @AfterMethod
    public void tearDown() {
    	driver.close();
    	driver = null;
    }
    
}
