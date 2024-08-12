package org.madhav.tests;

import org.madhav.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class E2ETests extends Base {
//    @Test()
    public void getProductPageTitle(){
        String title = driver.findElement(By.className("title")).getText();
        System.out.println(title);
//        takeScreenshot("E2E");
    }
    @Test
    public void e2eTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        String productPageTitle = productsPage.getTitle();
        Assert.assertEquals(productPageTitle,"Products","Title is not correct");

        productsPage.productDetailsByNameVoid("Sauce Labs Bolt T-Shirt");

        ProductsDetailsPage productsDetailsPage = new ProductsDetailsPage(driver);
        productsDetailsPage.clickAddToCartButton();

        HeaderPage headerPage = new HeaderPage(driver);

        boolean isCartBadgeDisplayed = headerPage.isCartBadgeDisplayed();
        Assert.assertTrue(isCartBadgeDisplayed,"Cart badge is not displayed");

        int cartProductNumber = headerPage.getCartProductNumber();
        Assert.assertEquals(cartProductNumber,1,"Cart product number is not Correct");

        headerPage.clickShoppingCart();

        YourCartPage yourCartPage = new YourCartPage(driver);
        String cartPageTitle = yourCartPage.getPageTitle();
        Assert.assertEquals(cartPageTitle,"Your Cart","Page Title is not correct");

        yourCartPage.clickCheckOut();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        String checkOutPageTitle = checkOutPage.getPageTitle();
        Assert.assertEquals(checkOutPageTitle,"Checkout: Your Information","Page Title is not correct");

        checkOutPage.enterCheckoutDetails("Madhavi", "Poli", "8765443");
        checkOutPage.clickContinueButton();

        CheckOutOverviewPage checkOutOverviewPage = new CheckOutOverviewPage(driver);
        checkOutOverviewPage.clickFinishButton();

        ThankYouPage thankYouPage = new ThankYouPage(driver);
        String thankYouPageTitle = thankYouPage.getPageTitle();
        Assert.assertEquals(thankYouPageTitle,"Checkout: Complete!","Page Title is not correct");

        thankYouPage.clickBackToHomeButton();

        headerPage.clickMenuButton();
        SideNavPage sideNavPage = new SideNavPage(driver);
        //Thread.sleep(2000);

        sideNavPage.clickLogOutButton();
    }
}
