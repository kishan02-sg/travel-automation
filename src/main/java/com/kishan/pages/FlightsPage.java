package com.kishan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.kishan.utils.WaitUtil;

public class FlightsPage {

    WebDriver driver;

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseFirstFlight() {
        By chooseBtn = By.cssSelector("input[value='Choose This Flight']");
        WaitUtil.waitForElementClickable(driver, chooseBtn);
        driver.findElements(chooseBtn).get(0).click();
    }
}
