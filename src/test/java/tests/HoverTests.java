// package tests;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
// import org.openqa.selenium.WebDriver;
// import pages.HoverPage;
// import pages.DriverFactory;

// import static org.junit.Assert.assertTrue;

// public class HoverTests {
//     private WebDriver driver;
//     private HoverPage hoverPage;

//     @Before
//     public void setUp() {
//         driver = DriverFactory.getDriver();
//         hoverPage = new HoverPage(driver);
//     }

//     @After
//     public void tearDown() {
//         DriverFactory.quitDriver();
//     }

//     @Test
//     public void testHoverOverBlogLink() {
//         assertTrue("Hover should change the opacity of the Blog link to 0.7", hoverPage.hoverOverBlogLink());
//     }
// }