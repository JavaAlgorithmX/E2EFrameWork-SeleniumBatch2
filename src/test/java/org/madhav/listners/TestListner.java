package org.madhav.listners;

import org.madhav.tests.Base;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListner extends Base implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed from listners TestNG");
        System.out.println( result.getName());
        String fileName = result.getName();
        takeScreenshot(fileName);
    }


}
