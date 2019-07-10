package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindAllLinks2 {

	public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// For the page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// For elements
        driver.get("https://www.twitter.com/");
        
      
        //all the links are represented by <a> html tag:
        List <WebElement> linkList = driver.findElements(By.tagName("a"));
        
        for(WebElement link:linkList) {
        	System.out.println(link.getText());
        }
        
        System.out.println("<<------------------ DONE ------------------->>");
	
        for(WebElement link:linkList) {
        	if(link.getText().equals("Forgot password?")) {
        		System.out.println(link.getText());
        		link.click();
        		break;
        	}
        }
	}

}
