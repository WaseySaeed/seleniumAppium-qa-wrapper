package com.universalqa.tests;

import com.universalqa.core.DriverAdapter;
import com.universalqa.selenium.SeleniumAdapter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
    public static void main(String[] args) {
        // NOTE: This test is for demo purposes.
        // You can use your own driver factory or config setup.
        WebDriver driver = new ChromeDriver();
        DriverAdapter adapter = new SeleniumAdapter(driver);
        adapter.click("id=someButton");
    }
}
