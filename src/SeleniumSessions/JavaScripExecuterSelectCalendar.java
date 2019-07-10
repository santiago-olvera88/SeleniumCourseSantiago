package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class JavaScripExecuterSelectCalendar {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver; 
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://spicejet.com/"); // Enter Url
		
		driver.findElement(By.xpath("//*[@id='buttons']/div/div/ul/li[2]/a/span[2]")).click();
		
		Thread.sleep(2000);
		
		
		WebElement date = driver.findElement(By.name("ctl00$mainContent$txt_Fromdate_MST"));
		String dateVal = "24-06-2018";
		
		selectDateByJS(driver, date, dateVal);
		
	}
	
	public static void selectDateByJS(WebDriver driver,WebElement element, String dateVal) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
	}
}
