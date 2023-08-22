package logout;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LogoutPage;
import singleton.DriverSingleton;

import static org.testng.Assert.assertEquals;

public class LogOutTests {

    protected WebDriver driver;
    LogoutPage logoutPage;
    @Test (dependsOnMethods = {"card.CardTests.testCreateCard"})
    public void testLogOut() {
        driver = DriverSingleton.getDriver();
        logoutPage = new LogoutPage(driver);

        logoutPage.clicButtonPerfil();
        assertEquals(logoutPage.getButtonLogin(),"Log in");
        logoutPage.clicCloseNavegator();
    }
}
