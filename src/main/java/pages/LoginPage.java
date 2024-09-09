package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//h3[@data-test='error']");
    private By DropDown= By.id("react-burger-menu-btn");
    private By logout=By.id("logout_sidebar_link");
    private By LoginAsserttext=By.xpath("/html/body/div/div/div[2]/div[2]/div/div[1]/h4");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        WebElement error = driver.findElement(errorMessage);
        return error.getText();
    }

    public void clickDropDown() {
        driver.findElement(DropDown).click();
    }
    public void clicklogout() {
        driver.findElement(logout).click();
    }

    public String assertOnLoginPage() {
        WebElement text= driver.findElement(LoginAsserttext);
        return text.getText();
    }


}
