import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SeleniumPlayground {

    WebDriver  driver;

    @Before
    public void setup(){

        System.setProperty("webdriver.edge.driver","C:\\Users\\balamugunthan.e\\Documents\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("http://www.leafground.com/home.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @Test
    public void TestRadioButtons(){
        System.out.println("Total number of anchor tags(links) "+driver.findElements(By.tagName("a")).size());
        driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[6]/a/img")).click();
        WebElement radioButton = driver.findElement(By.id("first"));
        Assert.assertTrue(radioButton.isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"first\"]/label[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"first\"]/label[2]")).click();
    }

    @Test
    public void TestDropdown(){
        driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[5]/a/img")).click();
        Select firstDropdown =  new Select(driver.findElement(By.id("dropdown1")));
        firstDropdown.selectByIndex(3);

        firstDropdown = new Select(driver.findElement(By.name("dropdown2")));
        firstDropdown.selectByValue("4");
    }


    @After
    public void teardown(){
        //driver.close();
        //driver.quit();

    }
}




