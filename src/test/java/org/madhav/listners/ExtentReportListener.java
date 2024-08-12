package org.madhav.listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.madhav.tests.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportListener extends Base implements ITestListener {
    private static ExtentReports extentReports;
    private static ExtentTest test;
    private static WebDriver driver;


    @Override
    public void onStart(ITestContext context) {
        // Create timestamp
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/Report_" + timestamp + ".html");

        // Additional report configuration
        spark.config().setReportName("Test Automation Report");// show on report page
        spark.config().setDocumentTitle("Test Execution Report");// show on tab

        extentReports = new ExtentReports();
        extentReports.attachReporter(spark);

        // Add system-wide or custom information
        extentReports.setSystemInfo("Tester", "Madhav");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("OS","Windows");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
        // Add custom information for each test
//        test.info("Tester: Madhavi");
//        test.info("Environment: QA");
//        test.info("Browser: Chrome");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
        //test.addScreenCaptureFromBase64String(takeScreenshotForReport());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test failed ");
        test.addScreenCaptureFromBase64String(takeScreenshotForReport());
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    // Method to capture screenshots

    private String takeScreenshotForReport() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    // Method to set WebDriver instance (to be called in your tests setup)
    public static void setDriver(WebDriver driver) {
        ExtentReportListener.driver = driver;
    }

}
