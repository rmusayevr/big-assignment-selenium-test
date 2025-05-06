package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.DropdownPage;
import pages.DriverFactory;

import static org.junit.Assert.assertEquals;

public class DropdownTests {
    private WebDriver driver;
    private DropdownPage dropdownPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        dropdownPage = new DropdownPage(driver);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Test()
    public void testSelectAndReadDropdown() {
        dropdownPage.selectDropdownOption("Volvo"); // Update based on actual option
        assertEquals("Volvo", dropdownPage.getSelectedDropdownOption());
    }
}