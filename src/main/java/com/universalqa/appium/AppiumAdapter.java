package com.universalqa.appium;

import com.universalqa.core.DriverAdapter;
import com.universalqa.utils.LocatorStrategy;
import com.universalqa.utils.LoggerUtil;
import com.universalqa.utils.RetryUtil;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppiumAdapter implements DriverAdapter {

    private final AppiumDriver driver;
    private static final Logger logger = LoggerUtil.getLogger(AppiumAdapter.class);
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    public AppiumAdapter(AppiumDriver driver) {
        this.driver = driver;
    }

    public void click(String locator) {
        RetryUtil.retry(() -> {
            By by = LocatorStrategy.resolve(locator);
            WebElement element = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.elementToBeClickable(by));
            element.click();
            return null;
        }, "click", locator, logger);
    }

    public void sendInput(String locator, String text) {
        RetryUtil.retry(() -> {
            By by = LocatorStrategy.resolve(locator);
            WebElement element = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
            element.clear();
            element.sendKeys(text);
            return null;
        }, "type", locator, logger);
    }

    public boolean isElementDisplayed(String locator) {
        try {
            By by = LocatorStrategy.resolve(locator);
            WebElement element = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getElementText(String locator) {
        By by = LocatorStrategy.resolve(locator);
        WebElement element = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.getText();
    }

    public String getElementAttribute(String locator, String attribute) {
        By by = LocatorStrategy.resolve(locator);
        WebElement element = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.getAttribute(attribute);
    }

    public void clearFieldWithBackspace(String locator) {
        RetryUtil.retry(() -> {
            By by = LocatorStrategy.resolve(locator);
            WebElement element = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));

            String value = element.getAttribute("value");
            if (value == null || value.isEmpty()) {
                value = element.getAttribute("text");
            }

            element.click();
            for (int i = 0; i < value.length(); i++) {
                element.sendKeys(Keys.BACK_SPACE);
            }
            return null;
        }, "clearFieldWithBackspace", locator, logger);
    }

    public void quit() {
        driver.quit();
    }
}