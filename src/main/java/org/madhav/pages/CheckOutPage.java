package org.madhav.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    private WebDriver driver;

    //    public void checkOut(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "shopping_cart_container")
    WebElement inlineshoppigcart;

    @FindBy(className = "btn_action.checkout_button")
    WebElement buttonaction;

    public void shoppingCart() {
        inlineshoppigcart.click();
    }

    public void checkoutButton() {
        buttonaction.click();
    }

    //============================================
    @FindBy(className = "title")
    WebElement pageTitle;

    public String getPageTitle(){
        return pageTitle.getText();
    }

    @FindBy(id="cancel")
    WebElement cancelButton;

    public void clickCancelButton(){
        cancelButton.click();
    }
    @FindBy(id="continue")
    WebElement continueButton;

    public void clickContinueButton(){
        continueButton.click();
    }
    @FindBy(name = "firstName")
    WebElement firstName;
    @FindBy(name="lastName")
    WebElement lastName;
    @FindBy(name = "postalCode")
    WebElement postalCode;

    public void enterCheckoutDetails(String firstName, String lastName,String postalCode){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
    }

    //===================================================================


}

