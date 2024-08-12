package org.madhav.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage {
    private WebDriver driver;

    public ThankYouPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    WebElement pageTitle;

    public String getPageTitle(){
        return pageTitle.getText();
    }

    @FindBy(name = "back-to-products")
    WebElement backToHomeButton;

    public void clickBackToHomeButton(){
        backToHomeButton.click();
    }

}
