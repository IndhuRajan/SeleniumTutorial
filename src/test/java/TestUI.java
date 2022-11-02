import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestUI {



    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver","C:\\Users\\balamugunthan.e\\Documents\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://www.linkedin.com/");
        driver.findElement(By.linkText("Sign in")).click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getTitle().contains("Sign in"));

        //signing in using id & pwd

        try {
//            driver.findElement(By.id("username")).sendKeys("balamugunthan11a@gmail.com");
//            driver.findElement(By.id("password")).sendKeys("Bala14308#");
//            driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[3]/button")).click();
            driver.findElement(By.partialLinkText("User Agreement")).click();
            WebDriverWait wait = new WebDriverWait(driver, 6);
            wait.until(ExpectedConditions.elementToBeClickable(By.className("ytp-large-play-button ytp-button")));

        }

        catch (Exception e){
            e.printStackTrace();
        }

        finally {
            driver.close();
            driver.quit();
        }

    }
}
