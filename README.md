# LamdaTest Assessment for Selenium-101 Certification
This project is built using **Selenium with java**.
It follows **Page Object Model** & **TestNG** approach.

## Prerequisites

Ensure that your system has the following software installed:

- Java (version 11)
- Maven - (version 3.x)

## Add Dependencies in (POM.xml)

Add the following dependencies to your `pom.xml` file:

        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.17.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.8.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.github.javafaker/javafaker -->
        <dependency>
            <groupId>com.github.javafaker</groupId>
            <artifactId>javafaker</artifactId>
            <version>1.0.2</version>
        </dependency>

## Test Cases Covered

- `SimpleFormTest.java` - Validate url & displayed entered text
- `SliderDemoTest.java` -  Validate slider to **95**
- `InputFormTest.java` -  Validate ui fields & error message

## Project Structure

The project follows standard Maven directory structure:

- `src/main/java/pages`: Homepage, InputFormDemoPage, SimpleFormDemoPage, SliderDemoPage
- `src/main/java/utils`: BaseUtils
- `src/test/java/testcases`: Base, InputFormTest, SimpleFormTest, SliderDemoTest
- `./`: .gitignore, .gitpod.yml, README.md, TestNG.xml, pom.xml

## Running the Test Suite

- Test can also able to execute by using **gitpod.yml**
- Can be able to execute tests by **pom.xml** file using **mvn clean test** command
- Run the `TestNG.xml` file, Test will execute in both sequential & parallel manner
- Three tests will execute, 2 consist of Parallel & 1 in sequential manner