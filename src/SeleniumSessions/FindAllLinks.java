package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindAllLinks {

	public static void main(String[] args) throws InterruptedException {

		//System.setProperty("webdriver.gecko.driver", "C:\\eclipse-workspace\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies(); //       
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 
		driver.get("http://facebook.com/");
 
		List<WebElement> links = driver.findElements(By.tagName("a"));
 
		System.out.println("Num. of Links: "+ links.size());
 
		for (int i = 0; i<links.size(); i++)
		{
			System.out.println(links.get(i).getText());
		}
		
		driver.close();
 
	}

}
