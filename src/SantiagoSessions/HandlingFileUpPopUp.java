
package SantiagoSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFileUpPopUp {
    
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("http://html.com/input-type-file/");        
        
        String pathFile = "C:\\Users\\VALERIAN\\Downloads\\CV_eQ_V2_Santiago.doc";
        driver.findElement(By.xpath("//*[@id=\'fileupload\']")).sendKeys(pathFile);
        
        
        
    }
    
}
