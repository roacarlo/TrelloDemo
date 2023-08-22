package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CardPage {

    private WebDriver driver;

    // Card
    private final By linkAddCard = By.xpath("//*[@id=\"board\"]//*[@class = \"js-add-a-card\"]");
    private final By nameCardField = By.xpath("//*[@id=\"board\"]//*[@class = \"list-card-composer-textarea js-card-title\"]");
    private final By buttonAddCard = By.xpath("//*[@id=\"board\"]/div//*[@class = \"nch-button nch-button--primary confirm mod-compact js-add-card\"]");
    private final By nameCardCreate = By.xpath("//*[@class = \"list-card-title js-card-name\"]");

    public CardPage(WebDriver driver){
        this.driver = driver;
    }

    // Card
    public CardPage clickAddCard(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(linkAddCard)).click();
        return new CardPage(driver);
    }
    public void setNameCard(String nameCard){
        //String nameCard="Analisis migración";
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(nameCardField)).click();
        driver.findElement(nameCardField).sendKeys(nameCard);
    }
    public CardPage clickCreateCard(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonAddCard)).click();
        driver.findElement(buttonAddCard).click();
        return new CardPage(driver);
    }
    public String getNameCardCreate(){
        return driver.findElement(nameCardCreate).getText();
    }
}
