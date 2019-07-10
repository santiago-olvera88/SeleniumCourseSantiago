package SantiagoSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchingIE {
    public static void main(String[] args) {
                WebDriver driver = new FirefoxDriver();
        
    	driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        
        String title = driver.getTitle();
        System.out.println("All was done succefully, title of web is:\n"+title);
        
        if(title.equals("Facebook - Inicia sesi�n o reg�strate")){
            System.out.println("Tille of the page is correct");
        }else{
            System.out.println("Tille of the page is wrong");
        
        }
    }
}
