package SeleniumSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {
    
    public static void main(String[] args) throws InterruptedException {
        
    
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.get("https://www.freecrm.com/");        
        
        driver.findElement(By.name("username")).sendKeys("naveenk");
        driver.findElement(By.name("password")).sendKeys("test@123");
        Thread.sleep(3000);        
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //switch to mainpanel
        driver.switchTo().frame("mainpanel");
        driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
        Thread.sleep(3000);
        
        /////////////////// PATTERN ///////////////////////
        //*[@id='vContactsForm']/table/tbody/tr[4]/td[2]/a
        //*[@id='vContactsForm']/table/tbody/tr[5]/td[2]/a
        //*[@id='vContactsForm']/table/tbody/tr[6]/td[2]/a
        //*[@id='vContactsForm']/table/tbody/tr[7]/td[2]/a
        //////////////////////////////////////////////////
        
        //Method - 1
        String before_xpath = "//*[@id='vContactsForm']/table/tbody/tr[";
        String after_xpath = "]/td[2]/a";
        
        for(int i = 4; i<=24; i++){
            String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
            System.out.println(name);
            
            //*[@id='vContactsForm']/table/tbody/tr[14]/td[1]/input
            if(name.contains("Aunty ya")){ //i = 11
                driver.findElement(By
                        .xpath("//*[@id='vContactsForm']/table/tbody/tr[" + i +"]/td[1]/input"))
                        .click();
            }
        }
        
        //Method - 2
        driver.findElement(By.xpath("//a[contains(text(),'A555 A666')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'David Dsouza')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'David2 Cris2')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'dddd dd')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
        
        System.out.println(">>>>>>>>>>>> All was successfuly <<<<<<<<<<<<<<<");
        //driver.close();
    }
    
}
