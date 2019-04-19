package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
public static void main(String args[]){
    WebElement seat;
    System. setProperty("webdriver.chrome.driver", "/Users/nisum/Documents/drivers/chromedriver");
    WebDriver driver=new ChromeDriver();
    driver.get("https://www.abhibus.com/");
   // driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);

    driver.findElement(By.xpath("//div[@class='field field1']/input")).sendKeys("Hyderabad");
    driver.findElement(By.xpath("//li[text() = '"+"Hyderabad"+ "']")).click();

    driver.findElement(By.xpath("//div[@class='field field2']/input")).sendKeys("Tirupathi");
    driver.findElement(By.xpath("//li[text() = '"+"Tirupathi"+ "']")).click();

    WebElement datepick = driver.findElement(By.id("datepicker1"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].value='19-04-2019'", datepick);
    datepick = driver.findElement(By.id("datepicker2"));
    js.executeScript("arguments[0].value='22-04-2019'", datepick);

    driver.findElement(By.xpath("//a[@class='btnab icosearch']")).click();




    driver.findElement(By.xpath("//div[@id='SerVicesDetOneway1']//span[@class='book']")).click();
    try {
        seat = driver.findElement(By.xpath("//div[@class='seats']/ul[1]/li[@class='seat available'][1]/a"));
        Actions ob = new Actions(driver);
        ob.click(seat);
        Action action  = ob.build();
        action.perform();


    } catch (Exception e){
        seat = driver.findElement(By.xpath("//div[@class='seats']/ul[1]/li[@class='sleeper available'][1]/a"));
        Actions ob = new Actions(driver);
        ob.click(seat);
        Action action  = ob.build();
        action.perform();
    }

   // driver.findElement(By.id("btnEnable1")).click();
    Select oSelect = new Select(driver.findElement(By.id("boardingpoint_id1")));
    oSelect.selectByIndex(1);
    driver.findElement(By.xpath("//input[@id='btnEnable1']")).click();

    driver.findElement(By.xpath("//div[@id='SerVicesDetOneway2']//a/span[@class='book']")).click();
    try {
        seat = driver.findElement(By.xpath("//div[@id='SerVicesDetOneway2']//div[@class='seats']/ul[1]/li[@class='seat available'][1]/a"));
        Actions ob2 = new Actions(driver);
        ob2.click(seat);
        Action action2  = ob2.build();
        action2.perform();
    }catch (Exception e){
        System.out.println(e.getMessage() + "kiyan");
        WebElement seats =  driver.findElement(By.xpath("//div[@class='seats']/ul[1]/li[@class='sleeper available'][1]/a/span"));
        Actions ob2 = new Actions(driver);
        ob2.click(seat);
        Action action2  = ob2.build();
        action2.perform();
    }
    oSelect = new Select(driver.findElement(By.id("boardingpoint_id2")));
    oSelect.selectByIndex(1);

    }
}
