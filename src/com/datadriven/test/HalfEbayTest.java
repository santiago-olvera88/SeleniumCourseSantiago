package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class HalfEbayTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru="); // Enter Url			
	}
	
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider = "getTestData", priority=1)
	public void halfEbayRegPageTest(String firstname, String lastname, String address1, String address2, String city,
			String state, String zipcode, String emailaddress, int rowNumResult) throws InterruptedException {
		//Enter Data:
		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(address1);
		driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(address2);
		driver.findElement(By.xpath("//*[@id='city']")).sendKeys(city);
		
        Select selctState = new Select(driver.findElement(By.xpath("//*[@id='state']")));
        selctState.selectByVisibleText(state);
        
        driver.findElement(By.xpath("//*[@id='zip']")).sendKeys(zipcode);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(emailaddress);
		driver.findElement(By.xpath("//*[@id='retype_email']")).sendKeys(emailaddress);
		
		Thread.sleep(3000);
		
		//Clear Data:
		driver.findElement(By.xpath("//*[@id='firstname']")).clear();
		driver.findElement(By.xpath("//*[@id='lastname']")).clear();
		driver.findElement(By.xpath("//*[@id='address1']")).clear();
		driver.findElement(By.xpath("//*[@id='address2']")).clear();
		driver.findElement(By.xpath("//*[@id='city']")).clear();
		
		Select selctStateC = new Select(driver.findElement(By.xpath("//*[@id='state']")));
        selctStateC.selectByIndex(0);
        
        driver.findElement(By.xpath("//*[@id='zip']")).clear();
		driver.findElement(By.xpath("//*[@id='email']")).clear();
		driver.findElement(By.xpath("//*[@id='retype_email']")).clear();
		
		TestUtil.resultTest(rowNumResult);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
