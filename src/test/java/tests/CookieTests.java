package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.DriverFactory;

import static org.junit.Assert.assertFalse;

public class CookieTests {
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
    public void testBypassConsentPopupWithCookie() {
        driver.get("https://ultimateqa.com/automation");

        Cookie consentCookie = new Cookie("cookie_consent", "accepted", "ultimateqa.com", "/", null);
        driver.manage().addCookie(consentCookie);

        driver.navigate().refresh();

        boolean isConsentPopupPresent = driver.findElements(By.cssSelector(".cookie-consent-popup")).size() > 0;
        assertFalse("Consent popup should not be present after adding cookie", isConsentPopupPresent);
    }
}
