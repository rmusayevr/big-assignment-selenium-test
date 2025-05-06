package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropdownPage extends BasePage {
    private By carTypeDropdownLocator = By.xpath("//div[contains(@class, 'et_pb_blurb_description')]//select");

    public DropdownPage(WebDriver driver) {
        super(driver);
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation");
    }

    public void selectDropdownOption(String option) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement carTypeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(carTypeDropdownLocator));
        if (isElementPresent(carTypeDropdown)) {
            Select dropdown = new Select(carTypeDropdown);
            dropdown.selectByVisibleText(option);
        } else {
            throw new RuntimeException("Dropdown not found");
        }
    }

    public String getSelectedDropdownOption() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement carTypeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(carTypeDropdownLocator));
        if (isElementPresent(carTypeDropdown)) {
            Select dropdown = new Select(carTypeDropdown);
            return dropdown.getFirstSelectedOption().getText();
        }
        return "";
    }
}