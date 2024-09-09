package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage{

    private By productList = By.className("inventory_item");
    private By sortDropdown = By.className("product_sort_container");
    private By addToCartButtons = By.className("btn_inventory");
    private By productpageText= By.xpath("/html/body/div/div/div/div[1]/div[2]/span");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProducts() {
        return driver.findElements(productList);
    }

    public void selectSortOption(String option) {
        WebElement dropdown = driver.findElement(sortDropdown);
        dropdown.sendKeys(option);
    }

    public void addProductToCart(int index) {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        buttons.get(index).click();
    }

    public String assertOnProductPage() {
        WebElement text= driver.findElement(productpageText);
        return text.getText();
    }
}
