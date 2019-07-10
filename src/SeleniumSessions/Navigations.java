package SeleniumSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Navigations {
    
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// For the page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// For elments
        driver.get("https://www.google.com/");

        driver.navigate().to("https://www.amazon.com.mx/");        
        //Back and forward simulation buttons
        driver.navigate().back();// goes to google
        Thread.sleep(2000);
        driver.navigate().forward(); // goes to amazon
        driver.navigate().back();   // goes to google
        driver.navigate().refresh();
        driver.close();        
    }
}
