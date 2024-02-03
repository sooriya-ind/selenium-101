package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterMethod;

public class Base {
    
    private static final Logger log = Logger.getAnonymousLogger();
    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    protected Base() {}
    
    public static synchronized WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static synchronized void setDriver(String browser,String testName) {
        try {
            driverThreadLocal.set(ThreadGuard.protect(initializer(browser,testName)));            
        } catch (MalformedURLException e) {
            log.warning(" Error in Creating Driver --> "+ e.getMessage());
        }
    }

    private static WebDriver initializer(String browser,String testName) throws MalformedURLException {
        
        WebDriver driver;
        ChromeOptions chromeOptions;
        EdgeOptions edgeOptions;

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "soori3123");
        ltOptions.put("accessKey", "1F1WcQdc7h0sLlrct4PPvyoanaZA0HwyNckp3NSGYam1K65ZYg");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("network", true);
        ltOptions.put("build", "LamdaTest Selenium 101 Certification");
        ltOptions.put("project", "LamdaTest Playground");
        ltOptions.put("console", "true");
        ltOptions.put("w3c", true);
        ltOptions.put("selenium_version", "4.17.0");
        ltOptions.put("version", "latest");
        ltOptions.put("name", testName);

        if (browser.equalsIgnoreCase("Chrome")) {
            chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("platformName", "Windows 10");
            chromeOptions.setCapability("browserName", "Chrome");
            chromeOptions.setCapability("LT:Options", ltOptions);
            driver = (new RemoteWebDriver(new URL("https://soori3123:1F1WcQdc7h0sLlrct4PPvyoanaZA0HwyNckp3NSGYam1K65ZYg@hub.lambdatest.com/wd/hub"),chromeOptions));
        } else {
            edgeOptions = new EdgeOptions();
            edgeOptions.setCapability("platformName", "Linux");
            edgeOptions.setCapability("browserName", "Microsoft Edge");
            edgeOptions.setCapability("LT:Options", ltOptions);
            driver = (new RemoteWebDriver(new URL("https://soori3123:1F1WcQdc7h0sLlrct4PPvyoanaZA0HwyNckp3NSGYam1K65ZYg@hub.lambdatest.com/wd/hub"),edgeOptions));
        }

        return driver;
    }

    @AfterMethod
    protected synchronized void tearDown() {
        
        // Quit Driver & Remove Thread Local
        getDriver().quit();
        driverThreadLocal.remove();

    }

}
