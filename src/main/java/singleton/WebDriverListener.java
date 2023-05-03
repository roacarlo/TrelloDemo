package singleton;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

//import com.tests.test.assignment.LocalDriverFactory;
//import com.tests.test.assignment.DriverSingleton;
public class WebDriverListener implements IInvokedMethodListener {

    /*public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

        if (method.isTestMethod()) {
            // get the browser name from testng.xml
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");

            // Crear la instancia Chrome
            WebDriver driver = LocalDriverFactory.createInstance(browserName);

            // set the singleton instance
            DriverSingleton.setWebDriver(driver);
        }
    }*/
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = DriverSingleton.getDriver();
            if (driver == null) {
                String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
                driver = LocalDriverFactory.createInstance(browserName);
                DriverSingleton.setWebDriver(driver);
            }
        }
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = DriverSingleton.getDriver();
            if (driver != null) {
                //driver.quit();
            }
        }
    }
}