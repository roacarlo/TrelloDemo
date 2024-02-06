package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    private WebDriver driver;


    //Login
    private final By buttonStart = By.xpath("//*[@class = \"Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr\"]");
    private final By usernameField = By.xpath("//*[@id=\"username\"]");
    private final By passwordField = By.xpath("//*[@id=\"password\"]");
    private final By buttonContinue = By.xpath("//*[@id=\"login-submit\"]");
    private final By buttonLogin = By.xpath("//*[@id=\"login-submit\"]");

    // Board
    private final By titleHomeTrello = By.xpath("//*[@class=\"boards-page-section-header-name\"]");
    private final By buttonPerfil = By.xpath("//*[@class = \"DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez\"]");
    private final By emailUser = By.xpath("//*[@class = \"AS8ZlkEoqFiwD_\"]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Login
    public LoginPage clickStartLogin(){
        driver.findElement(buttonStart).click();
        return new LoginPage(driver);
    }
    public void setUsername(String user){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(usernameField)).click();
        driver.findElement(usernameField).sendKeys(user);
    }
    public LoginPage clicContinueButton(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(buttonContinue)).click();
        driver.findElement(buttonContinue).click();
        return new LoginPage(driver);
    }

    public void setPassword(String pass){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(passwordField)).click();
        driver.findElement(passwordField).sendKeys(pass);
    }

    public BoardPage clicLoginButton(){
        driver.findElement(buttonLogin).click();
        return new BoardPage(driver);
    }
    public BoardPage clicPerfil(){
        //driver.findElement(buttonPerfil).click();//////
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(buttonPerfil)).click();
        return new BoardPage(driver);
    }
    public String getEmailUser(){
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(emailUser)).click();
        return driver.findElement(emailUser).getText();
    }
    public String getTitleHomeTrello(){
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(titleHomeTrello)).click();
        return driver.findElement(titleHomeTrello).getText();
    }
    /*public BoardPage btnCreateBoard(){
        driver.findElement(btnCreateBoard).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(btnCreateBoard)).click();
        return new BoardPage(driver);
    }*/

}