# 🔧 Universal QA Automation Wrapper Library

A lightweight, reusable Java library for UI automation that abstracts common interactions like `click`, `type`, `getText`, and `waitForVisible`.  
Supports **Selenium** and **Appium**, and works with **any framework** by accepting external driver instances — so you stay in control.

---

## 🚀 Features

- ✅ Easy-to-use `DriverAdapter` interface
- ✅ Built-in retry logic for flaky elements
- ✅ Smart locator parsing (`id=`, `xpath=`, `accessibilityId=`, etc.)
- ✅ Compatible with Selenium and Appium
- ✅ Requires no changes to your driver or framework
- ✅ Logging support via Log4j
- ✅ Zero version conflicts (`provided` dependencies)

---

## 🛠 How to Use

### 1. Add Dependency (GitHub Packages)

In your `pom.xml`:

```xml
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/WaseySaeed/universal-qa-wrapper</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.universalqa</groupId>
    <artifactId>universal-qa-wrapper</artifactId>
    <version>1.0.4</version>
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
