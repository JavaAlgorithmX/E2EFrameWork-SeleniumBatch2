package org.madhav.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class YourCartPage {
    private WebDriver driver;

    //    public void yourCarts(WebDriver driver) {
    //        this.driver = driver;
    //        PageFactory.initElements(driver, this);
    //    }

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    @FindBy(className = "btn_primary btn_inventory")
//    WebElement btn_primary_btn_inventory;

    @FindBy(className = "title")
    WebElement pageTitle;
    
    @FindBy(className = "inventory_item_name")
    List<WebElement> productList;

    @FindBy(id = "continue-shopping")
    WebElement continueShopping;

    @FindBy(id = "checkout")
    WebElement checkout;

//    public void cartonClick() {
//        btn_primary_btn_inventory.click();
//    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public List<String> getProductListInCart(){
        List<String> productListString = new ArrayList<>();
        for(WebElement e: productList){
            productListString.add(e.getText());
        }
        return productListString;
    }

    //returning Page
    public ProductsPage clickContinueShopping(){
        continueShopping.click();
        return new ProductsPage(driver);
    }

    public void clickCheckOut(){
        checkout.click();
    }

    public void removeProductFromCartByName(String productName){
        String productNameXpath = "//div[text()='"+productName+"']";
        driver.findElement(By.xpath(productNameXpath))
                .findElement(By.xpath("ancestor::div[@class='cart_item_label']"))
                .findElement(By.xpath("descendant::button")).click();
    }

    public double getPriceByProductName(String productName){
        String productNameXpath = "//div[text()='"+productName+"']";
        String priceString = driver.findElement(By.xpath(productNameXpath))
                .findElement(By.xpath("ancestor::div[@class='cart_item_label']"))
                .findElement(By.xpath("descendant::div[@class='inventory_item_price']")).getText();
        System.out.println(Double.parseDouble( priceString.substring(1)));
        return Double.parseDouble( priceString.substring(1));
    }

}
