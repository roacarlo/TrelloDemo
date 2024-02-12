package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardPage {
    private WebDriver driver;

    private final By linkAddBoard = By.xpath("//*[@class=\"board-tile mod-add\"]");
    private final By txtTitleBoardField = By.xpath("//*[@class = \"nch-textfield__input lsOhPsHuxEMYEb lsOhPsHuxEMYEb VkPAAkbpkKnPst\"]");
    private final By buttonCreateBoard = By.xpath("//*[@class=\"hY6kPzdkHFJhfG bxgKMAm3lq5BpA SdamsUKjxSBwGb SEj5vUdI3VvxDc\"]");

    private final By titleBoardNew = By.xpath("//*[@id=\"content\"]//*[@class='HKTtBLwDyErB_o']");
    private final By nameBoardCreate = By.xpath("//*[@data-testid='board-name-display']");
    //private final By titleBoardNew = By.xpath("//*[@id=\"content\"]//*[@class='HKTtBLwDyErB_o']");



    public BoardPage(WebDriver driver){
        this.driver = driver;
    }



    public BoardPage linkAddBoard(){

        new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(linkAddBoard)).click();
        return new BoardPage(driver);
    }
    public void setTitleBoard(String titleBoard){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(txtTitleBoardField)).click();
        driver.findElement(txtTitleBoardField).sendKeys(titleBoard);
    }
    public BoardPage clicCreateButtonBoard(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonCreateBoard)).click();
        return new BoardPage(driver);
    }

    public String getTittleBoardNew(){//Obtener titulo board creado
        //new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(nameBoardCreate)).click();
        //return driver.findElement(titleBoardNew).getText();
        return new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(nameBoardCreate)).getText();
    }
}
