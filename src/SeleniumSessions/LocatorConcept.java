package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LocatorConcept {
    
    public static void main(String[] args) {
  
        String url = "https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=";
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(url);        
        
        //1. -------- ID= 1; Xpath = 2; Name = 3
        driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Santi");
        driver.findElement(By.id("lastname")).sendKeys("Olvera");
        driver.findElement(By.name("address1")).sendKeys("River 12, sea");
        
        //2. linkText: Only for link
        //driver.findElement(By.linkText("Sign in")).click();
        //driver.navigate().back();
        
        //3. partialLinkText: nou useful
        //driver.findElement(By.linkText("How to pick")).click();
        
        //4. CSSSelector
         driver.findElement(By.cssSelector("#address2")).sendKeys("Among ST, RT and FR");
         
        //5. ClassName; not useful, only for elements with atribuete CLASS
        //driver.findElement(By.className("ancAsb")).click();
         System.out.println("Done");
         driver.close();
    }
    
}
