package SantiagoSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class LaunchingBrowsers {
    
    public static void main(String[] args) throws InterruptedException {
        
     Firefox();
     Chrome();
     Safari();
    }      
    
    public static void Firefox() throws InterruptedException{
        
        //System.setProperty("webdriver.gecko.driver", "C:\\NetBeansProjects\\SeleniumXY\\Library\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.store.demoqa.com");
        
        System.out.println("Successfully opened in FireFox");
        Thread.sleep(5);
        driver.close();
    }
    
    public static void Chrome()throws InterruptedException {
    
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com.mx");
        
        System.out.println("Succefully opened in Chrome");
        Thread.sleep(5);
        driver.quit();
    }
    
    public static void Safari(){
        //check how to lauch in W7
        WebDriver driver = new SafariDriver();
        driver.get("http://www.google.com");
        
        System.out.println(driver.getTitle());
    }
  
}
