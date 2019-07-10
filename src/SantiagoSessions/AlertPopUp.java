package SantiagoSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPopUp {
    
    public static String url = "https://mail.rediff.com/cgi-bin/login.cgi";

    public static void main(String[] args) throws InterruptedException {
        
        AlertByswitchTo();
        AlertByIsPresent();
    }    
    
    public static void AlertByswitchTo() throws InterruptedException{
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);        
        driver.findElement(By.name("proceed")).click();
        Thread.sleep(3000);
        
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        
        String txtAlert = alert.getText();
        
        if (txtAlert.equals("Please enter a valid user name")) {
            System.out.println("Correct Alert messg");
            
        } else {
            System.out.println("in-correct messg");
        }
        
        alert.accept(); 
        driver.close();
        System.out.println("======== Test was done successfully ========");
    
    }
    
    public static void AlertByIsPresent() throws InterruptedException{
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.name("proceed")).click();
        Thread.sleep(3000);
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(myAlert.getText());
        myAlert.accept();
        
        driver.close();
        System.out.println(">>>>>>>> Test was done successfully <<<<<<<<<<<<<");
    }
            
}
