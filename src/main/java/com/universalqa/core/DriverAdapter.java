package com.universalqa.core;

public interface DriverAdapter {
        void click(String locator);
        void sendInput(String locator, String text);
        boolean isElementDisplayed(String locator);
        String getElementText(String locator);
        String getElementAttribute(String locator, String attribute);
        void clearFieldWithBackspace(String locator);
        void quit();
}
