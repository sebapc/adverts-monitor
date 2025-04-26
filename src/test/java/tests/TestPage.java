package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.FreeStuffPage;
import pages.ItemPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPage extends BaseTest {

    @Test
    public void testFreeStuffMusicInstrumentsCategory() {
        HomePage homePage = new HomePage(driver);
        FreeStuffPage freeStuffPage = new FreeStuffPage(driver);

        homePage.goToFreeStuffCategory();
        freeStuffPage.goToMusicInstrumentsSubCategory();

        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("music-instruments"), "Not in Music Instruments category!");
    }

    @Test
    public void testNewItemLessThanOneHour() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        FreeStuffPage freeStuffPage = new FreeStuffPage(driver);
        ItemPage itemPage = new ItemPage(driver);

        homePage.goToFreeStuffCategory();
        freeStuffPage.goToMusicInstrumentsSubCategory();

        boolean newItemFound = false;
        int tries = 0;

        while (!newItemFound && tries < 20) { // Check for 20 times max (about 100 minutes)
            driver.navigate().refresh();
            Thread.sleep(5 * 60 * 1000); // Sleep 5 minutes
            newItemFound = itemPage.isNewItemAvailable();
            tries++;
        }

        assertTrue(newItemFound, "No new item found within time limit!");
    }

    @Test
    public void testRequestItemAndVerifyComment() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        FreeStuffPage freeStuffPage = new FreeStuffPage(driver);
        ItemPage itemPage = new ItemPage(driver);

        homePage.goToFreeStuffCategory();
        freeStuffPage.goToMusicInstrumentsSubCategory();

        boolean newItemFound = false;
        int tries = 0;

        while (!newItemFound && tries < 20) {
            driver.navigate().refresh();
            Thread.sleep(5 * 60 * 1000);
            newItemFound = itemPage.isNewItemAvailable();
            tries++;
        }

        assertTrue(newItemFound, "No new item found to request!");

        itemPage.selectNewestItem();
        itemPage.requestItem();

        Thread.sleep(3000); // Wait a bit for comment to post
        assertTrue(itemPage.isRequestConfirmed(), "Request not confirmed by comment!");
    }
}
