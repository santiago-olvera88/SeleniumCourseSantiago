package SeleniumSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ElementVisibilityTest {
    
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.freecrm.com/register/");
        
        boolean chckAgree,b1,b2;
        
        //1. isDisplayed() method: applicable for all items
        b1 = driver.findElement(By.id("submitButton")).isDisplayed();
        System.out.println(b1);
        
       
        //2. isEnabled() method:
        b2 = driver.findElement(By.id("submitButton")).isEnabled();
        System.out.println(b2);
        
        driver.findElement(By.name("agreeTerms")).click();//chckAgree Selected
        
        b2 = driver.findElement(By.id("submitButton")).isEnabled();
        System.out.println(b2);
        
        //2. isSelected() method: only applicable for  checkbox, dropdown, radibutton     
        chckAgree = driver.findElement(By.name("agreeTerms")).isSelected();
        System.out.println("=========>>>> "+chckAgree);
        
        Thread.sleep(2000);
        driver.findElement(By.name("agreeTerms")).click();//chckAgree deselected
        
        Thread.sleep(2000);
        chckAgree = driver.findElement(By.name("agreeTerms")).isSelected();
        
        if (Boolean.TRUE.equals(chckAgree)) {
            System.out.println("Check Agree is selected: " +chckAgree);
            
        } else if(Boolean.FALSE.equals(chckAgree)){
            System.out.println("Check Agree is NOT selected: " +chckAgree);
        }
        
        driver.close();

    }
    
}
