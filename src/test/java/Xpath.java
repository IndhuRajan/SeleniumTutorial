import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Xpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Users\\balamugunthan.e\\Documents\\WebDirvers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("printed summer dress");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();
        Thread.sleep(2000);

           // driver.close();

        //WebDriver driver = new EdgeDriver();
        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();

        driver.findElement(By.id("search_query_top")).sendKeys("Faded Short Sleeve T Shirt");
        Thread.sleep(2000);
        driver.findElement(By.name("submit_search")).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(3000);
        //  driver.findElement(By.linkText("http://automationpractice.com/index.php?id_product=1&controller=product")).click();
        //  Thread.sleep(2000);
        WebElement clickableImg = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(clickableImg).click().build().perform();
        driver.navigate().to("http://automationpractice.com/index.php?id_product=1&controller=product&search_query=Faded+Short+Sleeve+T+Shirt&results=1");
        driver.switchTo().activeElement();
        Thread.sleep(2000);

        WebElement SizeDropdown = driver.findElement(By.tagName("select"));
        SizeDropdown.click();
        Select select = new Select(SizeDropdown);
        Thread.sleep(2000);
        select.selectByIndex(1);
//select[@id="group_1"]
        Thread.sleep(2000);
        //select[@id="group_1"]  color_14
        driver.findElement(By.id("color_14")).click();

        // driver.findElement(By.className("icon-chevron-left left")).click();
        //driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/span[1]")).click();
//    way1    driver.getWindowHandle();
//        driver.switchTo().activeElement();
//        driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[1]/span[1]")).click();
//        driver.switchTo().defaultContent();
        //  name= Submit (add to cart)
        WebElement addToCart = driver.findElement(By.name("Submit"));
        // Actions actions = new Actions(driver);
        actions.moveToElement(addToCart).click().build().perform();

        String parentWindow = driver.getWindowHandle();
        driver.switchTo().window(parentWindow);
        //continue btn btn-default button exclusive-medium  (continue shopping) icon-chevron-left left=class
        // Robot robot= new Robot();
        //  robot.mouseMove(400,5);
        //robot.mousePress(InputEvent.BUTTON1_DOWN_MASK );
        //robot.mouseRelease(InputEvent.BUTTON1_DOW

        //driver.findElement(By.className("cross")).click();


        // String cssSelectorForImage = "#__next > div.ed-grid > div.ed-grid-main > div > div.w-full.-mt-2.sm\\:mt-0 > div > div.w-full.lg\\:w-3\\/4.mt-12 > div > div > div > div:nth-child(1) > svg";
        // driver.findElement(By.cssSelector(cssSelectorForImage)).click();
//img[@alt="Faded Short Sleeve T-shirts"]//preceding::a[@title="Faded Short Sleeve T-shirts"]
        // driver.close();
        // String getImageUrl=image.getAttribute("href");
        //  System.out.println(getImageUrl);



    }
}
