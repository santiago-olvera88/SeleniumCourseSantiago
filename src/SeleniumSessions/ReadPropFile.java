package SeleniumSessions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadPropFile {
    
    static WebDriver driver;
    
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\SeleniumJava\\CourseNaveen\\src\\Naveen\\config.properties");
        prop.load(ip);
        
        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("age"));
        String url = prop.getProperty("URL");
        System.out.println(url);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);
        
        if(browserName.equals("chrome")) {
            
            driver = new ChromeDriver();
        } else if(browserName.equals("FF")){
            
            driver = new FirefoxDriver();

        }else if(browserName.equals("IE")){
            driver = new InternetExplorerDriver();
        }
        
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Implicit Wait --->> Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// For the page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// For elments
        driver.get(url); 
        
        driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(prop.getProperty("firstName"));
        driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(prop.getProperty("lastName"));
        driver.findElement(By.xpath(prop.getProperty("city_xpath"))).sendKeys(prop.getProperty("city"));
        
        Thread.sleep(300);
        driver.close();
    
    }
    
}
