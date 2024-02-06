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

        loginPage.clickStartLogin(); // OK
        loginPage.setUsername(username); // OK
        loginPage.clicContinueButton(); // OK
        loginPage.setPassword(password); // OK
        loginPage.clicLoginButton(); // OK
        assertEquals(loginPage.getTitleHomeTrello(),"TUS ESPACIOS DE TRABAJO"); // OK
        loginPage.clicPerfil(); // OK
        assertEquals(loginPage.getEmailUser(),username); // OK
    }
}
