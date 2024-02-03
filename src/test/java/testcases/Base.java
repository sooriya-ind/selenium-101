package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterTest;

public class Base {
    
    private static final Logger log = Logger.getAnonymousLogger();
    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    protected Base() {}
    
    public static synchronized WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static synchronized void setDriver(String browser) {
        try {
            driverThreadLocal.set(ThreadGuard.protect(initializer(browser)));            
        } catch (MalformedURLException e) {
            log.warning(" Error in Creating Driver --> "+ e.getMessage());
        }
    }

    private static WebDriver initializer(String browser) throws MalformedURLException {
        
        WebDriver driver;
        ChromeOptions chromeOptions;
        SafariOptions safariOptions;

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "soori3123");
        ltOptions.put("accessKey", "1F1WcQdc7h0sLlrct4PPvyoanaZA0HwyNckp3NSGYam1K65ZYg");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("network", true);
        ltOptions.put("build", "Selenium 101 Certification");
        ltOptions.put("project", "LamdaTest Playground");
        ltOptions.put("console", "true");
        ltOptions.put("selenium_version", "4.17.0");
        ltOptions.put("w3c", true);
        ltOptions.put("version", "latest");

        if (browser.equalsIgnoreCase("Chrome")) {
            chromeOptions = new ChromeOptions();
            chromeOptions.setPlatformName("Windows 10");
            ltOptions.put("browserName", "Chrome");
            chromeOptions.setCapability("LT:Options", ltOptions);
            driver = (new RemoteWebDriver(new URL("https://soori3123:1F1WcQdc7h0sLlrct4PPvyoanaZA0HwyNckp3NSGYam1K65ZYg@hub.lambdatest.com/wd/hub"),chromeOptions));
        } else {
            safariOptions = new SafariOptions();
            safariOptions.setPlatformName("Catalina");
            ltOptions.put("browserName", "Firefox");
            safariOptions.setCapability("LT:Options", ltOptions);
            driver = (new RemoteWebDriver(new URL("https://soori3123:1F1WcQdc7h0sLlrct4PPvyoanaZA0HwyNckp3NSGYam1K65ZYg@hub.lambdatest.com/wd/hub"),safariOptions));
        }

        return driver;
    }

    @AfterTest
    public void tearDown() {
        
        // Quit Driver & Remove Thread Local
        getDriver().quit();
        driverThreadLocal.remove();

    }

}
