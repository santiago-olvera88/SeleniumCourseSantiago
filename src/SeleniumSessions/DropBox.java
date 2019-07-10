package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropBox {
    
    public static void main(String[] args) {
        
        String url = "https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=";
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get(url);
                
        driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Santi");
        driver.findElement(By.id("lastname")).sendKeys("Olvera");
        driver.findElement(By.name("address1")).sendKeys("River 12, sea");
        driver.findElement(By.cssSelector("#address2")).sendKeys("Among ST, RT and FR");
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Guadalajara");
        //Handle Dropox
        Select selectState = new Select(driver.findElement(By.id("state")));
        selectState.selectByVisibleText("Connecticut");
        
        driver.findElement(By.id("zip")).sendKeys("44960");
        driver.findElement(By.id("dayphone1")).sendKeys("311");
        driver.findElement(By.name("dayphone2")).sendKeys("119");
        driver.findElement(By.cssSelector("#dayphone3")).sendKeys("1418");
        driver.findElement(By.cssSelector("#dayphone3")).sendKeys("1418");
        driver.findElement(By.xpath("//*[@id=\"dayphone4\"]")).sendKeys("10");
        driver.findElement(By.id("email")).sendKeys("coapan_17@yahoo.com");
        driver.findElement(By.xpath("//*[@id='retype_email']")).sendKeys("coapan_17@yahoo.com");
        driver.findElement(By.name("userid")).sendKeys("Santi2020");
        driver.findElement(By.id("PASSWORD")).sendKeys("coapan4545");
        driver.findElement(By.cssSelector("#rpass")).sendKeys("coapan4545");
       
        Select selectSQuestion = new Select(driver.findElement(By.id("SECRET_QUESTION")));
        selectSQuestion.selectByVisibleText("What is your pet's name?");
        
        driver.findElement(By.id("SECRET_ANSWER")).sendKeys("Oso");
       
        Select selectMonth = new Select(driver.findElement(By.id("birthdate2")));
        selectMonth.selectByVisibleText("September");
        
        Select selectDay = new Select(driver.findElement(By.id("birthdate1")));
        selectDay.selectByVisibleText("10");
        
        Select selectYear = new Select(driver.findElement(By.id("birthdate3")));
        selectYear.selectByVisibleText("1988");
        
        driver.findElement(By.id("acceptq1")).click();
        
    }
    
}
