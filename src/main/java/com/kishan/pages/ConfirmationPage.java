package com.kishan.pages;

import org.openqa.selenium.WebDriver;
import com.kishan.utils.WaitUtil;

public class ConfirmationPage {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isBookingConfirmed() {
        return WaitUtil.waitForPageContainsText(driver, "thank", 8);
    }
}
