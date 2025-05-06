package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.RandomContactPage;
import pages.DriverFactory;

import static org.junit.Assert.assertEquals;

public class RandomContactTests {
    private WebDriver driver;
    private RandomContactPage contactPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        contactPage = new RandomContactPage(driver);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Test()
    public void testFillAndSubmitContactForm() {
        contactPage.fillContactFormAndSubmit("Rashad Musayev", "Test message from Rashad.");
        assertEquals("Thanks for contacting us", contactPage.getSuccessMessage());
    }

    @Test()
    public void testInvalidContactFormSubmission() {
        contactPage.submitEmptyContactForm();
        assertEquals("Please, fill in the following fields:", contactPage.getErrorMessage());
    }

    @Test()
    public void testFillAndSubmitContactFormWithRandomData() {
        contactPage.fillContactFormWithRandomDataAndSubmit();
        assertEquals("Thanks for contacting us", contactPage.getSuccessMessage());
    }
}