package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.DriverFactory;

import static org.junit.Assert.assertTrue;

public class HistoryTests {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Test
    public void testBrowserBackButton() {
        driver.get("https://ultimateqa.com/automation");
        System.out.println("Navigated to automation page: " + driver.getCurrentUrl());

        driver.get("https://ultimateqa.com/contact/");
        System.out.println("Navigated to contact page: " + driver.getCurrentUrl());

        driver.navigate().back();
        System.out.println("Navigated back to: " + driver.getCurrentUrl());

        assertTrue("Should navigate back to automation page", driver.getCurrentUrl().contains("automation"));
    }
}