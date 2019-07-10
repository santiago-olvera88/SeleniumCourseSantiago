package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CatchingExceptions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
				
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://twitter.com/");
		
		Thread.sleep(2000);
		
		try {
			if(driver.findElement(By.name("session[username_or_email_Dummy]")).isDisplayed()) {
				driver.findElement(By.name("session[username_or_email_Dummy]")).sendKeys("coapan_17@hotmail.com");
			}
			} catch (NoSuchElementException nsee) {
				System.out.println("'emailDummy' Element not found");
				driver.findElement(By.name("session[username_or_email]")).sendKeys("coapan_17@hotmail.com");				
			}
	
		
		driver.findElement(By.name("session[password]")).sendKeys("eliseos88*OO");	
		driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//*[@id='user-dropdown-toggle']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='signout-button']/button")).click();
        driver.close();

	}

}
