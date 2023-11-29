# Automation Project with Java, Cucumber, Selenium, Gradle, and Serenity
This project is designed to automate tests on the "SauceDemo" web application. It uses Java as the programming language, Cucumber as the testing framework, Selenium for browser interaction, and Serenity under the Screenplay pattern to improve code readability and maintenance.

## Prerequisites
Make sure to have the following components installed before running the tests:

- Java SDK
- Gradle
- WebDriver (e.g., ChromeDriver)

## Project Setup
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/your-project.git
   cd your-project

## Install Dependencies:
gradle clean build

## Data Configuration
Test data, such as users and products, is stored in Excel files. Ensure you have the data.xlsx file in the src/test/resources folder.

1. **Running the Tests:**
   ```bash
   gradle clean test

## Project Structure
src/main/java: Contains Java classes for the project source code.
src/test/java: Contains Java classes for tests.
src/test/resources: Contains data files, such as data.xlsx.

## Screenplay Pattern
The project follows the Screenplay design pattern to enhance code modularity and maintenance. Actions, tasks, and questions are organized clearly for each interaction with the application.

## Execution Reports
Execution reports generated by Serenity can be found in the build/reports/serenity folder. 

## Authors 
Lucas Castaño Jaramillo
