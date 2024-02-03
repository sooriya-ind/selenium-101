package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseUtils;

public class HomePage extends BaseUtils{
    
    WebDriver driver;

    @FindBy(xpath = "//a[text()='Simple Form Demo']")
    WebElement lnkSimpleFormDemo;

    @FindBy(xpath = "//a[text()='Drag & Drop Sliders']")
    WebElement lnkDragAndDropSliders;

    @FindBy(xpath = "//a[text()='Input Form Submit']")
    WebElement lnkInputForm;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToHomePage() {
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");
    }

    public void goToSimpleFormDemoPage() {
        waitToBeClickable(driver, lnkSimpleFormDemo);
        lnkSimpleFormDemo.click();
    }

    public void goToSliderDemoPage() {
        waitToBeClickable(driver, lnkDragAndDropSliders);
        lnkDragAndDropSliders.click();
    }

    public void goToInputFormDemoPage() {
        waitToBeClickable(driver, lnkInputForm);
        lnkInputForm.click();
    }

}
