package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.github.javafaker.Faker;

import utils.BaseUtils;

public class InputFormDemoPage extends BaseUtils {

    WebDriver driver;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement btnSubmit;

    @FindBy(id = "name")
    WebElement txtName;

    @FindBy(id = "inputEmail4")
    WebElement txtEmail;

    @FindBy(css = "#inputPassword4")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@placeholder='Company']")
    WebElement txtCompany;

    @FindBy(id = "websitename")
    WebElement txtWebsiteName;

    @FindBy(name = "country")
    WebElement ddCountry;

    @FindBy(css = "#inputCity")
    WebElement txtCity;

    @FindBy(xpath = "//input[@placeholder='Address 1']")
    WebElement txtAddress1;

    @FindBy(xpath = "//input[@placeholder='Address 2']")
    WebElement txtAddress2;

    @FindBy(id = "inputState")
    WebElement txtState;

    @FindBy(name = "zip")
    WebElement txtZipCode;

    @FindBy(xpath = "//p[text()='Thanks for contacting us, we will get back to you shortly.']")
    WebElement lblSuccessMsg;

    public InputFormDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void validateMandatoryErrorMessage() {

        // Wait untill name is visible
        waitToBeVisible(driver, txtName);

        // Click submit button
        btnSubmit.click();
        new Actions(driver).pause(Duration.ofSeconds(5)).perform();

        // Validate mandatory message is shown
        Assert.assertEquals(txtName.getAttribute("validationMessage").equalsIgnoreCase("Please fill out this field."),true);

    }

    public void validateForms() {

        // Enter name
        waitToBeClickable(driver, txtName);
        txtName.sendKeys(Faker.instance().name().fullName());

        // Enter email
        txtEmail.sendKeys(Faker.instance().internet().emailAddress());

        // Enter password
        txtPassword.sendKeys(Faker.instance().internet().password());

        // Enter company name
        txtCompany.sendKeys(Faker.instance().company().name());

        // Enter website
        txtWebsiteName.sendKeys(Faker.instance().internet().url());

        // Select country
        Select select = new Select(ddCountry);
        select.selectByVisibleText("United States");

        // Enter city
        txtCity.sendKeys(Faker.instance().address().city());

        // Enter address 1
        txtAddress1.sendKeys(Faker.instance().address().streetAddress());

        // Enter address 2
        txtAddress2.sendKeys(Faker.instance().address().fullAddress());

        // Enter state
        txtState.sendKeys(Faker.instance().address().state());

        // Enter zip code
        txtZipCode.sendKeys(Faker.instance().address().zipCode());

        // Click submit button
        btnSubmit.click();

        // Wait untill success message
        waitToBeVisible(driver, lblSuccessMsg);

    }
    
}
