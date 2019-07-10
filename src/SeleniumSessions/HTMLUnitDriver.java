package SeleniumSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class HTMLUnitDriver {
    
    public static void main(String[] args) throws InterruptedException {
        
        //WebDriver driver = new ChromeDriver();
        /*
        - HtmlUnitDriver is not avialible in selenium 3.x version
        - TO use this concept, we have to download htmlunitdriver JAR FILE
        
        Adavantajes:
        - 1. Testing is happening behind the scene -- no browser is launched
        - 2. Very Fats -- Execution of  test cases -- very fats -- performancce of the script
        - 3. not suitable for Action class -- user actions -->> mousemovent, doubleClick, drag and drop
        - 4. Ghost Driver -- Headless Browser:
            HtmlUnit Driver -- Java
            PhantomJS -- JavaScript
        */
        WebDriver driver = new HtmlUnitDriver();
        
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.get("https://www.freecrm.com/index.html");
        System.out.println("Before login, title is: "+driver.getTitle());
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("Addf54245");
        driver.findElement(By.name("password")).sendKeys("ytIyutuhK455");
        driver.findElement(By.xpath("//input[@type='submit']")).submit();
        Thread.sleep(3000);
        
        System.out.println("After login, title is: "+driver.getTitle());
        driver.close();
        
    }
}
