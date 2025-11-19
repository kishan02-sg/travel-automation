package com.kishan.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.kishan.base.BrowserSetup;
import com.kishan.pages.SearchPage;
import com.kishan.pages.FlightsPage;
import com.kishan.pages.BookingPage;
import com.kishan.pages.ConfirmationPage;
import com.kishan.utils.ScreenshotUtil;
import com.kishan.utils.WaitUtil;
import com.kishan.utils.ExtentManager;

public class BlazeDemoTest {

    @Test
    public void bookFlightTest() throws Exception {

        ExtentManager.initReport();
        ExtentTest test = ExtentManager.startTest("BlazeDemo Booking Test");

        WebDriver driver = new BrowserSetup().launchBrowser();

        try {
            SearchPage search = new SearchPage(driver);
            search.openSite();
            test.info("Opened site");
            ScreenshotUtil.take(driver, "01_HomePage");

            search.selectCities("Boston", "Rome");
            test.pass("Selected cities");
            ScreenshotUtil.take(driver, "02_CitiesSelected");

            search.clickFindFlights();
            test.pass("Clicked Find Flights");
            ScreenshotUtil.take(driver, "03_FindFlights");

            FlightsPage flights = new FlightsPage(driver);
            flights.chooseFirstFlight();
            test.pass("Selected first flight");
            ScreenshotUtil.take(driver, "04_FirstFlight");

            BookingPage book = new BookingPage(driver);
            book.fillForm();
            test.pass("Filled booking form");
            ScreenshotUtil.take(driver, "05_FormFilled");

            book.clickPurchase();
            test.pass("Clicked Purchase");
            ScreenshotUtil.take(driver, "06_AfterPurchase");

            ConfirmationPage confirm = new ConfirmationPage(driver);
            boolean ok = confirm.isBookingConfirmed();
            ScreenshotUtil.take(driver, "07_Confirmation");

            Assert.assertTrue(ok, "Booking Failed");
            test.pass("Booking Confirmed");

        } finally {
            driver.quit();
            ExtentManager.flushReport();
        }
    }
}
