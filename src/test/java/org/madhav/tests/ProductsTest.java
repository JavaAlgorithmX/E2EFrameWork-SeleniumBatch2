package org.madhav.tests;

import org.madhav.pages.LoginPage;
import org.madhav.pages.ProductsPage;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ProductsTest extends Base {

    @Test(dependsOnMethods = {"login_with_valid_username_and_password"})
    public void addMultipleProductsToCart() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(driver);
        ArrayList<String> products = new ArrayList<>();
        products.add("Sauce Labs Backpack");
        products.add("Sauce Labs Bike Light");
        products.add("Sauce Labs Onesie");
        products.add("Sauce Labs Fleece Jacket");
        productsPage.addProductsToCart(products);
    }
}
