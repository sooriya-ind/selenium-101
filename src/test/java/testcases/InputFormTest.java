package testcases;

import org.testng.annotations.Test;

import pages.*;

public class InputFormTest extends Base {

    @Test
    public void inputFormTest() {

        // Set driver
        setDriver("Chrome","Test Scenario 3 : Input Form Test");

        // Go to home page
        HomePage homepage = new HomePage(getDriver());
        homepage.goToHomePage();

        // Select input forms link
        homepage.goToInputFormDemoPage();

        // Validate input form
        InputFormDemoPage inputFormDemoPage = new InputFormDemoPage(getDriver());
        inputFormDemoPage.validateMandatoryErrorMessage();
        inputFormDemoPage.validateForms();

    }

}
