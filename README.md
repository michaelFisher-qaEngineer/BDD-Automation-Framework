# Hybrid to BDD Test Automation Framework

A Selenium automation framework migrated from a classic **hybrid approach** to a **BDD (Behavior-Driven Development)** architecture using **Cucumber with Gherkin syntax**.

This project demonstrates how an existing hybrid Selenium test suite can be refactored into a BDD-oriented framework — improving readability, collaboration, and reporting.

---

## 🚀 What This Repo Includes

✔️ Reuse of existing hybrid automation core:  
- `testBase.BaseClass` for driver handling  
- Page object implementations in `pageObjects.*`

✔️ BDD Conversion  
- Gherkin **.feature** files (6 high-level scenarios)  
- Cucumber **Step Definitions** tied to the feature steps  
- **Hooks** (Before/After) integrated with your BaseClass  

✔️ Execution  
- Cucumber + TestNG based runner  
- Flexible parameterization for different environments

✔️ Reporting  
- Cucumber HTML report: `target/cucumber-report.html`
- ExtentReports (Spark) via the Cucumber 7 Adapter: `target/ExtentReport/ExtentSpark.html

---

## 📦 Project Structure

├── src
│ ├── main
│ │ └── java
│ │ └── (stepdefs, hooks, etc.)
│ └── test
│ └── resources
│ ├── features
│ ├── config.properties
├── testng.xml
├── pom.xml
└── README.md


---

## 🛠 Prerequisites

Before running tests, ensure you have:

- **Java JDK 11+**
- **Maven**  
- A browser driver (ChromeDriver, GeckoDriver, etc.) referenced in your PATH

> Update configuration in  
> `src/test/resources/config.properties` — especially `execution_env`, `appURL`, and any credentials.
## Notes
- `config.properties` uses:
  - `execution_env=local`
  - `appURL=https://cloudberrystore.services/`
---

## ▶️ How to Run

From the project root:

```sh
mvn test -Dos=windows -Dbrowser=chrome