package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// For the page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// For elements
        driver.get("https://www.twitter.com/");
        
        //1. Get the total count of links and input on the page
        //2. Get the text of each link on the page
        
        //all the links are represented by <a> html tag:
        List <WebElement> linkList = driver.findElements(By.tagName("a"));
        List <WebElement> inputList = driver.findElements(By.tagName("input"));
        //size of linkList
        
        System.out.println("The quantity of Inputs are: "+inputList.size());
        System.out.println("The quantity of Links are: "+linkList.size());
             
        System.out.println(">>>>>>>>>>>>>>Printing the text of the Inputs<<<<<<<<<<<<<<<<<<<<<<<<<<");
        for (WebElement input:inputList) {         
            System.out.println(input.getText());
        }    
        
        System.out.println(">>>>>>>>>>>>>>Printing the text of the Link<<<<<<<<<<<<<<<<<<<<<<<<<<");
        for (int i = 0; i < linkList.size(); i++) {            
            String linkText = linkList.get(i).getText();
            System.out.println(i+" "+linkText);
        }
        
        Thread.sleep(3000);
        
//Click on a LINK 'Forgot password?'
        for (int i = 0; i < linkList.size(); i++) {            
            if(linkList.get(i).getText().equals("Forgot password?")) {
            	linkList.get(i).click();
            	break;
            }
        }
        
        Thread.sleep(3000);
        driver.close();
    }
}
