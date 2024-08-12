package org.madhav.tests;

import org.madhav.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends Base {
    @Test(testName = "login")
    public void login_with_valid_username_and_password(){
       // WebDriver driver = new ChromeDriver();
//        driver.get("https://www.saucedemo.com/");
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        driver.findElement(By.id("login-button")).click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
//        takeScreenshot("demo");
    }
//    @Test
    public void login_with_invalid_username_and_password() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.saucedemo.com/");
//        driver.findElement(By.id("user-name")).sendKeys("standard_usern");
//        driver.findElement(By.id("password")).sendKeys("secret_saucem");
//        driver.findElement(By.id("login-button")).click();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("username", "pass");
        Thread.sleep(2000);
        System.out.println(loginPage.isErrorDisplayed());
        System.out.println(loginPage.getErrorMessage());
        loginPage.clickErrorButton();
        Thread.sleep(2000);
    }
}
