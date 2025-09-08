# Test Automation Framework

This is a **Java-based Test Automation Framework** .  
It is designed with **scalability, readability, and ease of execution** in mind, and supports  
data-driven testing, cross-browser execution, cloud integration, and detailed reporting.


## 🚀 About Me
Hi, I am Srinivas Kini K, I have 18+ years of experience in Automation Testing using technologies using technologies like Selenium, Applium, Rest Assured. 
My major expertise is in Java programming language. 


## Author
- [@srinivaskinik](https://github.com/srinivaskinik)
- srinivaskinik@gmail.com





## Tech Stack

**Programming Language:** Java 11



## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/srinivaskinik)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/srinivaskinik/)



## Prerequisites
Before running the tests, make sure you have the following installed:

- **Java 11**  
- **Maven 3.6+**  
- IDE of your choice (IntelliJ / Eclipse / VS Code)

If running on LambdaTest, ensure you have your **LambdaTest credentials** configured.  
You can set them as environment variables:

```bash
export LT_USERNAME="your-username"
export LT_ACCESS_KEY="your-access-key"

or in Windows PowerShell:

$env:LT_USERNAME="your-username"
$env:LT_ACCESS_KEY="your-access-key"
```

## Features

- **Java 11** based automation framework
- **TestNG** for test execution and parallel runs
- **Data-driven testing** with:
  - `OpenCSV` (CSV support)
  - `Gson` (JSON support)
  - `Apache POI` (Excel support)
- **Faker library** for generating fake test data
- **LambdaTest integration** for cloud-based cross-browser execution
- **Headless mode** support for faster execution
- **Maven Surefire Plugin** for CLI test execution
- **Extent Reports** for rich HTML reports
- **Log4j** for detailed execution logs
- Configurable test runs with parameters:
  - `browser` (e.g., chrome, firefox, edge)
  - `isLambdatest` (true/false)
  - `isHeadless` (true/false)


  ## Technology Used
  - Language: Java 11

  - Test Runner: TestNG

  - UI Automation: Selenium WebDriver 4.x

  - Data: OpenCSV, Gson, Apache POI

  - Test Data Gen: Java Faker

  - Reporting: ExtentReports

  - Logging: Log4j

  - Build/CLI: Maven + Surefire Plugin

  - Cloud Grid: LambdaTest





## Installation

**Clone the repository**

```bash
  https://github.com/srinivaskinik/Test-Automation-Framework.git

  cd Test-Automation-Framework
```
**Running Tests on LambdaTest**    

```bash
  mvn test -D browser=chrome -DisLambdaTest=true -DisHeadless=false -X
```

**Running Tests on Chrome browser on local machine in headlenss mode**    

```bash
  mvn test -D browser=chrome -DisLambdaTest=false -DisHeadless=true -X
```

## Reports & Logs

Extent HTML Report: generated at project root as ./report.html after each run.

## Log4j Logs: 
written under ./logs/ with timestamped files per run.

## Integrated the project with GitHub Actions
This automation framework is integrated with Github Actions.
The tests will be executed  at 11:30 PM IST every single day.

The reports will be archived in gh-pages branch. 
You can view the html reports at:
 https://srinivaskinik.github.io/Test-Automation-Framework/report.html
