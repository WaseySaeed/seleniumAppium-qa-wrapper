# 🔧 SeleniumAppium QA Wrapper Library

A lightweight, reusable Java library for UI automation that abstracts common interactions like click, sendInput, getText, and waitForVisible.
Supports Selenium and Appium, and works with any framework by accepting external driver instances — so you stay in control.
---

## 🚀 Features

- ✅ Easy-to-use `DriverAdapter` interface
- ✅ Built-in retry logic for flaky elements
- ✅ Smart locator parsing (`id=`, `xpath=`, `accessibilityId=`, etc.)
- ✅ Compatible with Selenium and Appium(Android)
- ✅ Requires no changes to your driver or framework
- ✅ Logging support via Log4j
- ✅ Zero version conflicts (`provided` dependencies)

---

## 🛠 How to Use

### 1. Add Dependency (via JitPack)

In your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
<dependency>
    <groupId>com.github.WaseySaeed</groupId>
    <artifactId>seleniumAppium-qa-wrapper</artifactId>
    <version>TAG_VERSION</version> <!-- Example: 1.0.8 current version 1.0.10 -->
</dependency>
</dependencies>
```

---

### 2. Plug Into Your Framework

```java
WebDriver driver = new ChromeDriver(); // Or any driver from your own DriverFactory
DriverAdapter wrapper = new SeleniumAdapter(driver);

wrapper.click("id=loginButton");
wrapper.type("id=email", "admin@example.com");
wrapper.getElementText("xpath=//h1");
```

Or for Appium:

```java
AppiumDriver appium = new AndroidDriver(...);
DriverAdapter wrapper = new AppiumAdapter(appium);

wrapper.click("accessibilityId=login_button");
```

---

### 3. 🔍 Supported Locator Formats

| Prefix               | Description                  | Example                          |
|----------------------|------------------------------|----------------------------------|
| `id=`                | HTML ID                      | `id=loginBtn`                    |
| `name=`              | HTML name attribute          | `name=username`                  |
| `xpath=`             | Full XPath expression        | `xpath=//button[@type='submit']` |
| `css=`               | CSS selector                 | `css=.btn.primary`               |
| `class=`             | Class name                   | `class=input-field`              |
| `tag=`               | HTML tag                     | `tag=button`                     |
| `linkText=`          | Exact link text              | `linkText=Forgot Password`       |
| `partialLinkText=`   | Partial link text            | `partialLinkText=Forgot`         |
| `accessibilityId=`   | Appium (mobile)              | `accessibilityId=login_button`   |
| `androidUIAutomator=`| Appium (Android only)        | `androidUIAutomator=new UiSelector().text("Login")` |

---

### 4. 📦 Available Methods

#### 🔹 Core Actions

```java
click(String locator);
type(String locator, String text);
clearFieldWithBackspace(String locator);
quit();
```

#### 🔹 Waits & Validations

```java
isElementDisplayed(String locator);
waitForVisible(String locator);
getElementText(String locator);
getElementAttribute(String locator, String attribute);
```

---

### 5. 📁 Project Structure

```
com.universalqa
├── core               // DriverAdapter interface
├── selenium           // SeleniumAdapter implementation
├── appium             // AppiumAdapter implementation
├── utils              // LocatorStrategy, RetryUtil, TestDataUtil, LoggerUtil
```

---

### 6. 🧪 Example Test

```java
DriverAdapter driver = new SeleniumAdapter(DriverFactory.getDriver("chrome"));

driver.click("id=email");
driver.type("id=email", "test@example.com");
driver.type("id=password", "password123");
driver.click("id=loginBtn");
```

### 7. 🙌 Why Use SeleniumAppium QA Wrapper?
1. 🚀 Boost your automation speed
2. ⚡ Remove boilerplate code
3. 🎯 Use in any framework instantly
4. 🔥 Battle-tested with retries and locator flexibility


### 🚀 Ready to simplify your automation?
⭐ Star the repo!
👨‍💻 Contributions welcome!

# Contributing to SeleniumAppium-qa-wrapper

First off, thank you for taking the time to contribute! 🎉 This document lays out the steps and guidelines for reporting issues, suggesting features, and submitting pull requests.

---
## Contributing

### Getting Started
1. Fork the repository
2. Set up the development environment by following the instructions in README.md
3. Create a new branch for your feature or bug fix
4. Make your changes following the code standards
5. Write or update tests as necessary
6. Update documentation as needed
7. Submit a pull request

### Communication
- Ask questions if you're unsure about something
- Discuss significant changes before investing a lot of time

## Issue Management

### Creating Issues
- Search existing issues before creating a new one
- Use issue templates when available
- Provide detailed information to reproduce bugs
- Include environment details (OS, version, etc.)
- Label issues appropriately

### Issue Tracking
- Issues will be triaged by maintainers
- Priorities will be assigned based on impact and alignment with project goals
- Feel free to volunteer to work on open issues

## Pull Requests

### PR Guidelines
- Create one PR per feature or bug fix
- Reference related issues in the PR description
- Include tests for new functionality
- Update documentation as needed
- Follow the PR template

### PR Process
1. Submit PR from your fork to the main repository
2. Maintainers will review your code
3. Address review feedback
4. Once approved, a maintainer will merge your changes

## Code Review

### Review Process
- All code changes require at least one review from a maintainer
- Reviews focus on:
   - Code quality and correctness
   - Documentation
   - Adherence to project standards
