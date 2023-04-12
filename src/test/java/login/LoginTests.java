package login;

import base.BaseTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.LoginPage;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {
    protected BoardPage boardPage;
    @Test (priority = 1)
    @Parameters({"username","password"})
    public void testLogin(String username, String password){//Iniciar sesión
        loginPage.clickStartLogin();
        loginPage.setUsername(username);
        loginPage.clicContinueButton();

        loginPage.setPassword(password);
        loginPage.clicLoginButton();
        assertEquals(loginPage.getTitleTrello(),"TUS ESPACIOS DE TRABAJO");
    }

    @Test  (priority = 2)//(dependsOnMethods = "testLogin")
    @Parameters("titleBoard")
    public void testCreateBoard(String title){// Crear el board
        boardPage = loginPage.btnCreateBoard();
        boardPage.setTitleBoard(title);

        boardPage.clickCreateButton();
        assertEquals(boardPage.getTittleBoardNew(),"BoardDemo2023");
    }
    @Test (priority = 3)//(dependsOnMethods = "testCreateBoard")
    @Parameters("nameListNew")
    public void testCreateList(String nameList){//Crear Listado
        boardPage = boardPage.clickAddList();
        boardPage.setNameList(nameList);
        boardPage.clickCreateList();
        assertEquals(boardPage.getNameList(),"ListDemo");
    }

    @Test (priority = 4)//(dependsOnMethods = "testCreateList")
    @Parameters("nameCardNew")
    public void testCreateCard(String nameCard){//Crear tareas
        boardPage = boardPage.clickAddCard();
        //String nameCard= "Card";
        boardPage.setNameCard(nameCard);
        boardPage.clickCreateCard();
        assertEquals(boardPage.getNameList(),"ListDemo");
    }

    @Test (dependsOnMethods = "testCreateCard")
    public void LogOut(){//Cerrar Sesión
        boardPage.LogOut();
        assertEquals(boardPage.getButtonLogin(),"Log in");
    }
}
