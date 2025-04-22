package com.universalqa.selenium;

import com.universalqa.core.DriverAdapter;
import com.universalqa.utils.LocatorStrategy;
import com.universalqa.utils.LoggerUtil;
import com.universalqa.utils.RetryUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumAdapter implements DriverAdapter {

    private final WebDriver driver;
    private static final Logger logger = LoggerUtil.getLogger(SeleniumAdapter.class);
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    public SeleniumAdapter(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void click(String locator) {
        RetryUtil.retry(() -> {
            By by = LocatorStrategy.resolve(locator);
            WebElement element = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.elementToBeClickable(by));
            element.click();
            return null;
        }, "click", locator, logger);
    }

    @Override
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

    @Override
    public boolean isElementDisplayed(String locator) {
        return RetryUtil.retry(() -> {
            By by = LocatorStrategy.resolve(locator);
            WebElement element = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
            return element.isDisplayed();
        }, "isElementDisplayed", locator, logger);
    }

    @Override
    public String getElementText(String locator) {
        By by = LocatorStrategy.resolve(locator);
        WebElement element = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.getText();
    }

    @Override
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

    @Override
    public boolean waitForVisible(String locator) {
        try {
            By by = LocatorStrategy.resolve(locator);
            new WebDriverWait(driver, DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            logger.warn("Element not visible: " + locator);
            return false;
        }
    }

    @Override
    public void quit() {
        driver.quit();
    }
}