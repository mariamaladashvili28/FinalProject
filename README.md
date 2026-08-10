# MyAuto.ge Test Automation Project

Automated UI testing project for the **MyAuto.ge** website, developed using **Java, Selenium WebDriver, TestNG, Maven, Page Object Model (POM), WebDriverManager, and Extent Reports**.

The project automates key user flows such as login, product search, rental options, advanced vehicle filtering, and language switching.

---

## Project Overview

The purpose of this project is to demonstrate a maintainable Selenium-based test automation framework using the **Page Object Model** design pattern.

The framework separates:

* Page elements and page actions
* Test cases
* WebDriver management
* Configuration
* Common page functionality
* Test reporting
* Test execution configuration

The tests are executed against the MyAuto.ge website.

**Base URL:**

`https://myauto.ge/ka`

---

## Technologies & Tools

| Technology / Tool         | Purpose                         |
| ------------------------- | ------------------------------- |
| Java 21                   | Programming language            |
| Selenium WebDriver 4.46.0 | Browser automation              |
| TestNG 7.12.0             | Test framework                  |
| Maven                     | Dependency and build management |
| WebDriverManager 6.3.4    | ChromeDriver management         |
| Extent Reports 5.1.2      | HTML test reporting             |
| Rest Assured 6.0.1        | API testing dependency          |
| IntelliJ IDEA             | Development environment         |
| Chrome                    | Automated browser               |
| Page Object Model         | Test automation design pattern  |
| Git / GitHub              | Version control                 |

The Maven configuration defines Java 21 as the source and target version and includes Selenium, TestNG, WebDriverManager, Extent Reports, and Rest Assured dependencies.

---

## Project Structure

```text
FinalProject/
│
├── .idea/
│
├── report/
│   └── ExtentReport.html
│
├── src/
│   │
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── example/
│   │               │
│   │               ├── BasePage.java
│   │               │
│   │               ├── pages/
│   │               │   ├── LoginPage.java
│   │               │   ├── SearchPage.java
│   │               │   └── WelcomePage.java
│   │               │
│   │               └── utils/
│   │                   ├── ConfigReader.java
│   │                   ├── DriverManager.java
│   │                   ├── ExtentReportManager.java
│   │                   ├── TestListener.java
│   │                   └── Utils.java
│   │
│   └── test/
│       └── java/
│           └── org/
│               └── example/
│                   │
│                   ├── BaseTest.java
│                   │
│                   └── test/
│                       ├── LoginTest.java
│                       ├── SearchTest.java
│                       └── WelcomeTest.java
│
├── .gitignore
├── config.properties
├── pom.xml
└── TestNG.xml
```

The repository currently contains separate `main` and `test` source trees, with Page Objects and utilities under `src/main` and test classes under `src/test`.

---

# Framework Architecture

## Page Object Model

The project follows the **Page Object Model (POM)** pattern.

Each page has its own Page Object class containing:

* WebElements
* Locators
* Page-specific actions
* Reusable methods

The Page Objects extend `BasePage`, which provides common Selenium functionality such as:

* WebDriver reference
* WebDriverWait
* PageFactory initialization
* Click helper
* Current URL retrieval

`BasePage` creates a `WebDriverWait` using the configured wait time from `config.properties`.

---

## BasePage

`BasePage.java` is the parent class for all Page Objects.

It provides:

```text
WebDriver
WebDriverWait
PageFactory initialization
waitForElementToBeClikalble()
click()
getCurrentUrl()
```

The common `click()` method waits until an element becomes clickable before performing the click action.

---

# Page Objects

## LoginPage

`LoginPage.java` represents the login page.

It contains elements for:

* Email / username input
* Password input
* Login button
* User icon

Available actions include:

```text
enterEmail()
enterPassword()
clickLoginButton()
checkUserIcon()
login()
```

The login test verifies navigation to the authentication page and then validates successful login by checking the user icon.

---

## WelcomePage

`WelcomePage.java` represents the main MyAuto.ge page.

It contains functionality for:

* Accepting cookies
* Opening the login page
* Searching for a product
* Opening the rental section
* Selecting daily rental
* Checking whether daily rental is selected

Available methods include:

```text
clickAcceptCookies()
clickLoginButton()
searchProduct()
clickRentButton()
clickRentDaily()
isDailyRentSelected()
```

The product search uses the main search field and submits the entered search term with `ENTER`.

---

## SearchPage

`SearchPage.java` represents the advanced search functionality.

It contains elements and actions for:

* Manufacturer selection
* Toyota selection
* Model selection
* Exact model selection
* Choose button
* Secondary cookie notification
* Search button
* Language menu
* English language selection

Available methods include:

```text
clickManufacturerButton()
selectManufacturer()
selectModel()
selectExactModel()
clickChooseButton()
clickSecodCookie()
clickSearchButton()
clickLanguageButtonGeorgian()
selectEnglishLanguage()
```

