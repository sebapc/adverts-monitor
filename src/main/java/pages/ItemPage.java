package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemPage {
    private WebDriver driver;

    private By itemsList = By.cssSelector(".card-title a");
    private By postAgeLabel = By.cssSelector(".card-subtitle");
    private By messageBox = By.id("message");
    private By sendRequestButton = By.xpath("//button[contains(text(),'Send')]");
    private By commentSection = By.cssSelector(".reply-body");

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNewItemAvailable() {
        List<WebElement> ages = driver.findElements(postAgeLabel);
        for (WebElement age : ages) {
            String text = age.getText().toLowerCase();
            if (text.contains("seconds") || text.contains("minute") || text.contains("hour")) {
                return true;
            }
        }
        return false;
    }

    public void selectNewestItem() {
        List<WebElement> items = driver.findElements(itemsList);
        if (!items.isEmpty()) {
            items.get(0).click();
        }
    }

    public void requestItem() {
        WebElement message = driver.findElement(messageBox);
        message.clear();
        message.sendKeys("Hi, I would love to have this item if still available. Thanks!");

        driver.findElement(sendRequestButton).click();
    }

    public boolean isRequestConfirmed() {
        List<WebElement> comments = driver.findElements(commentSection);
        return !comments.isEmpty();
    }
}
