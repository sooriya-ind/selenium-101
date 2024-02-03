package testcases;

import org.testng.annotations.Test;

import pages.*;

public class SliderDemoTest extends Base {

    @Test
    public void sliderDemoTest() {

        // Set driver
        setDriver("Edge","Test Scenario 2 : Drag And Drop Slider");

        // Go to home page
        HomePage homepage = new HomePage(getDriver());
        homepage.goToHomePage();

        // Select drag & drop form link
        homepage.goToSliderDemoPage();

        // Validate slider demo
        SliderDemoPage sliderDemoPage = new SliderDemoPage(getDriver());
        sliderDemoPage.validateSlider(95);

    }

}
