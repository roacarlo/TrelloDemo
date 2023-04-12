package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    private WebDriver driver;

    //Login
    private final By buttonStart = By.xpath("//*[@id=\"BXP-APP\"]/header[1]/div/div[1]/div[2]/a[1]");
    private final By usernameField = By.id("user");
    private final By passwordField = By.xpath("//*[@id=\"password\"]");
    private final By buttonContinue = By.id("login");
    private final By buttonLogin = By.xpath("//*[@id=\"login-submit\"]/span/span");

    // Board
    private By btnCreateBoard = By.xpath("//*[@class=\"board-tile mod-add\"]");
    private By titleTrello = By.xpath("//*[@class=\"boards-page-section-header-name\"]");




    WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickStartLogin(){
        driver.findElement(buttonStart).click();
        return new LoginPage(driver);
    }
    public void setUsername(String user){
    //public void setUsername(){
        //String username="carlos.roa@pyxis.tech";
        driver.findElement(usernameField).sendKeys(user);
        //driver.findElement(usernameField).sendKeys(username);
    }
    public LoginPage clicContinueButton(){
        driver.findElement(buttonContinue).click();
        return new LoginPage(driver);
    }

    public void setPassword(String pass){
        //public void setPassword(){
        //String password="Pyxis*2023";
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(passwordField)).click();
        //driver.findElement(passwordField).sendKeys(password);
        driver.findElement(passwordField).sendKeys(pass);
    }

    public LoginPage clicLoginButton(){
        driver.findElement(buttonLogin).click();
        return new LoginPage(driver);
    }

    public String getTitleTrello(){
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(titleTrello)).click();
        return driver.findElement(titleTrello).getText();
    }
    public BoardPage btnCreateBoard(){
        new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(btnCreateBoard)).click();
        return new BoardPage(driver);
    }
}