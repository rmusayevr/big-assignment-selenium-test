package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import pages.DriverFactory;

import static org.junit.Assert.assertTrue;

public class JavascriptTests {
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
    public void testScrollAndClickWithJavascript() {
        driver.get("https://ultimateqa.com/automation");
        System.out.println("Navigated to automation page.");

        // Find an element at the bottom of the page (e.g., footer link)
        WebElement contactLink = driver.findElement(By.xpath("//a[@href='https://ultimateqa.com/contact/']"));

        // Scroll to the element using JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", contactLink);
        System.out.println("Scrolled to contact link.");

        // Click the element using JavascriptExecutor
        js.executeScript("arguments[0].click();", contactLink);
        System.out.println("Clicked contact link with Javascript.");

        // Verify navigation
        assertTrue("Should navigate to contact page", driver.getCurrentUrl().equals("https://ultimateqa.com/contact/"));
    }
}