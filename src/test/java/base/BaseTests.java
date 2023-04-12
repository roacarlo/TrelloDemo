package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import utils.EventReporter;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    protected LoginPage loginPage;
    private EventFiringWebDriver driver;//investigar EventFiringWebDriver

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        driver.get("https://trello.com/");
        driver.manage().window().maximize() ;
        loginPage = new LoginPage(driver);
 }
    @AfterClass
    public void CloseNavegator(){
        driver.quit();
    }

    //Configurar el navegador, por defecto Headless=false --> abre navegador
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setHeadless(false);
        return options;
    }
    @AfterMethod  //Toma el Screenshot cuando falla un Test
    public void takeScreenshot(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("./Bugs/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}