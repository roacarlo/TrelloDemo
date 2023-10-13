package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListPage {
    private WebDriver driver;

    ///////////////////List
    private final By nameBoardCreate = By.xpath("//*[@data-testid='board-name-display']");
    private final By linkAddList = By.xpath("//*[@id=\"board\"]//*[@class=\"placeholder\"]");
    private final By nameListField = By.xpath("//*[@id=\"board\"]//*[@class = \"list-name-input\"]");
    private final By buttonAddList = By.xpath("//*[@id=\"board\"]//*[@class = \"nch-button nch-button--primary mod-list-add-button js-save-edit\"]");
    private final By nameListCreate = By.xpath("//*[@id=\"board\"]//*[@class=\"list-header-name mod-list-name js-list-name-input\"]");

    public ListPage(WebDriver driver){
        this.driver = driver;
    }
    // List
    public ListPage clickAddList(){
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(nameBoardCreate)).getText();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(linkAddList)).click();
        return new ListPage(driver);
    }

    public void setNameList(String listname){
        //String nameList="ListDemo";
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(nameListField)).click();
        driver.findElement(nameListField).sendKeys(listname);
    }
    public ListPage clickCreateList(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonAddList)).click();
        driver.findElement(buttonAddList).click();
        return new ListPage(driver);
    }

    public String getNameList(){
        return driver.findElement(nameListCreate).getText();
    }
}
