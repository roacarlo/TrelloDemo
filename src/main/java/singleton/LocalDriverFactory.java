package singleton;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import singleton.LocalDriverFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.EventReporter;

public class LocalDriverFactory {

    //private static EventFiringWebDriver driver;
    public static WebDriver createInstance(String browserName) {

        WebDriver driver = null;
        /*if (browserName.toLowerCase().contains("firefox")) {
            driver = new FirefoxDriver();
            return driver;
        }

        if (browserName.toLowerCase().contains("internet")) {
            driver = new InternetExplorerDriver();
            return driver;
        }*/

        if (browserName.toLowerCase().contains("chrome")) {
            //System.setProperty("webdriver.chrome.driver","C:\\Users\\s.gainewar\\Documents\\Custom Office Templates\\chromedriver_win32\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
            driver = new ChromeDriver();

            Dimension newDimension = new Dimension(1920, 1080);
            driver.manage().window().setSize(newDimension);
            driver.get("https://trello.com/");

            return driver;
        }
        return driver;
    }

    //Configurar el navegador, por defecto Headless=false --> abre navegador
    private static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setHeadless(false);
        return options;
    }
}
