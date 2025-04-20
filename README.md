# Universal QA Automation Wrapper Library

A lightweight, tool-agnostic Java library that provides a unified interface for interacting with Selenium and Appium-based automation, with built-in retries, logging, dynamic locator support, and test-friendly utilities.

## ✅ Features
- Unified `DriverAdapter` for web and mobile
- Supports `id=`, `xpath=`, `css=`, `accessibilityId=`, `androidUIAutomator=`, and more
- Retry mechanism built-in for all actions
- Log4j2 logging and action tracking
- Utility helpers for dynamic test data

## 📦 Installation
Clone and add the library to your project as a module, or publish it to your internal Maven repo.

## 🚀 Usage
```java
DriverAdapter driver = new SeleniumAdapter(); // or new AppiumAdapter(...)
driver.click("id=loginBtn");
driver.sendInput("xpath=//input[@name='username']", "testuser")
