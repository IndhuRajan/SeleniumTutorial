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
import java.security.PublicKey;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Automation {

    public String edgeDriverPath = "C:\\Users\\balamugunthan.e\\Documents\\WebDirvers\\msedgedriver.exe";
    public String dressName;
    public String dressSize;
    public String dressColour;
    public WebDriver edgeDriver;

    public Automation() {
        System.setProperty("webdriver.edge.driver", this.edgeDriverPath);
        this.edgeDriver = new EdgeDriver();
    }

    public void AddToCart(String dressName, String dressSize, String dressColour) throws InterruptedException {
        edgeDriver.navigate().to("http://automationpractice.com");
        edgeDriver.manage().window().maximize();
        edgeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        edgeDriver.findElement(By.id("search_query_top")).sendKeys(dressName);
        edgeDriver.findElement(By.name("submit_search")).click();
        JavascriptExecutor js = (JavascriptExecutor) edgeDriver;
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(2000);


        WebElement clickableImg = edgeDriver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
        Actions actions = new Actions(edgeDriver);
        actions.moveToElement(clickableImg).perform();
        edgeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        edgeDriver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
        edgeDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        WebElement SizeDropdown = edgeDriver.findElement(By.tagName("select"));
        SizeDropdown.click();
        Select select = new Select(SizeDropdown);
        int dressSizeByIndex = 0;
        if (dressSize.equalsIgnoreCase("S")) {
            dressSizeByIndex = 0;
        } else if (dressSize.equalsIgnoreCase("M")) {
            dressSizeByIndex = 1;
        } else if (dressSize.equalsIgnoreCase("L")) {
            dressSizeByIndex = 2;
        }
        select.selectByIndex(dressSizeByIndex);

        String dressColourByName = "null";
        if (dressColour.equalsIgnoreCase("blue")) {
            dressColourByName = "color_14";
        } else if (dressColour.equalsIgnoreCase("orange")) {
            dressColourByName = "color_13";
        } else if (dressColour.equalsIgnoreCase("beige")) {
            dressColourByName = "color_7";
        }
        edgeDriver.findElement(By.id(dressColourByName)).click();

        WebElement addToCart = edgeDriver.findElement(By.name("Submit"));
        actions.moveToElement(addToCart).click().build().perform();
        edgeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void checkOut() {
        edgeDriver.findElement(By.xpath("//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]")).click();
    }

    public void removeEveningDress() {
        edgeDriver.findElement(By.id("4_16_0_0")).click();
        edgeDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void addingSecondDress() throws InterruptedException {
        AddToCart("Faded Short Sleeve T Shirt", "M", "Blue");
        checkOut();
    }

    public void AssertEachProduct() {
        Assert.assertEquals("$33.02", edgeDriver.findElement(By.id("total_product_price_1_1_0")).getText());
        Assert.assertEquals("$28.98", edgeDriver.findElement(By.id("total_product_price_5_25_0")).getText());
    }

    public void AssertCartTotal() {
        String cartTotal = edgeDriver.findElement(By.id("total_price_container")).getText();
        System.out.println("Cart value - " + cartTotal);
        Assert.assertEquals("$65.53", cartTotal);

    }
     public void tearDown(){
       edgeDriver.close();
     }

    public static void main(String[] args) throws InterruptedException, AWTException {

        Automation automation = new Automation();
        automation.AddToCart("Faded Short Sleeve T Shirt","M","Blue");
        automation.AddToCart("Evening Dress","S","beige");
        automation.AddToCart("Printed Summer Dress","M","orange");
        automation.checkOut();
        automation.removeEveningDress();
        automation.addingSecondDress();
        automation.AssertCartTotal();
        automation.AssertEachProduct();
        automation.tearDown();


    }

}
