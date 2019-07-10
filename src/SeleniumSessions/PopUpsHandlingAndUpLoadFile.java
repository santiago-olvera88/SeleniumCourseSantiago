/*
 * 1.- Alerts -- JavaScript Pop Upp -- Alert API (accept, dimiss)
 *
 * 2.- File Upload Pop Up -- Browse Button (type = "file", senKeys(path))
 *     type = "file" should be present for Browse/AttachFile/UploadFile.
 *
 * 3.- Browser Window PopUp - Adverstisemnt Pop Up (windowHandler API - getWindosHandles)
 */
package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PopUpsHandlingAndUpLoadFile {
    
    public static void main(String[] args) throws InterruptedException {
        
//        AlertByIsPresent();
//        AlertByswitchTo();
//        FileUploadPopUp();
        WindowPopUp();
    }
    
    public static void AlertByswitchTo() throws InterruptedException{
        
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Implicit Wait --->> Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// For the page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// For elments
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");   
        
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
        System.out.println("======== Test was AlertByswitchTo done successfully ========");
    
    }
    
    public static void AlertByIsPresent() throws InterruptedException{
        
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Implicit Wait --->> Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// For the page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// For elments
        
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");   
        driver.findElement(By.name("proceed")).click();
        Thread.sleep(3000);
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(myAlert.getText());
        myAlert.accept();
        
        driver.close();
        System.out.println(">>>>>>>> Test was AlertByIsPresent done successfully <<<<<<<<<<<<<");
    }
    
    public static void FileUploadPopUp(){

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Implicit Wait --->> Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// For the page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// For elments

        driver.get("http://html.com/input-type-file/");        
        
        String pathFile = "C:\\Users\\uidq3530\\Downloads\\30571180_1699703270091325_2608180647830749184_o.jpg";
        driver.findElement(By.xpath("//*[@id=\'fileupload\']")).sendKeys(pathFile);
        driver.close();
        
        System.out.println(">>>>>>>> Test was FileUploadPopUp done successfully <<<<<<<<<<<<<");              
    }
    
    public static void WindowPopUp() throws InterruptedException{
        
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Implicit Wait --->> Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// For the page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// For elements
        driver.get("http://www.popuptest.com/goodpopups.html");
        
        driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/font/b/a[1]")).click();
        
        Set<String> handler = driver.getWindowHandles();
        Iterator<String> it = handler.iterator();
        
        String parentWindowId = it.next();
        System.out.println("Parent window id: "+parentWindowId);
        
        String childWindowId = it.next();
        System.out.println("Parent window id: "+childWindowId);
        
        driver.switchTo().window(childWindowId);
        
        Thread.sleep(2000);
        
        System.out.println("Child Window pop up title is: "+ driver.getTitle());
        
        driver.close();
        
        driver.switchTo().window(parentWindowId);
        
        Thread.sleep(2000);
        
        System.out.println("Parent window title is: "+driver.getTitle());
        
        System.out.println(">>>>>>>> Test was WindowPopUp done successfully <<<<<<<<<<<<<");         
        
    }    
}
