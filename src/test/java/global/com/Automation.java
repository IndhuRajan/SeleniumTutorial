package global.com;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Automation {

    public String edgeDriverPath ="C:\\Users\\balamugunthan.e\\Documents\\WebDirvers\\msedgedriver.exe";
    public String dressName;
    public String dressSize;
    public String dressColour;
    public  WebDriver edgeDriver;

    public Automation(){
        System.setProperty("webdriver.edge.driver", this.edgeDriverPath);
        this.edgeDriver  = new EdgeDriver();
    }

    public void AddToCart(String dressName, String dressSize, String dressColour) throws InterruptedException {
        edgeDriver.navigate().to("http://automationpractice.com");
        edgeDriver.manage().window().maximize();
        edgeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        edgeDriver.findElement(By.id("search_query_top")).sendKeys(dressName);
       // Thread.sleep(2000);
        edgeDriver.findElement(By.name("submit_search")).click();
       // Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) edgeDriver;
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(2000);
        ////iframe[@id='fancybox-frame1667345524598']

        WebElement clickableImg = edgeDriver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
        Actions actions = new Actions(edgeDriver);
        actions.moveToElement(clickableImg).perform();
        edgeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        edgeDriver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
        edgeDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        //edgeDriver.switchTo().frame("fancybox-frame1667345524598");
        //edgeDriver.switchTo().frame(edgeDriver.findElement(By.xpath("//span[contains(text(),'More')]")));
        //edgeDriver.navigate().to("http://automationpractice.com/index.php?id_product=1&controller=product&search_query=Faded+Short+Sleeve+T+Shirt&results=1");
        //edgeDriver.switchTo().activeElement();
        //sleep
       // Thread.sleep(2000);
      //  1-s 2-M 3-L

        WebElement SizeDropdown = edgeDriver.findElement(By.tagName("select"));
        SizeDropdown.click();
        Select select = new Select(SizeDropdown);
       // Thread.sleep(2000);
        int dressSizeByIndex = 0;
        if(dressSize.equalsIgnoreCase("S")){
            dressSizeByIndex = 0;
        }
        else if(dressSize.equalsIgnoreCase("M")){
            dressSizeByIndex = 1;
        }
        else if(dressSize.equalsIgnoreCase("L")){
            dressSizeByIndex = 2;
        }
        select.selectByIndex(dressSizeByIndex);

       // Thread.sleep(2000);
        //select[@id="group_1"]  blue=color_14   orange= color_13  beige= color_7

        String dressColourByName="null";
        if(dressColour.equalsIgnoreCase("blue")){
            dressColourByName="color_14";
        }
        else if(dressColour.equalsIgnoreCase("orange")){
            dressColourByName="color_13";
        }
        else if(dressColour.equalsIgnoreCase("beige")){
            dressColourByName="color_7";
        }
        edgeDriver.findElement(By.id(dressColourByName)).click();

        WebElement addToCart = edgeDriver.findElement(By.name("Submit"));
        // Actions actions = new Actions(driver);
        actions.moveToElement(addToCart).click().build().perform();


    }

   // public void tearDown(){
     //   edgeDriver.close();
   // }

    public static void main(String[] args) throws InterruptedException, AWTException {

        Automation automation = new Automation();
        automation.AddToCart("Faded Short Sleeve T Shirt","M","Blue");
        automation.AddToCart("Evening Dress","S","beige");
        automation.AddToCart("Printed Summer Dress","M","orange");
       // automation.tearDown();


    }

}
