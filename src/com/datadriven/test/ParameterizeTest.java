package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;


public class ParameterizeTest {
	
	public static void main(String[] args) throws InterruptedException {
		
	//webdriver code:			
	WebDriver driver = new ChromeDriver();
	driver = new ChromeDriver(); // launch chrome
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru="); // Enter Url
	
	//Data Driver Approach (Parameterization) -- Used to create data driven framework: driving the test data from excel files.
	
	//get test data from excel:
	Xls_Reader reader = new Xls_Reader("C:\\SeleniumJava\\CourseNaveen\\src\\com\\testdata\\HalfEbayTestData.xlsx");
	
	int rowCount = reader.getRowCount("RegTestData");
	
	reader.removeColumn("RegTestData", 8); //Removing Column #8, it starts from index 0
	reader.addColumn("RegTestData", "Status"); //Adding New Column "Status"
	
	
	//Parameterization
	for(int rowNum = 2; rowNum<=rowCount; rowNum++) {
		System.out.println("=========");
		
		String firstname = reader.getCellData("RegTestData", "firstname", rowNum);
		System.out.println(firstname);
		
		String lastname = reader.getCellData("RegTestData", "lastname", rowNum);
		System.out.println(lastname);
		
		String address1 = reader.getCellData("RegTestData", "address1", rowNum);
		System.out.println(address1);
		
		String address2 = reader.getCellData("RegTestData", "address2", rowNum);
		System.out.println(address2);
		
		String city = reader.getCellData("RegTestData", "city", rowNum);
		System.out.println(city);
		
		String state = reader.getCellData("RegTestData", "state", rowNum);
		System.out.println(state);
		
		String zipcode = reader.getCellData("RegTestData", "zipcode", rowNum);
		System.out.println(zipcode);
		
		String emailaddress = reader.getCellData("RegTestData", "emailaddress", rowNum);
		System.out.println(emailaddress);
		
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
		
		Thread.sleep(2000);
		
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
		
		//write the data into a cell	
		reader.setCellData("RegTestData", "Status", rowNum, "Pass"); 
	}
	
	System.out.println(">>>>>>>>>> DONE SUCCESSFULLY <<<<<<<<<<<");
	driver.close();
  }

}
