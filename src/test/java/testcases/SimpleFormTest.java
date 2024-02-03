package testcases;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import pages.*;

public class SimpleFormTest extends Base {

    @Test
    public void simpleFormTest() throws MalformedURLException{

        // Set driver
        setDriver("Chrome");

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
