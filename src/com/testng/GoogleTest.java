package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
	WebDriver driver;
	
	//1 //4 //7
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com.mx");		
	}
	
	// 2
	@Test(priority = 1, groups = "Tittle")
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);		
	}
	
	//5
	@Test(priority = 2, groups = "Logo")
	public void googleLogoTest() {
		boolean logo = driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
		System.out.println("El logo desplegado: "+ logo);
	}
	
	//8
	@Test(priority = 3, groups = "Link Test")
	public void mailLinkTest() {
		boolean link = driver.findElement(By.linkText("mail")).isDisplayed();
		System.out.println("Link Presente: "+ link);
	}
	
	@Test(priority = 4, groups = "Test")
	public void test1() {
		System.out.println("Test 1");
	}
	
	@Test(priority = 6, groups = "Test")
	public void test2() {
		System.out.println("Test 1");		
	}
	
	@Test(priority = 5, groups = "Test")
	public void test3() {
		System.out.println("Test 1");		
	}
	
	//3 //6 //9
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
