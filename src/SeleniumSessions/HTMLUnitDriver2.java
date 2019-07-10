package SeleniumSessions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriver2 {

	public static void main(String[] args) {
		// Declaring and initialising the HtmlUnitWebDriver
		HtmlUnitDriver unitDriver = new HtmlUnitDriver();
 
		// open google.com webpage
		unitDriver.get("http://google.com");
 
		System.out.println("Title of the page is -> " + unitDriver.getTitle());
 
		// find the search edit box on the google page
		WebElement searchBox = unitDriver.findElement(By.xpath("//*[@id='lst-ib']"));
		searchBox.sendKeys("Selenium");
 
		// find the search button
		WebElement button = unitDriver.findElement(By.name("btnK"));
		button.click();
 
		System.out.println("Title of the page is -> " + unitDriver.getTitle());

	}

}
