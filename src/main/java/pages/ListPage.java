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

    private final By board = By.xpath("//*[@id=\"board\"]");
    private final By nameListField = By.xpath("//*[@id=\"board\"]/div/button");
    private final By nameListFieldInput = By.xpath("//*[@id=\"board\"]/div[1]/form/textarea");

    private final By buttonAddList = By.xpath("//*[@id=\"board\"]//*[@class='bxgKMAm3lq5BpA SdamsUKjxSBwGb SEj5vUdI3VvxDc']");
    private final By nameListCreate = By.xpath("//*[@id=\"board\"]//*[@class='KLvU2mDGTQrsWG']");

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
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(board)).click();
        driver.findElement(nameListField).click();
        driver.findElement(nameListFieldInput).sendKeys(listname);
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
