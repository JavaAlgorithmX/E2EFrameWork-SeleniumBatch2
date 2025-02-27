package org.madhav.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage {
    private WebDriver driver;

    public CheckOutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   @FindBy(name = "finish")
    WebElement finishButton;

    public void clickFinishButton(){
        finishButton.click();
    }
}