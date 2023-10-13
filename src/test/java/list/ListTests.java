package list;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ListPage;
import singleton.DriverSingleton;

import static org.testng.Assert.*;
public class ListTests {

    protected WebDriver driver;
    ListPage listPage;
    @Test (dependsOnMethods = {"board.BoardTests.testCreateBoard"})
    @Parameters("nameList")
    public void testCreateList(String listname) {
        driver = DriverSingleton.getDriver();
        listPage = new ListPage(driver);

        //listPage.clickAddList();
        listPage.setNameList(listname);
        listPage.clickCreateList();
        assertEquals(listPage.getNameList(),listname);
    }
}
