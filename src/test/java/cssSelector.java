import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class cssSelector {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver","C:\\Users\\balamugunthan.e\\Documents\\WebDirvers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("Faded short sleeve Tshirt");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("body.index.hide-left-column.hide-right-column.lang_en:nth-child(2) div.header-container div.container div.row div.col-sm-4.clearfix:nth-child(2) form:nth-child(1) > button.btn.btn-default.button-search:nth-child(5)")).click();
        Thread.sleep(2000);
        JavascriptExecutor js= (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(2000);
        //driver.findElement(By.name("search hide-right-column lang_en")).click();
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        driver.quit();



    }
}
