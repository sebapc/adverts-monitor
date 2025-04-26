package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By loginHomeButton = By.xpath("//a[text()='Log In']"); // Top-right login button
    private By usernameField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[contains(text(),'Sign In')]");

    // TODO: Insert your credentials
    private String username = "XXXXXXX";
    private String password = "YYYYYYY";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButtonOnHomePage() {
        driver.findElement(loginHomeButton).click();
    }

    public void login() {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
