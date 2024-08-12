package org.madhav.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    WebElement pageTitle;


//    public void addProductToCartByName(String productName) {
//        WebElement secondElement = driver.findElement(By.xpath("//div[text()='" + productName + "']"));
//        System.out.println("Second element is:" + secondElement.getText());
//    }

    public String getTitle() {
        return pageTitle.getText();
    }

    /*
     X path axis

     1. ancestor -> Selects all ancestors (parent, grandparent, etc.) of the current node.
     2. ancestor-or-self -> Selects all ancestors (parent, grandparent, etc.) of the current node and the current node itself
     3. attribute -> Selects all attributes of the current node
     4. child -> Selects all children of the current node.
     5. descendant -> Selects all descendants (children, grandchildren, etc.) of the current node.
     6. descendant-or-self -> Selects all descendants (children, grandchildren, etc.) of the current node and the current node itself.
     7. following -> Selects everything in the document after the closing tag of the current node.
     8. following-sibling -> Selects all siblings after the current node.
     9. namespace -> Selects all namespace nodes of the current node. (Rarely used)
     10. parent -> Selects the parent of the current node.
     11. preceding -> Selects all nodes that appear before the current node in the document, except ancestors, attribute nodes, and namespace nodes.
     12. preceding-sibling -> Selects all siblings before the current node.
     13. self -> Selects the current node

    */

    public void addProductByName(String productName) {
        String productXPathString = "//div[text()='" + productName + "']";

        driver.findElement(By.xpath(productXPathString))
                .findElement(By.xpath("ancestor::div[@class='inventory_item_description']"))
                .findElement(By.tagName("button"))
                .click();
    }

    public void addProductsToCart(ArrayList<String> productList) {
        for (String product : productList) {
            addProductByName(product);
        }
    }

    public ProductsDetailsPage productDetailsByName(String productName){
        String productXPathString = "//div[text()='" + productName + "']";
        driver.findElement(By.xpath(productXPathString)).click();
        return new ProductsDetailsPage(driver);
    }

    public void productDetailsByNameVoid(String productName){
        String productXPathString = "//div[text()='" + productName + "']";
        driver.findElement(By.xpath(productXPathString)).click();

    }



}
