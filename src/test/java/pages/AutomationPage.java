package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPage extends BasePage {
    private By fakeLandingPageLinkLocator = By.xpath("//a[text()='Fake Landing Page']");
    private By simpleHtmlElementsLinkLocator = By.xpath("//a[text()='Simple HTML Elements for Automation']");
    private By contactLinkLocator = By.xpath("//div[contains(@class, 'et_pb_menu_inner_container')]//a[@href='https://ultimateqa.com/contact/']");


    public AutomationPage(WebDriver driver) {
        super(driver);
        System.out.println("Navigating to automation page...");
        driver.get("https://ultimateqa.com/automation");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }

    public FakeLandingPage navigateToFakeLandingPage() {
        WebElement fakeLandingPageLink = driver.findElement(fakeLandingPageLinkLocator);
        clickElement(fakeLandingPageLink);
        return new FakeLandingPage(driver);
    }

    public InteractionsPage navigateToSimpleHtmlElements() {
        WebElement simpleHtmlElementsLink = driver.findElement(simpleHtmlElementsLinkLocator);
        clickElement(simpleHtmlElementsLink);
        return new InteractionsPage(driver);
    }

    public void clickContactLinkUsingComplexXPath() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement contactLink = wait.until(ExpectedConditions.elementToBeClickable(contactLinkLocator));
        
        String href = contactLink.getAttribute("href");
        driver.get(href);
    }

    public boolean isOnContactPage() {
        return driver.getCurrentUrl().equals("https://ultimateqa.com/contact/");
    }

}