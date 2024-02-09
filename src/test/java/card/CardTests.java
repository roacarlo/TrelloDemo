package card;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CardPage;
import singleton.DriverSingleton;

import static org.testng.Assert.assertEquals;

public class CardTests {

    protected WebDriver driver;
    CardPage cardPage;
    @Test (dependsOnMethods = {"list.ListTests.testCreateList"})
    @Parameters("nameCard")
    public void testCreateCard(String titleCard) {
        driver = DriverSingleton.getDriver();
        cardPage = new CardPage(driver);

        cardPage.clickAddCard();
        cardPage.setNameCard(titleCard);

        cardPage.clickCreateCard();
        assertEquals(cardPage.getNameCardCreate(),titleCard);
    }
}
