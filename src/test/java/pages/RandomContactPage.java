package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.UUID;

public class RandomContactPage extends BasePage {
    private By nameFieldLocator = By.xpath("//input[@name='et_pb_contact_name_0']");
    private By messageFieldLocator = By.xpath("//textarea[@name='et_pb_contact_message_0']");
    private By submitButtonLocator = By.xpath("//button[@name='et_builder_submit_button']");
    private By successMessageLocator = By.xpath("//*[contains(@class, 'et-pb-contact-message')]");
    private By errorMessageLocator = By.xpath("//*[contains(@class, 'et-pb-contact-message')]//p");

    public RandomContactPage(WebDriver driver) {
        super(driver);
        System.out.println("Navigating to contact page...");
        driver.get("https://ultimateqa.com/filling-out-forms");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }

    public void fillContactFormWithRandomDataAndSubmit() {
        String randomName = "User-" + UUID.randomUUID().toString().substring(0, 8);
        String randomMessage = "Message-" + UUID.randomUUID().toString().substring(0, 8);

        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(nameFieldLocator));
        WebElement messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(messageFieldLocator));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));

        sendKeysToElement(nameField, randomName);
        sendKeysToElement(messageField, randomMessage);
        clickElement(submitButton);
        System.out
                .println("Contact form submitted with random data: Name=" + randomName + ", Message=" + randomMessage);
    }

    public void fillContactFormAndSubmit(String name, String message) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(nameFieldLocator));
        WebElement messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(messageFieldLocator));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));

        sendKeysToElement(nameField, name);
        sendKeysToElement(messageField, message);
        clickElement(submitButton);
        System.out.println("Contact form submitted.");
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
        return getElementText(successMessage);
    }

    public void submitEmptyContactForm() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        clickElement(submitButton);
        System.out.println("Empty contact form submitted.");
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return getElementText(errorMessage);
    }
}