package tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductTests {

    private WebDriver driver;
    private ProductPage productPage;
    private LoginTests loginTests=new LoginTests();
    private LoginPage loginPage;


   // private LoginTests loginTests;

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
        productPage = new ProductPage(driver);

    }

    @Test (priority = 1)
    public void testProductsAreDisplayed() {
        assertTrue(productPage.getProducts().size() == 6);
    }

    @Test (priority = 2)
    public void testProductSorting() {
        productPage.selectSortOption("Price (low to high)");

    }

    @Test
    public void testAddProductToCart() {
        // Add the first product
        productPage.addProductToCart(0);
        assertEquals("Products",productPage.assertOnProductPage());

    }
}
