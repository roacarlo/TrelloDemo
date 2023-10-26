package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CardPage {

    private WebDriver driver;

    //private final By linkAddCard = By.xpath("//*[@id=\"board\"]//*[@data-testid=\"list-add-card-button\"]");
    private final By linkAddCard = By.xpath("//*[@id=\"board\"]//*[@class=\"O9vivwyDxMqo3q bxgKMAm3lq5BpA iUcMblFAuq9LKn PnEv2xIWy3eSui SEj5vUdI3VvxDc\"]");
    private final By nameCardField = By.xpath("//*[@id=\"board\"]/li/div/ol/form/textarea");
    private final By buttonAddCard = By.xpath("//*[@id=\"board\"]//*[@class='bxgKMAm3lq5BpA SdamsUKjxSBwGb SEj5vUdI3VvxDc']");

    private final By nameCardCreate = By.xpath("//*[@id=\"board\"]//*[@class=\"NdQKKfeqJDDdX3\"]");

    public CardPage(WebDriver driver){
        this.driver = driver;
    }

    // Card
    public CardPage clickAddCard(){
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(linkAddCard)).click();
        return new CardPage(driver);
    }
    public void  setNameCard(String nameCard){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(nameCardField)).click();
        driver.findElement(nameCardField).sendKeys(nameCard);
    }
    public CardPage clickCreateCard(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonAddCard)).click();
        //driver.findElement(buttonAddCard).click();
        return new CardPage(driver);
    }
    public String getNameCardCreate(){
        return driver.findElement(nameCardCreate).getText();
    }
}
