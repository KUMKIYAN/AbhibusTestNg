package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.rmi.server.ExportException;

public class BookATicketPage {


    WebDriver driver;
    By findATravler  = By.xpath("//div[@id='SerVicesDetOneway1']//span[@class='book']");
    By findASeat  = By.xpath("//div[@id='SerVicesDetOneway1']//li[@class='seat available']/a");
    By findABirth  = By.xpath("//div[@id='SerVicesDetOneway1']//li[@class='sleeper available']/a");
    By boardingPointFromDeparture = By.id("boardingpoint_id1");
    By bookASeat = By.id("btnEnable1");

    By findReturnTravler  = By.xpath("//div[@id='SerVicesDetOneway2']//span[@class='book']");
    By findReturnSeat  = By.xpath("//div[@id='SerVicesDetOneway2']//li[@class='seat available']/a");
    By findReturnBirth  = By.xpath("//div[@id='SerVicesDetOneway2']//li[@class='sleeper available']/a");
    By boardingPointFromReturn = By.id("boardingpoint_id2");

    By continuePayment = By.xpath("//input[@value='Continue to Payment '][2]");

    public BookATicketPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectATraveller(){
        driver.findElements(findATravler).get(0).click();
    }

    public void selectReturnTraveller(){
        driver.findElements(findReturnTravler).get(0).click();
    }

    public void selectASeat(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElements(findATravler).get(0));
        Actions selection = new Actions(driver);
        try {
            selection.click(driver.findElements(findASeat).get(0));
            Action action = selection.build();
            action.perform();
        }catch(Exception e){
            selection.click(driver.findElements(findABirth).get(0));
            Action action = selection.build();
            action.perform();
        }
    }


    public void selectReturnTicket(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElements(findReturnTravler).get(0));
        Actions selection = new Actions(driver);
        try {
            selection.click(driver.findElements(findReturnSeat).get(0));
            Action action = selection.build();
            action.perform();
        }catch(Exception e){
            selection.click(driver.findElements(findReturnBirth).get(0));
            Action action = selection.build();
            action.perform();
        }
    }

    public void selectDepartureBoardingPoint(){
        new Select(driver.findElement(boardingPointFromDeparture)).selectByIndex(1);
    }

    public void selectReturnBoardingPoint(){
        new Select(driver.findElement(boardingPointFromReturn)).selectByIndex(1);
    }

    public void bookTheSeat(){
        driver.findElement(bookASeat).click();
    }

    public void selectContinuePayment(){
        driver.findElement(continuePayment).click();
    }

}
