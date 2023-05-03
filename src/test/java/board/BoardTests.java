package board;

import base.BaseTests;
import login.LoginTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.LoginPage;
import singleton.DriverSingleton;

import static org.testng.Assert.*;
public class BoardTests{
    protected WebDriver driver;
    BoardPage boardPage;
    @Test  //(priority = 2)//(dependsOnMethods = "testLogin")
    @Parameters("titleBoard")
    public void testCreateBoard(String title) {
        driver = DriverSingleton.getDriver();
        boardPage = new BoardPage(driver);

        boardPage.clicClosePerfil();
        boardPage.btnCreateBoard();
        boardPage.setTitleBoard(title);
        boardPage.clickCreateButtonBoard();
        assertEquals(boardPage.getTittleBoardNew(),"BoardDemo2023");
    }
}
