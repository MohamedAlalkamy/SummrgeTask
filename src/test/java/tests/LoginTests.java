package tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;


public class LoginTests {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
   //     driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public  void testLoginWithValidCredentials() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        // Add assertions based on the expected outcome, e.g., checking if you are redirected to the product page.
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLoginButton();
        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.getErrorMessage());
    }
}
