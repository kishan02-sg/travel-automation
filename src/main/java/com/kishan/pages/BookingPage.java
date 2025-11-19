package com.kishan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.kishan.utils.WaitUtil;

public class BookingPage {

    WebDriver driver;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm() {
        WaitUtil.waitForElementVisible(driver, By.id("inputName"));
        driver.findElement(By.id("inputName")).sendKeys("Kishan");
        driver.findElement(By.id("address")).sendKeys("1 Test Street");
        driver.findElement(By.id("city")).sendKeys("Coimbatore");
        driver.findElement(By.id("state")).sendKeys("TN");
        driver.findElement(By.id("zipCode")).sendKeys("641042");
        driver.findElement(By.id("creditCardNumber")).sendKeys("4111111111111111");
        driver.findElement(By.id("creditCardMonth")).clear();
        driver.findElement(By.id("creditCardMonth")).sendKeys("12");
        driver.findElement(By.id("creditCardYear")).clear();
        driver.findElement(By.id("creditCardYear")).sendKeys("2027");
    }

    public void clickPurchase() {
        By purchaseBtn = By.cssSelector("input.btn.btn-primary");
        WaitUtil.waitForElementClickable(driver, purchaseBtn);
        driver.findElement(purchaseBtn).click();
    }
}
