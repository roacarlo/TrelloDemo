package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CardPage {

    private WebDriver driver;

    //private final By linkAddCard = By.xpath("//*[@id=\"board\"]//*[@data-testid=\"list-add-card-button\"]");
    private final By AddCard = By.xpath("//*[@class=\"O9vivwyDxMqo3q bxgKMAm3lq5BpA iUcMblFAuq9LKn PnEv2xIWy3eSui SEj5vUdI3VvxDc\"]");
    private final By nameCardField = By.xpath("//*[@class=\"qJv26NWQGVKzI9\"]");
    private final By createAddCard = By.xpath("//*[@class=\"bxgKMAm3lq5BpA SdamsUKjxSBwGb SEj5vUdI3VvxDc\"]");


    private final By nameCardCreate = By.xpath("//*[@class=\"NdQKKfeqJDDdX3\"]");

    public CardPage(WebDriver driver){
        this.driver = driver;
    }

    // Card
    public CardPage clickAddCard(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(AddCard)).click();
        return new CardPage(driver);
    }
    public void  setNameCard(String nameCard){
        driver.findElement(nameCardField).sendKeys(nameCard);
    }
    public CardPage clickCreateCard(){
        driver.findElement(AddCard).click();
        driver.findElement(createAddCard).click();
        //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(createAddCard)).click();
        return new CardPage(driver);
    }
    public String getNameCardCreate(){
        return driver.findElement(nameCardCreate).getText();
    }
}
