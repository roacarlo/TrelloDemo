package singleton;
//import ru.stqa.selenium.factory.ThreadLocalSingleWebDriverPool;
import org.openqa.selenium.WebDriver;
public class DriverSingleton {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
}
