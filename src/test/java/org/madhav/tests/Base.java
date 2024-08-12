package org.madhav.tests;

import org.apache.commons.io.FileUtils;
import org.madhav.listners.ExtentReportListener;
import org.madhav.utils.PropertiesLoader;
import org.madhav.utils.WebDriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Base {
    public static WebDriver driver;

    @BeforeSuite
    public void setUp(){
        String browser = PropertiesLoader.getValue("browser");
        System.out.println("Browser from config file -> "+browser);
        //driver = new ChromeDriver();
        driver = WebDriverFactory.getWebDriver();
        //Web Driver waits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //window
        driver.get("https://www.saucedemo.com/");
        ExtentReportListener.setDriver(driver);
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    public void takeScreenshot(String filename){
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        System.out.println(timestamp);

        String filepath = "screenshots/"+timestamp+"_"+filename+".png";
        try{
            //commons-io
            FileUtils.copyFile(source,new File(filepath));
        }catch (IOException e){
            System.out.println("Exception occurred ");
            e.printStackTrace();
        }
    }

}
