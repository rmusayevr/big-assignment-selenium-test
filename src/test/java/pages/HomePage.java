package pages;

import org.openqa.selenium.*;

public class HomePage extends BasePage {
    private By automationExercisesLinkLocator = By.xpath("//a[contains(text(), 'Automation Exercises')]");

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get("https://ultimateqa.com/automation/");
    }

    public AutomationPage navigateToAutomationExercises() {
        WebElement link = driver.findElement(automationExercisesLinkLocator);
        clickElement(link);
        return new AutomationPage(driver);
    }
}