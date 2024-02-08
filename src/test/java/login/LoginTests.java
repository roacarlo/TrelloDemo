package login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import singleton.DriverSingleton;

import static org.testng.Assert.assertEquals;

public class LoginTests {

    //protected EventFiringWebDriver driver;
    protected WebDriver driver;
    LoginPage loginPage;

    @Test
    @Parameters({"username","password"})
    public void testLogin(String username, String password){
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);

        loginPage.clickStartLogin();
        loginPage.setUsername(username);
        loginPage.clicContinueButton();
        loginPage.setPassword(password);
        loginPage.clicLoginButton();
        assertEquals(loginPage.getTitleHomeTrello(),"TUS ESPACIOS DE TRABAJO");
        //assertEquals(loginPage.getTitleHomeTrello(),"YOUR WORKSPACES");

        loginPage.clicPerfil();
        assertEquals(loginPage.getEmailUser(),username);
    }
}
