package SeleniumSessions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecuter {
    
    public static void main(String[] args) throws InterruptedException, IOException {
        
        WebDriver driver = new ChromeDriver();
        
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.get("https://www.freecrm.com/index.html");
        System.out.println("Before login, title is: "+driver.getTitle());
        Thread.sleep(1000);
        //driver.findElement(By.name("username")).sendKeys("Addf54245");
        //driver.findElement(By.name("password")).sendKeys("ytIyutuhK455");
        //driver.findElement(By.xpath("//input[@type='submit']")).submit();
        
        WebElement loginBttn = driver.findElement(By.xpath("//input[@type='submit']"));// Login Button
        
        //1. Highlight an Element twith JS Executor
        flash(loginBttn, driver);
        
        //2. DrawBorder around an Element twith JS Executor
        drawBorder(loginBttn, driver);
        //Take ScreenShot
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\SeleniumXY\\Images\\borderedElement.jpg"));
        
        //3. Generate custom Alert during Test Execution by JS Executor
        generateAlert(driver, "There is an issue with Login Button");
        
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(3000);
        alert.accept();
        
        //4. Click on an Element by using JaveScript
        clickElmentByJS(loginBttn,driver);
        
        //5. Refresh browser by using JavaScript By JS Executor
        refresheBrowserByJS(driver);
        Thread.sleep(4000);
        
        //6. Get Title by using JavaScript
        System.out.println("Title using JS is: "+getTitleByJS(driver));
        
        //7. Get InnerText of page by using JavaScript        
        System.out.println(getPageInnerText(driver));
//-----------------------------------------------------------------------------------        
        //8. Scroll Into View and Scroll Page Down with JS Exec until END 
        // the page
        //scrollPageDown(driver);
        
        //8. Scroll Into View and Scroll Page Down with JS Exec until element 
        // is found
        WebElement linkForgotPass = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]"));
        scrollIntoView(linkForgotPass, driver);
        
//-----------------------------------------------------------------------------------
        
        System.out.println("===============  All was successfuly ============");

        //driver.close();
    }
    
    public static void flash(WebElement element, WebDriver driver) throws InterruptedException{
        JavascriptExecutor jd = ((JavascriptExecutor)driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for(int i = 0; i < 15; i++){
            changeColor("rgb(0,200,0)",element,driver);//1
            changeColor(bgcolor,element,driver);//2
        }
    }
    
    public static void changeColor(String color, WebElement element, WebDriver driver) throws InterruptedException{
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
        
        try{
            Thread.sleep(20);
        } catch(InterruptedException e){
        }
    }
    
    public static void drawBorder(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'", element);
            
    }
    
    public static void generateAlert(WebDriver driver, String message){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('"+message+"')");
    
    }
    
    public static void clickElmentByJS(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);        
    
    } 
    
    public static void refresheBrowserByJS(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");      
    }

    public static String getTitleByJS(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }    
    
    public static String getPageInnerText(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String pageText = js.executeScript("return document.documentElement.innerText;").toString();
        return pageText;
    }
    
    public static void scrollPageDown(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    public static void scrollIntoView(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
