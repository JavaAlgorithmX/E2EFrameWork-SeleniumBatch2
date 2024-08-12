package org.madhav.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsDetailsPage {
    private WebDriver driver;

    public ProductsDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart")
    WebElement addToCartButton;

    @FindBy(name = "back-to-products")
    WebElement backButton;

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public void clickBackButton(){
        backButton.click();
    }



}







