package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GoogleTitleTest {
	
	WebDriver driver;
	String Url = "https://www.google.com/";
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(Url);		
	}
	
	@Test(priority = 1)
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title,"Google", "Title is not matched");
	}
	
	@Test(priority = 2)
	public void googleTitleTestFail() {
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title,"Google123", "Title is not matched");
	}
	
	@Test(priority = 3)
	public void googleLogoTest() {
		boolean logo = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		//Assert.assertTrue(logo);
		Assert.assertEquals(logo, true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
