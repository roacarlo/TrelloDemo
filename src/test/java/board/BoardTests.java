package board;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BoardPage;
import singleton.DriverSingleton;

import static org.testng.Assert.assertEquals;
public class BoardTests{
    protected WebDriver driver;
    BoardPage boardPage;
    @Test (dependsOnMethods = {"login.LoginTests.testLogin"})
    @Parameters("titleBoard")
    public void testCreateBoard(String title) {
        driver = DriverSingleton.getDriver();
        boardPage = new BoardPage(driver);

        boardPage.linkAddBoard();
        boardPage.setTitleBoard(title);
        boardPage.clicCreateButtonBoard();
        assertEquals(boardPage.getTittleBoardNew(),title);
    }
}
