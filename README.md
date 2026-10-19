# Selenium Hybrid Automation Framework

A hybrid test automation framework built with **Selenium WebDriver**, **Java**, **TestNG** and **Maven**. It combines the Page Object Model with data-driven testing, TestNG suite grouping and parallel execution, so tests stay readable, reusable and easy to scale.

## Features

- Page Object Model (POM) for maintainable page classes
- Data-driven testing with external test data (`testData` folder)
- TestNG suites for full runs, grouped runs and parallel runs
- Execution logs saved in the `logs` folder
- HTML test reports saved in the `reports` folder
- Screenshots captured and saved in the `screenshots` folder
- Maven-based dependency and build management

## Tech Stack

| Area | Tool |
|------|------|
| Language | Java |
| Browser automation | Selenium WebDriver 4 |
| Test runner | TestNG |
| Build tool | Maven |
| Design pattern | Page Object Model, data-driven, hybrid |
| Version control | Git and GitHub |

## Project Structure

```
selenium-hybrid-automation-framework/
├── src/test/             # Page objects, base classes, utilities and test classes
├── testData/             # External test data files
├── logs/                 # Execution logs
├── reports/              # HTML test reports
├── screenshots/          # Screenshots captured during test runs
├── master.xml            # Master TestNG suite
├── grouping.xml          # TestNG suite for running grouped tests
├── parallel.xml          # TestNG suite for parallel execution
└── pom.xml               # Maven dependencies and build configuration
```

## Prerequisites

- JDK 11 or higher
- Maven 3.6 or higher
- Google Chrome, Mozilla Firefox or Microsoft Edge
- Git
- An IDE such as Eclipse or IntelliJ IDEA

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/DineshReddy12002/selenium-hybrid-automation-framework.git
   cd selenium-hybrid-automation-framework
   ```

2. **Install dependencies**
   ```bash
   mvn clean install -DskipTests
   ```

3. **Run the tests**
   ```bash
   mvn clean test
   ```

## Running TestNG Suites

In Eclipse or IntelliJ, right-click a suite file and choose **Run As → TestNG Suite**:

| Suite file | Purpose |
|------------|---------|
| `master.xml` | Runs the complete test suite |
| `grouping.xml` | Runs only the tests in selected groups (for example sanity or regression) |
| `parallel.xml` | Runs tests in parallel to reduce execution time |

## Reports, Logs and Screenshots

- **Reports:** open the generated HTML file inside the `reports` folder in any browser.
- **Logs:** check the `logs` folder for detailed execution logs.
- **Screenshots:** check the `screenshots` folder for captured screenshots.

## Author

**Dinesh Reddy**
QA Engineer aspiring to become an SDET
GitHub: [DineshReddy12002](https://github.com/DineshReddy12002)

## License

This project is for learning and portfolio purposes.
