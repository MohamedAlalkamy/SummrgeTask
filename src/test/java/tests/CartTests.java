package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import pages.CartPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

import static org.testng.Assert.assertEquals;

public class CartTests {

    private WebDriver driver;
    private CartPage cartPage;
    private ProductPage productPage;
    private LoginPage loginPage;
    @BeforeClass
    public void setUp() {
       // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        // Perform login and add items to the cart here
        loginPage = new LoginPage(driver);
        productPage=new ProductPage(driver);
        cartPage = new CartPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        productPage.addProductToCart(0);
        cartPage.clickCartButton();


    }

    @Test
    public void testAddToCart() {
        // Assuming an item is added to the cart
        assertEquals("1", cartPage.getCartBadgeCount());
    }

    @Test
    public void testRemoveFromCart() {
        // Assuming an item is added and then removed

        assertEquals("1", cartPage.getCartBadgeCount());
        cartPage.removeProduct(0);
        assertEquals("Your Cart",cartPage.assertOnCartPage());
        cartPage.clickContinueShoppingBtn();
    }


}
