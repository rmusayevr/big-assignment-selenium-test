package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-notifications");

            // Check if running in CI
            String isCI = System.getenv("CI");
            if ("true".equalsIgnoreCase(isCI)) {
                // Use local ChromeDriver in GitHub Actions
                driver = new ChromeDriver(options);
            } else {
                // Use RemoteWebDriver for Docker
                try {
                    driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
                } catch (MalformedURLException e) {
                    throw new RuntimeException("Failed to connect to Selenium hub", e);
                }
            }

            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
