package SeleniumSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class DragAndDrop {
    
    public static void main(String[] args) {
        
        String Url = "http://jqueryui.com/droppable/";
        
        WebDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(Url);
                
        driver.switchTo().frame(0);
        
        Actions action = new Actions(driver);
        
        action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']")))
            .moveToElement(driver.findElement(By.xpath("//*[@id='droppable']")))
            .release()
            .build()
            .perform();
        
    }
}
