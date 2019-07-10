package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {
    
    public static void main(String[] args) throws InterruptedException{
    
            ChromeN();

    }
    
    public static void ChromeN(){
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.facebook.com");
                
        String title = driver.getTitle();
        System.out.println("All was done succefully, title of web is:\n"+title);
        
        if(title.equals("Facebook - Inicia sesión o regístrate")){
            System.out.println("Tille of the page is correct");
        }else{
            System.out.println("Tille of the page is wrong");
        
        }
         System.out.println(driver.getCurrentUrl());
         //System.out.println(driver.getPageSource());
         driver.quit();
         
    }
        
    
}
