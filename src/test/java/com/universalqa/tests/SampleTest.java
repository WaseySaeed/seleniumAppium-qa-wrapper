package com.universalqa.tests;

import com.universalqa.core.DriverAdapter;
import com.universalqa.factory.DriverFactory;

public class SampleTest {
    public static void main(String[] args) {
        DriverAdapter driver = DriverFactory.getDriver(DriverFactory.DriverType.SELENIUM);

        driver.sendInput("#username", "admin");
        driver.click("#loginBtn");
        driver.quit();
    }
}
