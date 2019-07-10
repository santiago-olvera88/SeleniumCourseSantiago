package SeleniumSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {
    
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://spicejet.com/");        
        
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.linkText("Add-Ons"))).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.linkText("You 1st")).click();
        
        driver.navigate().back();
        
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"ctl00_HyperLinkLogin\"]"))).build().perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.linkText("SpiceCash/SpiceClub Members"))).build().perform();
        Thread.sleep(3000);
        
 
        //driver.findElement(By.xpath("//a[contains(text(),'Member Login')]")).click();
        WebElement linkMemberLgn = driver.findElement(By.linkText("Member Login"));// Link Member Link
        clickElmentByJS(linkMemberLgn, driver);
        
        driver.close();
        Thread.sleep(300);
        System.out.println("All was successfully");
                
    }
    
    public static void clickElmentByJS(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);        
    
    }     
    
}
