package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By freeStuffCategory = By.xpath("//a[contains(text(),'Free Stuff')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToFreeStuffCategory() {
        driver.findElement(freeStuffCategory).click();
    }
}
