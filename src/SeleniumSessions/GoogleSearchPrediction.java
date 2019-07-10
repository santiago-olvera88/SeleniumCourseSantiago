package SeleniumSessions;

/*
 * Como selccionar opciones de la lista de sugerenacias que generan
 * las paginas al ir introduciendo texto para alguna busqueda
 */

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GoogleSearchPrediction {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new FirefoxDriver();
        
        driver.manage().deleteAllCookies(); //       
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        
        driver.findElement(By.id("lst-ib")).sendKeys("testing");
        Thread.sleep(1500);
        
        //all the elements in the list
        List <WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));
        //size of linkList
        System.out.println("*** Total Numer of suggestion in search box ::====>> "+list.size());
        //Printing the elements in the list
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+" "+list.get(i).getText());
            if (list.get(i).getText().contains("testing life cycle")) {
                list.get(i).click();
                break; 
            }
        }
     
    }
    
}
