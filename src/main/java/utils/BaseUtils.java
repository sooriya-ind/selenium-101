package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class BaseUtils {
    

    public void waitToBeClickable(WebDriver driver, WebElement element) {

        // Wait for the Element to be Clickable
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMinutes(5))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }

    public void waitToBeVisible(WebDriver driver, WebElement element) {

        // Wait for the Element to be Visible
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMinutes(5))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }

}
