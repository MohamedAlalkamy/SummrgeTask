package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    private By cartItems = By.className("cart_item");
    private By removeButtons = By.className("btn_secondary");
    private By cartBadge = By.className("shopping_cart_badge");
    private By continueShopping=By.id("continue-shopping");
    private By cartPageText=By.xpath("/html/body/div/div/div/div[1]/div[2]/span");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public void removeProduct(int index) {
        List<WebElement> buttons = driver.findElements(removeButtons);
        buttons.get(index).click();
    }

    public String getCartBadgeCount() {
        WebElement badge = driver.findElement(cartBadge);
        return badge.getText();
    }

    public void clickCartButton() {
        driver.findElement(cartBadge).click();
    }

    public void clickContinueShoppingBtn() {
        driver.findElement(continueShopping).click();
    }

    public String assertOnCartPage() {
        WebElement text= driver.findElement(cartPageText);
        return text.getText();
    }

}
