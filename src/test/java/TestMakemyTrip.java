import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TestMakemyTrip {

    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\balamugunthan.e\\Documents\\WebDirvers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void SearchRoundtrip(){
        driver.get("https://www.makemytrip.com/");
        //driver.findElement(By.id("fromCity")).clear();
        //driver.findElement(By.id("toCity")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div[8]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a")).click();

        Select filters = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div/div[1]")));
        filters.selectByIndex(1);

    }

    @After
    public void teardown(){
        driver.close();
        driver.quit();
    }

}
