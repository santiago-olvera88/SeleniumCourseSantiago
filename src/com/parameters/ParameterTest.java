package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	
	WebDriver driver;

	@Test
	@Parameters({"browser","url","mail","pass"})
	public void gmailLogin(String browser, String Url, String email, String pass) throws InterruptedException {
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")){
			driver = new FirefoxDriver();
		}
		 
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(Url);
		
        driver.findElement(By.xpath("//a[contains(text(),'Sign in ')]")).click();
        driver.findElement(By.xpath("//*[@id='i0116']")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='i0118']")).sendKeys(pass);    
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(2000);
        driver.close();
 	}
	
}
