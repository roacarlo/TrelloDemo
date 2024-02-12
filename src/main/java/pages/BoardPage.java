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



    public BoardPage linkAddBoard(String mainWindowHandle){
        // Cambiar al contexto de la ventana emergente
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        // Realizar acciones en la ventana emergente (por ejemplo, cerrarla)
        //driver.close();

        // Volver al contexto de la ventana principal (si es necesario)
        driver.switchTo().window(mainWindowHandle);

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
