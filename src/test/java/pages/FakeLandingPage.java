package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FakeLandingPage extends BasePage {
    private By headerLocator = By.xpath("//h1[contains(text(),'Learn to Code Websites, Apps & Games')]");

    public FakeLandingPage(WebDriver driver) {
        super(driver);
        driver.get("https://ultimateqa.com/fake-landing-page");
    }

    public String getHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
        return getElementText(header);
    }

    public By getHeaderLocator() {
        return headerLocator;
    }
}