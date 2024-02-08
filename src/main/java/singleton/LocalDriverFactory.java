package singleton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import org.openqa.selenium.support.events.EventFiringWebDriver;
//import utils.EventReporter;

public abstract class LocalDriverFactory{

    //05/02/2024 private static EventFiringWebDriver driver;
    static WebDriver driver;

    public static WebDriver createInstance(String browserName,Boolean headless) {

        //WebDriver driver = null;
        /*if (browserName.toLowerCase().contains("firefox")) {
            driver = new FirefoxDriver();
            return driver;
        }

        if (browserName.toLowerCase().contains("internet")) {
            driver = new InternetExplorerDriver();
            return driver;
        }*/

        if (browserName.toLowerCase().contains("chrome")) {
            /* 05/02/2024 System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions(headless)));
            driver.register(new EventReporter());

            Dimension newDimension = new Dimension(1950, 1200);
            driver.manage().window().setSize(newDimension);
            driver.get("https://trello.com/");*/

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--lang=es"); // Por defecto el idioma del navegador será: Español

            options.addArguments("disable-infobars");
            options.setHeadless(headless);//Configurar modo headless

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            //driver = new WebDriver(new ChromeDriver(getChromeOptions(headless)));
            Dimension newDimension = new Dimension(1950, 1200);
            driver.manage().window().setSize(newDimension);

            driver.get("https://trello.com/");

            return driver;
        }
        return driver;
    }



    //Configurar el navegador, por defecto Headless=false --> abre navegador
    /*static ChromeOptions getChromeOptions(Boolean modeHeadless){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setHeadless(modeHeadless);
        //options.setHeadless(false);
        return options;
    }*/


}
