package login;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.*;

import singleton.DriverSingleton;
import singleton.WebDriverListener;
public class LoginTests {

    //protected EventFiringWebDriver driver;
    protected WebDriver driver;
    LoginPage loginPage;

    @Test //(priority = 1)
    @Parameters({"username","password"})
    public void testLogin(String username, String password){
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);

        loginPage.clickStartLogin();
        loginPage.setUsername(username);
        loginPage.clicContinueButton();
        loginPage.setPassword(password);
        loginPage.clicLoginButton();
        //assertEquals(loginPage.getTitleHomeTrello(),"TUS ESPACIOS DE TRABAJO");
        loginPage.clicPerfil();
        assertEquals(loginPage.getEmailUser(),username);
    }

   /* @Test  //(priority = 2)//(dependsOnMethods = "testLogin")
    @Parameters("titleBoard")
    public void testCreateBoard(String title){// Crear el board
        boardPage = loginPage.btnCreateBoard();
        boardPage.setTitleBoard(title);

        boardPage.clickCreateButtonBoard();
        assertEquals(boardPage.getTittleBoardNew(),"BoardDemo2023");
    }*/
   /* @Test //(priority = 3)//(dependsOnMethods = "testCreateBoard")
    @Parameters("nameListNew")
    public void testCreateList(String nameList){//Crear Listado
        boardPage = boardPage.clickAddList();
        boardPage.setNameList(nameList);
        boardPage.clickCreateList();
        assertEquals(boardPage.getNameList(),"ListDemo");
    }*/

    /*@Test //(priority = 4)//(dependsOnMethods = "testCreateList")
    @Parameters("nameCardNew")
    public void testCreateCard(String nameCard){//Crear tareas
        boardPage = boardPage.clickAddCard();
        //String nameCard= "Card";
        boardPage.setNameCard(nameCard);
        boardPage.clickCreateCard();
        assertEquals(boardPage.getNameCardCreate(),"CardDemo1");
    }*/

    /*@Test //(dependsOnMethods = "testCreateCard")
    public void LogOut(){//Cerrar Sesión
        boardPage.LogOut();
        assertEquals(boardPage.getButtonLogin(),"Log in");
    }*/
}
