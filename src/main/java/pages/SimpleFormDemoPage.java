package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.BaseUtils;

public class SimpleFormDemoPage extends BaseUtils {
    
    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Please enter your Message']")
    WebElement txtPleaseEnterYourMsg;

    @FindBy(id = "showInput")
    WebElement btnGetCheckedValue;

    @FindBy(css = "#message")
    WebElement lblEnteredMsg;

    public SimpleFormDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void validateSimpleForm() {

        String msg = "Welcome to LambdaTest";

        // Wait untill fields get displayed
        waitToBeVisible(driver, txtPleaseEnterYourMsg);

        // Validate url contains “simple-form-demo”.
        assert driver.getCurrentUrl().contains("simple-form-demo") == true;

        // Enter input message
        txtPleaseEnterYourMsg.sendKeys(msg);

        // Click get checked value button
        btnGetCheckedValue.click();

        // Validate entered text is shown
        Assert.assertEquals(lblEnteredMsg.getText(), msg);

    }

}
