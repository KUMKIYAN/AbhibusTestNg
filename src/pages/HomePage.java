package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By homeBanner = By.xpath("//img[@src='https://static.abhibus.com/img/logo1.png']");
    By departureFrom  = By.id("source");
    By arrivalTo  = By.id("destination");
    By travelingDate = By.id("datepicker1");
    By returningDate = By.id("datepicker2");
    By searchTravel = By.xpath("//a[@class='btnab icosearch']");


    String selectCity  = "//li[text() = '{arg}']";

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void setTravelingFrom(String source){
        driver.findElement(departureFrom).sendKeys(source);
        selectCityFromAutoComplete(source);
    }

    public void setTravelingTo(String destination){
        driver.findElement(arrivalTo).sendKeys(destination);
        selectCityFromAutoComplete(destination);
    }

    public void selectCityFromAutoComplete(String city){
        By selectCity = By.xpath(this.selectCity.toString().replace("{arg}", city));
        driver.findElement(selectCity).click();
    }

    public void setTravelingDates(String journeyDate, String returnDate){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+ journeyDate + "'", driver.findElement(travelingDate));
        js.executeScript("arguments[0].value='"+  returnDate + "'", driver.findElement(returningDate));
    }

    public void search(){
        driver.findElement(searchTravel).click();
    }

    public String getMainBannerToolTip(){
        return driver.findElement(homeBanner).getAttribute("alt");
    }
}
