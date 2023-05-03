package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.Dimension;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;
import singleton.WebDriverListener;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.EventReporter;
import org.testng.IInvokedMethod;

public class BaseTests {

    //protected EventFiringWebDriver driver;
    WebDriver driver;
    //protected LoginPage loginPage;

    //@BeforeSuite
    public void setUp(){
      /* System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());*/

        /*driver =  WebDriverListener.beforeInvocation(IInvokedMethod method, ITestResult testResult);
        Dimension newDimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(newDimension);*/

        //driver.get("https://trello.com/");
        //loginPage = new LoginPage(driver);
    }

    /*@AfterSuite
    public void CloseNavegator(){
        driver.quit();
    }*/

    //Configurar el navegador, por defecto Headless=false --> abre navegador
    /*private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setHeadless(false);
        return options;
    }*/
    @AfterMethod  //Toma el Screenshot cuando falla un Test
    public void takeScreenshot(ITestResult result){

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                //Files.move(screenshot, new File("./Bugs/screenshots/" + result.getName() + ".png"));
                Files.move(screenshot, new File("./Bugs/screenshots/" + result.getName() + "_" + df.format(date) + ".png"));

            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}