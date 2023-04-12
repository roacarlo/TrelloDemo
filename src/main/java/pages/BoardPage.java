package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardPage {
    private WebDriver driver;

    ///////-----------------------------
    private final By createBoard = By.xpath("//label/input");
    private final By titleBoardField = By.xpath("//label/input");
    private final By buttonCreate = By.xpath("//*[@class=\"ijFumaLuInvBrL bxgKMAm3lq5BpA SdamsUKjxSBwGb SEj5vUdI3VvxDc\"]");
    private final By boardNew = By.id("board");
    private final By titleBoardNew = By.xpath("//*[@id=\"content\"]//*[@class=\"js-board-editing-target board-header-btn-text\"]");



    //List
    private final By linkAddList = By.xpath("//*[@class=\"placeholder\"]");
    private final By nameListField = By.xpath("//*[@id=\"board\"]//*[@class = \"list-name-input\"]");
    private final By buttonAddList = By.xpath("//*[@id=\"board\"]//*[@class = \"nch-button nch-button--primary mod-list-add-button js-save-edit\"]");
    private final By nameListNew = By.xpath("//*[@id=\"board\"]//*[@class=\"list-header-name mod-list-name js-list-name-input\"]");

    // Card
    private final By linkAddCard = By.xpath("//*[@id=\"board\"]//*[@class = \"js-add-a-card\"]");
    private final By nameCardField = By.xpath("//*[@id=\"board\"]//*[@class = \"list-card-composer-textarea js-card-title\"]");
    private final By buttonAddCard = By.xpath("//*[@id=\"board\"]/div//*[@class = \"nch-button nch-button--primary confirm mod-compact js-add-card\"]");

    // LogOut
    private final By clicPerfil = By.xpath("//*[@id=\"header\"]//*[@class = \"DweEFaF5owOe02 rQ86P0iNikD4I9 Cg0RMJhBknTRbM\"]");
    private final By clicLogOut = By.xpath("//*[@data-testid= \"account-menu-logout\"]");
    private final By clicLogOut2 = By.xpath("//*[@class= \"css-178ag6o\"]");


    private final By buttonLogin = By.xpath("//*[@id=\"BXP-APP\"]//*//*[@class= \"Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr\"]");



    public BoardPage(WebDriver driver){
        this.driver = driver;
    }
    /*public void setTitleBoard(String titleBoard){
        driver.findElement(titleBoardField).sendKeys(titleBoard);
    }*/

    public void setTitleBoard(String titleBoard){
        //String titleBoard="BoardDemo2023";
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(titleBoardField)).click();
        driver.findElement(titleBoardField).sendKeys(titleBoard);
    }
    public BoardPage clickCreateButton(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonCreate)).click();
        return new BoardPage(driver);
    }
    public String getTittleBoardNew(){//Obtener titulo board creado
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(boardNew)).click();
        return driver.findElement(titleBoardNew).getText();
    }

    // List
    public BoardPage clickAddList(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(linkAddList)).click();
        return new BoardPage(driver);
    }

    public void setNameList(String listname){
        //String nameList="ListDemo";
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(nameListField)).click();
        driver.findElement(nameListField).sendKeys(listname);
    }
    public BoardPage clickCreateList(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonAddList)).click();
        driver.findElement(buttonAddList).click();
        return new BoardPage(driver);
    }

    public String getNameList(){
        return driver.findElement(nameListNew).getText();
    }

    // Card
    public BoardPage clickAddCard(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(linkAddCard)).click();
        return new BoardPage(driver);
    }
    public void setNameCard(String nameCard){
        //String nameCard="Analisis migración";
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(nameCardField)).click();
        driver.findElement(nameCardField).sendKeys(nameCard);
    }
    public BoardPage clickCreateCard(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonAddCard)).click();
        driver.findElement(buttonAddCard).click();
        return new BoardPage(driver);
    }
    public BoardPage LogOut(){
        driver.findElement(clicPerfil).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(clicLogOut)).click();

        return new BoardPage(driver);
    }
    public String getButtonLogin(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(clicLogOut2)).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonLogin)).getText();
        return driver.findElement(buttonLogin).getText();
    }
}
