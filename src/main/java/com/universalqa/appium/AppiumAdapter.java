package com.universalqa.appium;

import com.universalqa.core.DriverAdapter;
import com.universalqa.utils.LocatorStrategy;
import com.universalqa.utils.LoggerUtil;
import com.universalqa.utils.RetryUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class AppiumAdapter implements DriverAdapter {
    private AndroidDriver driver;
    private static final Logger logger = LoggerUtil.getLogger(AppiumAdapter.class);
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    public AppiumAdapter(URL serverUrl, DesiredCapabilities caps) {
        driver = new AndroidDriver(serverUrl, caps);
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

    public void quit() {
        driver.quit();
    }
}