The current vehicle filter test selects **Toyota → Camry** and validates the resulting URL.

---

# Test Cases

## 1. Login Test

**Class:** `LoginTest`

**Test:** `loginValid`

The test:

1. Opens MyAuto.ge
2. Accepts cookies
3. Clicks the login button
4. Verifies that the URL contains the authentication page
5. Enters the email
6. Enters the password
7. Clicks Login
8. Verifies that the user icon is displayed

The test receives `email` and `password` through TestNG parameters defined in `TestNG.xml`.

---

## 2. Product Search Test

**Class:** `WelcomeTest`

**Test:** `searchProduchByName`

The test:

1. Opens MyAuto.ge
2. Accepts cookies
3. Searches for:

```text
Volkswagen
```

4. Verifies that the resulting URL contains `Volkswagen`.

---

## 3. Daily Rental Test

**Class:** `WelcomeTest`

**Test:** `searchWithRent`

The test:

1. Opens MyAuto.ge
2. Accepts cookies
3. Opens the rental section
4. Selects daily rental
5. Verifies that the daily rental checkbox is selected

---

## 4. Vehicle Filter Search Test

**Class:** `SearchTest`

**Test:** `searchWithFilters`

The test:

1. Opens MyAuto.ge
2. Accepts cookies
3. Opens the manufacturer filter
4. Selects Toyota
5. Opens the model filter
6. Selects Camry
7. Selects the exact Camry model
8. Handles the secondary cookie notification
9. Clicks Search
10. Verifies that the resulting URL contains `Camry`

---

## 5. Language Change Test

**Class:** `SearchTest`

**Test:** `changeLanguageTest`

The test:

1. Opens MyAuto.ge
2. Accepts cookies
3. Opens the Georgian language menu
4. Selects English
5. Verifies that the URL contains `/en`

---

# TestNG Configuration

The project uses `TestNG.xml` as the main TestNG suite configuration.

The suite contains three test sections:

```text
Login Page
Welcome Page
Search Page
```

The Login test receives:

```text
email
password
```

through TestNG parameters.

The suite also registers:

```text
org.example.utils.TestListener
```

for Extent Reports integration.

### TestNG Suite Structure

```text
MYAUTO.FINALE.PROJECT
│
├── Login Page
│   └── LoginTest
│
├── Welcome Page
│   └── WelcomeTest
│
└── Search Page
    └── SearchTest
```

---

# Configuration

The project uses a `config.properties` file for environment-specific settings.

Current configuration:

```properties
base.url=https://myauto.ge/ka
wait=10
```

The `base.url` property defines the application under test, while `wait` defines the default explicit wait duration used by `BasePage`.

---

# Driver Management

`DriverManager.java` is responsible for WebDriver lifecycle management.

It provides:

```text
getDriver()
quiDriver()
```

### Driver creation

If a driver does not already exist, WebDriverManager configures ChromeDriver and creates a new `ChromeDriver` instance.

### Driver cleanup

After each test method, `BaseTest` calls the driver cleanup method and closes the browser using:

```java
driver.quit();
```

The driver reference is then reset to `null`.

---

# BaseTest

All test classes extend `BaseTest`.

`BaseTest` contains the common test lifecycle:

### Before each test

```text
Get WebDriver
Maximize browser
Open configured base URL
```

### After each test

```text
Quit WebDriver
```

This avoids duplicating browser setup and cleanup code in individual test classes.

---

# Configuration Reader

`ConfigReader.java` is responsible for reading values from:

```text
config.properties
```

This allows configuration such as the base URL and explicit wait time to be maintained outside the Java source code.

---

# Extent Reports

The project integrates **Extent Reports** for HTML test reporting.

`ExtentReportManager.java` is responsible for:

* Initializing `ExtentReports`
* Creating `ExtentSparkReporter`
* Creating individual test entries
* Maintaining the current `ExtentTest`
* Flushing the report

The report is generated at:

```text
report/ExtentReport.html
```

The report includes:

```text
Automation Test Report
Test Execution Report
Environment: QA
Tester: Your Name
```

`ThreadLocal<ExtentTest>` is used to support test-specific report instances and future parallel execution scenarios.

---

# TestNG Listener

`TestListener.java` implements:

```java
ITestListener
```

It integrates TestNG execution with Extent Reports.

The listener handles:

```text
onTestStart()
onTestSuccess()
onTestFailure()
onTestSkipped()
onFinish()
```

### Test start

Creates a new Extent test and logs that execution has started.

### Test success

Marks the test as passed.

### Test failure

Marks the test as failed and records the thrown exception.

### Test skipped

Marks the test as skipped.

### Test finish

Flushes the Extent Report.

