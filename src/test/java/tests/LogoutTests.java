package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;


public class LogoutTests {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
       // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        // Perform login here
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

    }

    @Test
    public void testLogout() {
        // Perform logout action
        // Verify redirection to login page
        loginPage.clickDropDown();
        loginPage.clicklogout();
        assertEquals("Accepted usernames are:",loginPage.assertOnLoginPage());

    }
}
