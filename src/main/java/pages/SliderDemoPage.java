package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.BaseUtils;

public class SliderDemoPage extends BaseUtils {
    
    WebDriver driver;

    @FindBy(xpath = "//input[@value='15']")
    WebElement btnSlider;

    @FindBy(id = "rangeSuccess")
    WebElement lblSliderValue;

    public SliderDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void validateSlider(int expectedValue) {

        // Wait untill slider is visible
        waitToBeVisible(driver, btnSlider);

        // Slide the slider to expected value
        int i = 1;
        while (Integer.parseInt(lblSliderValue.getText().strip()) < expectedValue) {
            new Actions(driver).clickAndHold(btnSlider).moveByOffset(i, 0).perform();
            i++;
        }

        // Validate slider is moved to expected value
        Assert.assertEquals(Integer.parseInt(lblSliderValue.getText()),expectedValue);

    }

}
