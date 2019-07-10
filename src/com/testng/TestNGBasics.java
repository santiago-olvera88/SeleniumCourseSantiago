package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	/* 
	 	1- setup property for Chrome 	- @BeforeSuite
		2- launch Chrome browser		- @BeforeTest
		3- Login to app					- @BeforeClass
		4- Enter URL					- @BeforeMethod
		5-- Test-- Google Title Test	- @Test
		6- Logout from app				- @AfterMethod
		7- Close Browser				- @AfterClass
		8- deleteAllCookies				- @AfterTest
		9- generateTestReport			- @BeforeSuite
	 */
/*
	 @BeforeSuite -- Setup property for Chrome
	 @BeforeTest -- launch Chrome browser
	 @BeforeClass -- Login to app
	 ***************************************
	 @BeforeMethod -- Enter URL
	 @Test -- Google Logo Test
	 @AfterMethod-- Logout from app
 	 ***************************************	
	 @BeforeMethod -- Enter URL
	 @Test -- Google Title Test
	 @AfterMethod-- Logout from app
 	 ***************************************	
	 @BeforeMethod -- Enter URL
	 @Test -- Search Test
	 @AfterMethod-- Logout from app
 	 **************************************	
	 @AfterClass -- Close Browser
	 @AfterTest -- DeleteAllCookies
*/	
	
	// Pre-condition annotations -- starting with @Before
	@BeforeSuite //1
	public void setUp() {
		System.out.println("@BeforeSuite -- Setup property for Chrome");
	}
	
	@BeforeTest //2
	public void lauchBrowser() {
		System.out.println("@BeforeTest -- launch Chrome browser");
	}
	
	@BeforeClass //3
	public void login() {
		System.out.println("@BeforeClass -- Login to app");
		System.out.println(" ");
	}
	
	/* The next Method are executed every time before and after each method 
	 * @BeforeMethod
	 * @Test - 1
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test - 2
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test - 3
	 * @AfterMethod
	 */
	
	@BeforeMethod //4
	public void enterURL() {
		System.out.println("@BeforeMethod -- Enter URL");
	}
		
	// Test cases -- starting with @Test
	@Test //5
	public void googleTittleTest() {
		System.out.println("@Test -- Google Title Test");
	}
	
	@Test //5
	public void searchTest() {
		System.out.println("@Test -- Search Test");
	}
	
	@Test //5
	public void googleLogoTest() {
		System.out.println("@Test -- Google Logo Test");
	}
		
	// Post-condition annotations -- starting with @After
	@AfterMethod //6
	public void logOut() {
		System.out.println("@AfterMethod-- Logout from app");
		System.out.println(" ");
	}
	
	@AfterClass // 7
	public void closeBrowser() {
		System.out.println("@AfterClass -- Close Browser");
	}
	
	@AfterTest //8
	public void deleteAllCookies() {
		System.out.println("@AfterTest -- DeleteAllCookies");
	}
	
	
}