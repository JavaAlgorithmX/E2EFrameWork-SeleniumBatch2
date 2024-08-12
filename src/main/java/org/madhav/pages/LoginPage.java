package org.madhav.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.madhav.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver){
        logger.info("Initializing Login Page...");
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id ="user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(className = "error-button")
    WebElement errorButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    //--------------------------------------------------------------------------------------------------

    public void login(String username, String password)  {
//        WebDriverFactory.getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
//        WebDriverFactory.getWebDriver().findElement(By.id("password")).sendKeys("secret_sauce");
//        WebDriverFactory.getWebDriver().findElement(By.id("login-button")).click();
        logger.info("Login with username : {} and password :{}", username, password);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean isErrorDisplayed(){
        return errorMessage.isDisplayed();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public void clickErrorButton(){
        errorButton.click();
    }
}
