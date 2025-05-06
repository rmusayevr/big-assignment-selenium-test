package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.FakeLandingPage;
import pages.AutomationPage;
import pages.DriverFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MultiPageTests {
    private WebDriver driver;

    private static class PageConfig {
        String url;
        String expectedTitle;

        PageConfig(String url, String expectedTitle) {
            this.url = url;
            this.expectedTitle = expectedTitle;
        }
    }

    private static final PageConfig[] PAGES = {
            new PageConfig("https://ultimateqa.com/automation", "Automation Practice - Ultimate QA"),
            new PageConfig("https://ultimateqa.com/fake-landing-page", "Fake landing page - Ultimate QA")
    };

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Test()
    public void testStaticPageContent() {
        FakeLandingPage fakeLandingPage = new FakeLandingPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        for (int i = 0; i < 3; i++) {
            try {
                WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(fakeLandingPage.getHeaderLocator()));
                String headerText = header.getText();
                assertEquals("Learn to Code Websites, Apps & Games", headerText);
                return;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("Stale element detected, retrying (" + (i + 1) + "/3)...");
            }
        }
        throw new RuntimeException("Failed to get header text after retries");
    }

    @Test()
    public void testMultiplePagesFromArray() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        for (PageConfig page : PAGES) {
            System.out.println("Testing page: " + page.url);
            driver.get(page.url);
            wait.until(ExpectedConditions.titleContains("Ultimate QA"));
            String actualTitle = driver.getTitle();
            assertEquals("Title mismatch for " + page.url, page.expectedTitle, actualTitle);
        }
    }

    @Test()
    public void testComplexXPathNavigation() {
        AutomationPage automationPage = new AutomationPage(driver);
        automationPage.clickContactLinkUsingComplexXPath();
        assertTrue("Should navigate to Contact page after clicking link", automationPage.isOnContactPage());
    }
}