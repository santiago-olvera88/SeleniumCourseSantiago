package SeleniumSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait2 {
    
    public static void main(String[] args) {
        
        String Url = "https://www.google.com/intl/es/gmail/about/";
        String mail = "coapan23@gmail.com";
        String pass = "eliseos88*O";
        
        WebDriver driver = new FirefoxDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Url);
                
        driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
        
        //Calling sendKeysOn
        sendKeysOn(driver, driver.findElement(By.xpath("//input[@name='password']")), 20,pass);
        
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
        
        //Calling clickOn
        clickOn(driver, driver.findElement(By.xpath("//span[@class='gb_db gbii']")), 10);
        
        driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();
        
        driver.close();
        
        System.out.println(">>>>>>>>>> All was successfuly <<<<<<"); 
                        
    }
    
    public static void clickOn(WebDriver driver, WebElement locator, int timeout){
    
        new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
        locator.click();
    }
    
    public static void sendKeysOn(WebDriver driver, WebElement locator_2, int timeout,String text){
    
        new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(locator_2));
        locator_2.sendKeys(text);
    }    
}
