package SeleniumSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ImplicitWait {
        
    public static void main(String[] args) {
        
        String Url = "https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=";
        
        WebDriver driver = new FirefoxDriver();
 
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// For the page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// For elments
        driver.get(Url);
    }
}
