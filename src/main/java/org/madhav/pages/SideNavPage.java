package org.madhav.pages;

import org.madhav.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SideNavPage {
    private WebDriver driver;

    public SideNavPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "bm-cross-button")
    WebElement closeButton;

    @FindBy(id = "logout_sidebar_link")
    WebElement logOutButton;

    public void clickCloseButton() {
        closeButton.click();
    }

    public LoginPage clickLogOutButton(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10 ));
//                wait.until(ExpectedConditions.elementToBeClickable(logOutButton)).click();
        //logOutButton.click();
        WaitUtils.waitTillElementToBeClickable(driver, 10, logOutButton).click();
        return new LoginPage(driver);
    }
}