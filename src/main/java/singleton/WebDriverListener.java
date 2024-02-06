package singleton;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebDriverListener implements IInvokedMethodListener {

    WebDriver driver;

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

        if (method.isTestMethod()) {
            driver = DriverSingleton.getDriver();
            if (driver == null) {
                String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");

                String aux = method.getTestMethod().getXmlTest().getLocalParameters().get("modeHeadless");
                Boolean modeHeadless = Boolean.parseBoolean(aux);

                driver = LocalDriverFactory.createInstance(browserName,modeHeadless);
                DriverSingleton.setWebDriver(driver);
            }

        }
    }
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        //takeScreenshot(testResult);
        /*if (method.isTestMethod()) {
            WebDriver driver = DriverSingleton.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }*/

    }

    public void takeScreenshot(ITestResult result){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("./Bugs/screenshots/" + result.getName() + "_" + df.format(date) + ".png"));

            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
