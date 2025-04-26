package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FreeStuffPage {
    private WebDriver driver;

    private By musicInstrumentsSubCategory = By.xpath("//a[contains(text(),'Music Instruments & Equipment')]");

    public FreeStuffPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToMusicInstrumentsSubCategory() {
        driver.findElement(musicInstrumentsSubCategory).click();
    }
}
