package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ContactPage;
import pages.DriverFactory;

import static org.junit.Assert.assertEquals;

public class ContactTests {
    private WebDriver driver;
    private ContactPage contactPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        contactPage = new ContactPage(driver);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Test()
    public void testFillAndSubmitContactForm() {
        contactPage.fillContactFormAndSubmit("Rashad Musayev", "Hello, I'm Rashad Musayev.");
        assertEquals("Thanks for contacting us", contactPage.getSuccessMessage());
    }

}