The listener is registered in `TestNG.xml`.

---

# Logging Utilities

`Utils.java` provides utility functionality used by the framework, including logging support used by the common page interaction methods.

---

# Maven Configuration

The project uses Maven for dependency management and test execution.

The main dependencies are:

```text
WebDriverManager 6.3.4
Selenium Java 4.46.0
TestNG 7.12.0
Extent Reports 5.1.2
Rest Assured 6.0.1
```

Java version:

```text
Java 21
```

The project also configures the Maven Surefire Plugin to execute the TestNG suite.

---

# How to Run

## Prerequisites

Make sure the following are installed:

* Java 21
* Maven
* Google Chrome
* IntelliJ IDEA or another Java IDE
* Git

---

## Clone the Repository

```bash
git clone https://github.com/mariamaladashvili28/FinalProject.git
```

Then navigate into the project:

```bash
cd FinalProject
```

---

## Install Dependencies

Maven will automatically download the required dependencies.

Run:

```bash
mvn clean install
```

---

## Run Automated Tests

To execute the configured TestNG suite through Maven:

```bash
mvn clean test
```

The Maven Surefire configuration is set up to execute the TestNG suite defined in the project configuration.

---

## Run from IntelliJ IDEA

You can also run the suite directly from IntelliJ IDEA.

Recommended approach:

1. Open the project in IntelliJ IDEA.
2. Locate `TestNG.xml`.
3. Right-click the file.
4. Select **Run**.
5. TestNG will execute the configured test classes.

Running individual methods directly may bypass parameters configured in `TestNG.xml`, such as the Login test's `email` and `password` parameters.

---

# Test Execution Flow

The general execution flow is:

```text
TestNG Suite
     │
     ▼
BaseTest @BeforeMethod
     │
     ▼
Create ChromeDriver
     │
     ▼
Open MyAuto.ge
     │
     ▼
Test Class
     │
     ├── LoginTest
     ├── WelcomeTest
     └── SearchTest
     │
     ▼
Page Object Methods
     │
     ▼
Assertions
     │
     ▼
TestNG Listener
     │
     ▼
Extent Reports
     │
     ▼
BaseTest @AfterMethod
     │
     ▼
driver.quit()
```

---

# Design Principles

The framework demonstrates several automation best practices:

### Page Object Model

Page-specific locators and actions are separated from test logic.

### Reusable Base Classes

Common functionality is centralized in:

```text
BasePage
BaseTest
```

### Explicit Waits

The framework uses `WebDriverWait` and Selenium `ExpectedConditions` instead of relying only on hard-coded sleeps.

### Centralized Configuration

Application URL and wait duration are stored in:

```text
config.properties
```

### Driver Management

Browser creation and cleanup are centralized in:

```text
DriverManager
```

### Test Reporting

Test execution results are automatically integrated with:

```text
Extent Reports
TestNG Listener
```

---

# Reporting

After test execution, the Extent HTML report is generated under:

```text
report/
└── ExtentReport.html
```

The report contains test execution information such as:

* Test name
* Start status
* Pass status
* Failure information
* Skipped tests
* Environment information

---

# Current Automated Coverage

The current project automates the following main scenarios:

| Area           | Scenario                         | Status    |
| -------------- | -------------------------------- | --------- |
| Login          | Valid user login                 | Automated |
| Search         | Search product by name           | Automated |
| Rental         | Select daily rental              | Automated |
| Vehicle Search | Filter by manufacturer and model | Automated |
| Language       | Change Georgian → English        | Automated |

The five scenarios correspond to the current `LoginTest`, `WelcomeTest`, and `SearchTest` classes in the repository.

---

# Security Note

The current `TestNG.xml` contains login credentials as plain-text parameters.

For a real-world project, credentials should **not** be committed to a public repository.

Recommended alternatives include:

* Environment variables
* Local untracked configuration files
* CI/CD secret variables
* Secret management tools

For example:

```text
EMAIL=<your-email>
PASSWORD=<your-password>
```

and load these values at runtime instead of storing them directly in the repository.

---

# Future Improvements

Possible improvements for the framework include:

* Move credentials from `TestNG.xml` to environment variables
* Add negative login scenarios
* Add invalid search scenarios
* Add more vehicle filter combinations
* Add cross-browser execution
* Add screenshots on test failure
* Add richer Extent Report logging
* Add API tests using Rest Assured
* Add parallel test execution
* Add CI/CD integration
* Add GitHub Actions workflow
* Improve locator stability
* Add reusable handling for optional cookie banners
* Add more assertions for search results
* Add test groups such as `smoke` and `regression`

---

# Author

**Mariam Aladashvili**

GitHub:
https://github.com/mariamaladashvili28

---

# Repository

The complete source code is available here:

https://github.com/mariamaladashvili28/FinalProject
