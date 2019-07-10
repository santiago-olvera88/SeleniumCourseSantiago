package SeleniumSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {
        
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// For the page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// For elments
        driver.get("https://www.ebay.com/");
        
        //driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Peluche");
        //driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Peluche");
        driver.findElement(By.xpath("//input[contains(@class,'h-tb ui-autocomplete-input')]")).sendKeys("Peluche");
        
        //>>>>>>>>>>>>>> DYNAMIC id: input <<<<<<<<<<<<<<
        //--start-with
        //id = test_123
        //id = test_456
        //id = test_789
        //id = test_test_789_test
        //id = test_789
        
        // -- end-with
        //id = 123_test_t
        //id = 456_test_t
        //id = 789_test_t
        
//      driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("AbcD");
//      driver.findElement(By.xpath("//input[start-with(@id,'test_')]")).sendKeys("AbcD");
//      driver.findElement(By.xpath("//input[end-with(@id,'test_t')]")).sendKeys("Abcd");
        
        //for links: custom xpath
        //all the links are represented by <a> html tag:
        driver.findElement(By.xpath("//a[contains(text(),'Inicia sesión')]")).click();
        
    }
    
}
