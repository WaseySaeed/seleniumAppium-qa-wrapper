//package com.universalqa.factory;
//
//import com.universalqa.core.DriverAdapter;
//import com.universalqa.selenium.SeleniumAdapter;
//import com.universalqa.appium.AppiumAdapter;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.net.URL;
//
//public class DriverFactory {
//    public enum DriverType { SELENIUM, APPIUM }
//
//    public static DriverAdapter getDriver(DriverType type) {
//        if (type == DriverType.SELENIUM) {
//            return new SeleniumAdapter();
//        }
//        throw new IllegalArgumentException("For Appium, use getDriver with URL and DesiredCapabilities");
//    }
//
//    public static DriverAdapter getDriver(DriverType type, URL serverUrl, DesiredCapabilities caps) {
//        if (type == DriverType.APPIUM) {
//            return new AppiumAdapter(serverUrl, caps);
//        }
//        throw new IllegalArgumentException("This method is intended for Appium only");
//    }
//}