import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class WebElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Users\\balamugunthan.e\\Documents\\WebDirvers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("http://testleaf.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.className("wp-categories-title")).click();
        Thread.sleep(2000);
        //driver.findElement(By.id("email")).sendKeys("indhubala@gmail.com");
       // Thread.sleep(3000);
        driver.navigate().to("https://www.google.com/");
       driver.manage().getCookies();
       // driver.findElement(By.className("QS5gu sy4vM")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("q")).sendKeys("cheese");
        Thread.sleep(2000);

        driver.close();

    }
}
