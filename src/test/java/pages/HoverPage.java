package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HoverPage extends BasePage {
    private By blogLinkLocator = By.xpath("//div[contains(@class, 'et_pb_menu_0_tb_footer')]//ul[@id='menu-footer-main-menu']//a[@href='https://ultimateqa.com/blog/']"); // Blog link in main footer menu

    public HoverPage(WebDriver driver) {
        super(driver);
        System.out.println("Navigating to automation page...");
        driver.get("https://ultimateqa.com/automation");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }

    public boolean hoverOverBlogLink() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement blogLink = wait.until(ExpectedConditions.visibilityOfElementLocated(blogLinkLocator));

        // Get the initial opacity value
        String initialOpacity = blogLink.getCssValue("opacity");
        System.out.println("Initial opacity: " + initialOpacity);

        // Perform hover action
        Actions actions = new Actions(driver);
        actions.moveToElement(blogLink).build().perform();
        System.out.println("Hovered over Blog link.");

        // Wait for the hover effect to apply
        try {
            Thread.sleep(1000); // Small delay to ensure hover effect applies
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Get the opacity value after hover
        String hoverOpacity = blogLink.getCssValue("opacity");
        System.out.println("Opacity after hover: " + hoverOpacity);

        // Verify the hover effect (opacity should change to 0.7)
        return hoverOpacity.equals("0.7");
    }
}