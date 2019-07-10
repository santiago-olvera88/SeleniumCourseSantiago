
package SantiagoSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverCommands {
    
    public static void main(String[] args) {
        BrowserCommands();
        BrowserNavigationCommands();
    }
    
    public static void BrowserCommands(){
        
        WebDriver driver = new FirefoxDriver();
        
        String url = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
        
        driver.get(url);
        driver.manage().window().maximize();
        String title = driver.getTitle();
        
        System.out.println("Title of web is: "+title);
        
        if(title.equals("Gmail")){
            System.out.println("Tille of the page is correct");
        }else{
            System.out.println("Tille of the page is wrong");
        
        }
        
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(url)) {
            System.out.println("Verifiction Successful - The correct Url was opened");
            
        } else {
            System.out.println("Verification Failed - An incorrect Url was opened");
            System.out.println("Actual Url is: "+actualUrl);
            System.out.println("Excpectes Url is: "+url);
        }
        
        System.out.println("The lenght of the page is: "+driver.getPageSource().length());
        driver.quit();
    }
    
    public static void BrowserNavigationCommands(){
        
        WebDriver driver = new ChromeDriver();
        
        String url = "http://www.DemoQA.com";
        driver.get(url);
        driver.findElement(By.xpath(".//*[@id='menu-item-374']/a")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to(url);
        driver.navigate().refresh();
        driver.close();
        
    }
    
}
