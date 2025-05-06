package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InteractionsPage extends BasePage {
    private By textInputLocator = By.xpath("//input[@name='et_pb_contact_name_0']");
    private By checkboxLocator = By.xpath("//input[@type='checkbox']");
    private By radioButtonLocator = By.xpath("//input[@type='radio']");

    public InteractionsPage(WebDriver driver) {
        super(driver);
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation");
    }

    public void fillTextInput(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement textInput = wait.until(ExpectedConditions.visibilityOfElementLocated(textInputLocator));
        if (isElementPresent(textInput)) {
            sendKeysToElement(textInput, text);
        } else {
            throw new RuntimeException("Text input not found");
        }
    }

    public void selectCheckbox() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxLocator));
        if (isElementPresent(checkbox) && !checkbox.isSelected()) {
            clickElement(checkbox);
        }
    }

    public boolean isCheckboxSelected() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxLocator));
        return isElementPresent(checkbox) && checkbox.isSelected();
    }

    public void selectRadioButton() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(radioButtonLocator));
        try {
            clickElement(radioButton);
        } catch (Exception e) {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);
        }
        wait.until(ExpectedConditions.elementToBeSelected(radioButtonLocator));
    }
    
    public boolean isRadioButtonSelected() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement radioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(radioButtonLocator));
        boolean isSelected = isElementPresent(radioButton) && radioButton.isSelected();
        return isSelected;
    }
}