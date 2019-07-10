package SeleniumSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
    
    public static void main(String[] args) throws InterruptedException {
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
        
        //Explicit wait by Lacated
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        passField.sendKeys(pass);
        
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
        
        //Explicit Wait by Clickable
        WebElement closeSession = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='gb_db gbii']")));
        closeSession.click();
        
        driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();
        
        System.out.println(">>>>>>>>>> All was successfuly <<<<<<"); 
    }
}
