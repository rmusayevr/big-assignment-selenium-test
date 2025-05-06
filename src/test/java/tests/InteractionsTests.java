package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.InteractionsPage;
import pages.DriverFactory;

import static org.junit.Assert.assertTrue;

public class InteractionsTests {
    private WebDriver driver;
    private InteractionsPage interactionsPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        interactionsPage = new InteractionsPage(driver);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Test()
    public void testFillTextAndCheckbox() {
        interactionsPage.fillTextInput("Test User");
        interactionsPage.selectCheckbox();
        assertTrue(interactionsPage.isCheckboxSelected());
    }

    @Test()
    public void testSelectRadioButton() {
        interactionsPage.selectRadioButton();
        assertTrue(interactionsPage.isRadioButtonSelected());
    }
}