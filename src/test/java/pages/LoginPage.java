package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private By emailFieldLocator = By.xpath("//input[@name='user[email]']");
    private By passwordFieldLocator = By.xpath("//input[@name='user[password]']");
    private By loginButtonLocator = By.xpath("//button[@type='submit']");
    private By errorMessageLocator = By.xpath("//*[contains(@class, 'form-error__list-item')]");
    private By userMenuLocator = By.xpath("//*[contains(@class, 'header__user-avatar')]");
    private By logoutLinkLocator = By.xpath("//a[contains(text(), 'Sign Out')]");


    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://courses.ultimateqa.com/users/sign_in");
    }

    public void fillLoginFormAndSubmit(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
        sendKeysToElement(emailField, email);
        sendKeysToElement(passwordField, password);
        clickElement(loginButton);
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return isElementPresent(errorMessage) ? getElementText(errorMessage) : "";
    }

    public LoginPage logout() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        System.out.println("Attempting to click user menu...");
        WebElement userMenu = wait.until(ExpectedConditions.elementToBeClickable(userMenuLocator));
        clickElement(userMenu);
    
        System.out.println("Attempting to click logout link...");
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(logoutLinkLocator));
        clickElement(logoutLink);
        System.out.println("Logged out successfully.");
    
        return this;
    }
}