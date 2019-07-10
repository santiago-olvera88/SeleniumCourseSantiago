package SeleniumSessions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshot {
    
    public static void main(String[] args) throws IOException {
        
        WebDriver driver = new ChromeDriver();
        
        driver.manage().deleteAllCookies();        
        driver.manage().window().maximize();
        //Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);// For the page
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// For elements
        driver.get("https://www.google.com/");
        
        //Take screenshot and store as a file format
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Now copy the Screenshot to desired location using copyFile //method
        FileUtils.copyFile(src,new File("C:\\SeleniumJava\\CourseNaveen\\Images\\image.jpg"));
        
        
        
    }
}
