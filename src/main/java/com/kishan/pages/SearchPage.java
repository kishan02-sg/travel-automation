package com.kishan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.kishan.utils.WaitUtil;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite() {
        driver.get("https://blazedemo.com/");
    }

    public void selectCities(String from, String to) {
        Select fromCity = new Select(driver.findElement(By.name("fromPort")));
        Select toCity = new Select(driver.findElement(By.name("toPort")));
        fromCity.selectByVisibleText(from);
        toCity.selectByVisibleText(to);
    }

    public void clickFindFlights() {
        By findBtn = By.cssSelector("input.btn.btn-primary");
        WaitUtil.waitForElementClickable(driver, findBtn);
        driver.findElement(findBtn).click();
    }
}
