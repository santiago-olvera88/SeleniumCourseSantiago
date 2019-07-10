package SantiagoSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail {
    
    public static WebDriver driver;
    public static String Url = "https://www.google.com/intl/es/gmail/about/";
    public static String mail = "coapan23@gmail.com";
    public static String pass = "eliseos88*O";
    
    public static void main(String[] args) throws InterruptedException {
        eGmail();
        eGmail_2();
    }
    
    public static void eGmail() throws InterruptedException{
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Url);
                
        driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
        
        //Explicit Wait by Lacated
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        passField.sendKeys(pass);
        
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
        
        //Explicit Wait by Visibility
        WebElement closeSession = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='gb_db gbii']")));
        closeSession.click();
        
        driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();
        
        System.out.println(">>>>>>>>>> All was successfuly <<<<<<");     
    }
    
    public static void eGmail_2(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Url);
                
        driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
        
        //Explicit Wait by Clickable
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement passField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        passField.sendKeys(pass);
        
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
        
        //Explicit Wait by Clickable
        WebElement closeSession = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='gb_db gbii']")));
        closeSession.click();
        
        driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();
        
        System.out.println(">>>>>>>>>> All was successfuly <<<<<<"); 
    }
}
