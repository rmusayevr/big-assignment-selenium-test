// package tests;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.FixMethodOrder;
// import org.junit.Test;
// import org.junit.runners.MethodSorters;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

// import pages.LoginPage;
// import pages.ConfigReader;
// import pages.DriverFactory;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;

// @FixMethodOrder(MethodSorters.NAME_ASCENDING)
// public class LoginTests {
//     private WebDriver driver;
//     private LoginPage loginPage;
    
//     @Before
//     public void setUp() {
//         driver = DriverFactory.getDriver();
//         loginPage = new LoginPage(driver);
//     }

//     @After
//     public void tearDown() {
//         DriverFactory.quitDriver();
//     }

//     private void login(String email, String password) {
//         loginPage.fillLoginFormAndSubmit(email, password);
//         WebDriverWait wait = new WebDriverWait(driver, 15);
//         wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("sign_in")));
//     }

//     @Test
//     public void test1FillAndSubmitLoginForm() {
//         String email = ConfigReader.getProperty("user.email");
//         String password = ConfigReader.getProperty("user.password");
//         System.out.println("EMAIL: " + email);
//         System.out.println("PASSWORD: " + password);
//         loginPage.fillLoginFormAndSubmit(email, password);

//         WebDriverWait wait = new WebDriverWait(driver, 30);
//         try {
//             System.out.println("Waiting for URL to change...");
//             wait.until(ExpectedConditions.urlContains("courses.ultimateqa.com"));
//             System.out.println("Current URL: " + driver.getCurrentUrl());
//             assertTrue("Should be on dashboard after login",
//                 driver.getCurrentUrl().contains("courses.ultimateqa.com") &&
//                 !driver.getCurrentUrl().contains("sign_in"));
//         } catch (Exception e) {
//             System.err.println("Timeout waiting for URL change. Current URL: " + driver.getCurrentUrl());
//             System.err.println("Page source: " + driver.getPageSource());
//             throw e;
//         }
//     }

//     @Test
//     public void test2LoginWithInvalidCredentials() {
//         loginPage.fillLoginFormAndSubmit("invalid@example.com", "wrongpassword");
//         assertTrue("Should be on login page due to failure", driver.getCurrentUrl().contains("sign_in"));
//         assertEquals("Invalid email or password.", loginPage.getErrorMessage());
//     }

//     @Test
//     public void test3Logout() {
//         login(ConfigReader.getProperty("user.email"), ConfigReader.getProperty("user.password"));

//         assertTrue("Should be on dashboard before logout", driver.getCurrentUrl().contains("courses.ultimateqa.com") && !driver.getCurrentUrl().contains("sign_in"));

//         loginPage.logout();

//         WebDriverWait wait = new WebDriverWait(driver, 15);
//         wait.until(ExpectedConditions.urlContains("courses.ultimateqa.com"));

//         assertTrue("Should be redirected to login page after logout", driver.getCurrentUrl().contains("courses.ultimateqa.com"));
//     }
// }