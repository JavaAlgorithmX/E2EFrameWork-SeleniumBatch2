package org.madhav.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    private WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCart;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    public void clickMenuButton(){
        menuButton.click();
    }

    public void clickShoppingCart(){
        shoppingCart.click();
    }

    public boolean isCartBadgeDisplayed(){
        try{
            return cartBadge.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public int getCartProductNumber(){
        if(isCartBadgeDisplayed()) {
            String productNumber = cartBadge.getText();
            return Integer.parseInt(productNumber);
        }
        return 0;
    }
}
