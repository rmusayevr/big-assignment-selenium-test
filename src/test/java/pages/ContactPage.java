package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage {
    private By nameFieldLocator = By.xpath("//input[@name='et_pb_contact_name_0']");
    private By messageFieldLocator = By.xpath("//textarea[@name='et_pb_contact_message_0']");
    private By submitButtonLocator = By.xpath("//button[@name='et_builder_submit_button']");
    private By successMessageLocator = By.xpath("//*[contains(@class, 'et-pb-contact-message')]");

    public ContactPage(WebDriver driver) {
        super(driver);
        driver.get("https://ultimateqa.com/filling-out-forms");
    }

    public void fillContactFormAndSubmit(String name, String message) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(nameFieldLocator));
        WebElement messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(messageFieldLocator));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        sendKeysToElement(nameField, name);
        sendKeysToElement(messageField, message);
        clickElement(submitButton);
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
        return isElementPresent(successMessage) ? getElementText(successMessage) : "";
    }

    public String readMessageFieldContent() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(messageFieldLocator));
        return isElementPresent(messageField) ? messageField.getAttribute("value") : "";
    }
}