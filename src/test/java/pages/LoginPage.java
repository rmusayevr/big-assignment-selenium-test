// package pages;

// import org.openqa.selenium.*;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import com.google.common.base.Predicate;

// public class LoginPage extends BasePage {
//     private By emailFieldLocator = By.cssSelector("input[name='user[email]']");
//     private By passwordFieldLocator = By.cssSelector("input[name='user[password]']");
//     private By loginButtonLocator = By.xpath("//button[@type='submit']");
//     private By errorMessageLocator = By.xpath("//*[contains(@class, 'form-error__list-item')]");
//     private By userMenuLocator = By.xpath("//*[contains(@class, 'header__user-avatar')]");
//     private By logoutLinkLocator = By.xpath("//a[contains(text(), 'Sign Out')]");

//     public LoginPage(WebDriver driver) {
//         super(driver);
//         System.out.println("Navigating to login page...");
//         try {
//             driver.get("https://courses.ultimateqa.com/users/sign_in");
//         } catch (TimeoutException e) {
//             System.err.println("Page load timed out.");
//             e.printStackTrace();
//             throw e;
//         } catch (Exception e) {
//             System.err.println("Unexpected error during page load.");
//             e.printStackTrace();
//             throw e;
//         }
//         new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(emailFieldLocator));
//         System.out.println("Login page loaded.");
//         System.out.println("Login page loaded.");
//     }

//     public void fillLoginFormAndSubmit(String email, String password) {
//         WebDriverWait wait = new WebDriverWait(driver, 30);
//         try {
//             System.out.println("Waiting for email field...");
//             WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
//             System.out.println("Email field found. Entering email: " + email);
//             sendKeysToElement(emailField, email);

//             System.out.println("Waiting for password field...");
//             WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
//             System.out.println("Password field found. Entering password: " + password);
//             sendKeysToElement(passwordField, password);

//             System.out.println("Waiting for login button...");
//             WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
//             System.out.println("Login button found. Clicking...");
//             try {
//                 clickElement(loginButton);
//             } catch (Exception e) {
//                 System.out.println("Standard click failed, trying JavaScript click...");
//                 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
//             }

//             // Wait for URL change or error message
//             Predicate<WebDriver> waitCondition = new Predicate<WebDriver>() {
//                 @Override
//                 public boolean apply(WebDriver driver) {
//                     if (driver.getCurrentUrl().contains("courses.ultimateqa.com")) {
//                         return true;
//                     }
//                     try {
//                         WebElement errorElement = driver.findElement(errorMessageLocator);
//                         return isElementPresent(errorElement);
//                     } catch (Exception e) {
//                         return false;
//                     }
//                 }
//             };
//             wait.until(waitCondition);

//             // Check for error message after submission
//             String error = getErrorMessage();
//             if (!error.isEmpty()) {
//                 System.err.println("Login error detected: " + error);
//             }
//         } catch (Exception e) {
//             System.err.println("Error in fillLoginFormAndSubmit: " + e.getMessage());
//             System.err.println("Page source: " + driver.getPageSource());
//             throw e;
//         }
//     }

//     public String getErrorMessage() {
//         WebDriverWait wait = new WebDriverWait(driver, 5); // Short timeout for error message
//         try {
//             WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
//             return isElementPresent(errorMessage) ? getElementText(errorMessage) : "";
//         } catch (Exception e) {
//             System.out.println("No error message found.");
//             return "";
//         }
//     }

//     public LoginPage logout() {
//         WebDriverWait wait = new WebDriverWait(driver, 30);
//         try {
//             System.out.println("Attempting to click user menu...");
//             WebElement userMenu = wait.until(ExpectedConditions.elementToBeClickable(userMenuLocator));
//             clickElement(userMenu);

//             System.out.println("Attempting to click logout link...");
//             WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(logoutLinkLocator));
//             clickElement(logoutLink);
//             System.out.println("Logged out successfully.");
//         } catch (Exception e) {
//             System.err.println("Error during logout: " + e.getMessage());
//             throw e;
//         }
//         return this;
//     }
// }