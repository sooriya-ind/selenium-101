package testcases;

import org.testng.annotations.Test;

import pages.*;

public class SimpleFormTest extends Base {

    @Test
    public void simpleFormTest() {

        // Set driver
        setDriver("Chrome","Test Scenario 1 : Simple Form Demo");

        // Go to home page
        HomePage homepage = new HomePage(getDriver());
        homepage.goToHomePage();

        // Select input form link
        homepage.goToSimpleFormDemoPage();

        // Validate simple form
        SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage(getDriver());
        simpleFormDemoPage.validateSimpleForm();

    }

}
