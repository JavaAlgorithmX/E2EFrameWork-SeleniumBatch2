package org.madhav.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public static WebElement waitTillElementToBeClickable(WebDriver driver,int duration,WebElement element){
        return new WebDriverWait(driver, Duration.ofSeconds(duration))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitTillElementIsVisible(WebDriver driver,int duration,WebElement element){
        return new WebDriverWait(driver, Duration.ofSeconds(duration ))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement fluentWaitTillElementIsClickable(WebDriver driver,int duration,WebElement element,int pollingDuration){
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(pollingDuration))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
