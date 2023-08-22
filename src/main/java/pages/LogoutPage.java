package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
    private WebDriver driver;


    private final By buttonPerfil = By.xpath("//*[@class = \"DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez\"]");
    private final By clicLogOut = By.xpath("//*[@data-testid= \"account-menu-logout\"]");
    private final By clicLogOut2 = By.xpath("//*[@class= \"css-178ag6o\"]");
    private final By buttonLogin = By.xpath("//*[@id=\"BXP-APP\"]//*//*[@class= \"Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr\"]");


    public LogoutPage(WebDriver driver){
        this.driver = driver;
    }

    public LogoutPage clicButtonPerfil(){
        //driver.findElement(clicPerfil).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(buttonPerfil)).click();

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(clicLogOut)).click();
        return new LogoutPage(driver);
    }
    public String getButtonLogin(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(clicLogOut2)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonLogin)).getText();

        return driver.findElement(buttonLogin).getText();
    }
    public LogoutPage clicCloseNavegator(){
        driver.quit();
        return new LogoutPage(driver);
    }
}
