package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver; 
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/"); // Enter Url
		
		driver.findElement(By.name("username")).sendKeys("Addf54245");
		driver.findElement(By.name("password")).sendKeys("ytIyutuhK455");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click(); //login button
		
		driver.switchTo().frame("mainpanel");
		
		String date = "31-September-2015";
		String dateArr[] = date.split("-"); // {18,September,2016}
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		Select selectMonth = new Select(driver.findElement(By.name("slctMonth")));
		selectMonth.selectByVisibleText(month);
		Thread.sleep(2000);
		
		Select selectYear = new Select(driver.findElement(By.name("slctYear")));
		selectYear.selectByVisibleText(year);
		Thread.sleep(2000);
		
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]
		
		
		String beforeXpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath = "]/td[";
		
		int totalWeekDays = 7;				
		// 2-1, 2-2, 2-3, 2-4, 2-4, 2-5, 2-6, 2-7
		// 3-1, 3-2, 3-3, 3-4, 3-4, 3-5, 3-6, 3-7 
		boolean flag = false;
		String dayVal = null; 
		for (int rowNum = 2; rowNum <= 7; rowNum++) {		
			
			for (int colNum = 1; colNum <= totalWeekDays; colNum++) {
				
				try {
					dayVal = driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + "]")).getText();
				} catch (NoSuchElementException e){
					System.out.println("Please enter a correct date value");
					flag = false;
					break;
				}
				System.out.println(dayVal);
				if(dayVal.equals(day)) {
					driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + "]")).click();
					flag = true;
					break;
				}
			}
			
			if(flag) {
				break;
			}
		}		
		
	}

}
