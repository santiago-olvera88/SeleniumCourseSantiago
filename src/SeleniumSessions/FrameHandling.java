package SeleniumSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameHandling {
    
        public static void main(String[] args) throws InterruptedException {
        
        String Url = "https://es.crmpro.com/index.html";
        String user = "Addf54245";
        String pass = "ytIyutuhK455";
        
        WebDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.get(Url);
        
        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
        
        //Switch to Mainpanel
        driver.switchTo().frame("mainpanel");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
        //Switching back to main page from frame
        driver.switchTo().defaultContent();
      
    }
    

}
