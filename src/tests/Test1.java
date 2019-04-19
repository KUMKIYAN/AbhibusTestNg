package tests;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.BookATicketPage;

public class Test1 {

        WebDriver driver;
        HomePage homePage;
        BookATicketPage bookATicketPage;

        @BeforeTest
        public void setup(){
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://www.abhibus.com/");
        }

        @Test(priority=0)
        public void test_Home_Page_Appear_Correct() throws InterruptedException {

            homePage = new HomePage(driver);

            String homePageTitile = homePage.getMainBannerToolTip();
            Assert.assertTrue(homePageTitile.equals("abhibus.com - India's Fastest Online bus ticket booking site"));

            homePage.setTravelingFrom("Hyderabad");
            homePage.setTravelingTo("Tirupathi");
            homePage.setTravelingDates("19-04-2019", "22-04-2019");
            homePage.search();

            bookATicketPage = new BookATicketPage(driver);
            bookATicketPage.selectATraveller();
            bookATicketPage.selectASeat();
            bookATicketPage.selectDepartureBoardingPoint();
            bookATicketPage.bookTheSeat();

            bookATicketPage.selectReturnTraveller();
            bookATicketPage.selectReturnTicket();
            bookATicketPage.selectReturnBoardingPoint();

            bookATicketPage.selectContinuePayment();
            driver.quit();
        }
}
