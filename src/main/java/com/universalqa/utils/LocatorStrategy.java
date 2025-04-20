package com.universalqa.utils;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

/**
 * Resolves locator strings with strategy prefixes into Selenium/Appium By objects.
 * Supported formats: id=, name=, css=, xpath=, class=, tag=, linkText=, partialLinkText=,
 * accessibilityId=, androidUIAutomator=
 */
public class LocatorStrategy {
    public static By resolve(String locator) {
        if (locator.startsWith("id=")) {
            return By.id(locator.substring(3));
        } else if (locator.startsWith("name=")) {
            return By.name(locator.substring(5));
        } else if (locator.startsWith("css=")) {
            return By.cssSelector(locator.substring(4));
        } else if (locator.startsWith("xpath=")) {
            return By.xpath(locator.substring(6));
        } else if (locator.startsWith("class=")) {
            return By.className(locator.substring(6));
        } else if (locator.startsWith("tag=")) {
            return By.tagName(locator.substring(4));
        } else if (locator.startsWith("linkText=")) {
            return By.linkText(locator.substring(9));
        } else if (locator.startsWith("partialLinkText=")) {
            return By.partialLinkText(locator.substring(16));
        } else if (locator.startsWith("accessibilityId=")) {
            return MobileBy.AccessibilityId(locator.substring(16));
        } else if (locator.startsWith("androidUIAutomator=")) {
            return MobileBy.AndroidUIAutomator(locator.substring(19));
        } else {
            return By.id(locator); // Default fallback
        }
    }
}