package org.madhav.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getWebDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        }else {
            System.out.println("Driver is Null as browser name passed is: "+browserName);
            System.out.println("List of valid browsers : Chrome | Edge | Firefox ");
            return null;
        }
    }
}
