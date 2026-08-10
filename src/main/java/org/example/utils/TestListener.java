package org.example.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
       ExtentReportManager.createTest(testName);
        ExtentReportManager.getTest().info("Test Started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().pass("Test Passed " + result.getName());
    }


    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getTest().fail("Test Failed " + result.getThrowable());
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().skip("Test Skiped " + result.getName());
    }

    @Override
    public void onFinish(ITestContext result) {
        ExtentReportManager.flushReports();
    }
}