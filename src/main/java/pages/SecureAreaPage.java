package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecureAreaPage {

    private WebDriver driver;
    WebDriverWait wait;
//    private By titleTrello = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/h3");
    private By titleBoard = By.xpath("XXx");

    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
    }

   /* public String getTitle(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(titleTrello)).click();
        return driver.findElement(titleBoard).getText();
    }*/
    public String getTitleBoard(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(titleBoard)).click();
        return driver.findElement(titleBoard).getText();
    }
}
