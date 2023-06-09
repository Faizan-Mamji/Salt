package org.TREE.Listeners;

import io.qameta.allure.Attachment;
import org.TREE.Utils.PageFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class WebAllureListener implements ITestListener {
    WebDriver driverWeb;
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    // Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driverWeb) {
        return ((TakesScreenshot) driverWeb).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page screenshot Web", type = "image/png")
    public byte[] saveScreenshotPNGWeb(WebDriver driverweb) {
        return ((TakesScreenshot) driverweb).getScreenshotAs(OutputType.BYTES);
    }

    // Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    // HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", PageFactory.getWebDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult));
        Object testClass = iTestResult.getInstance();

        driverWeb = PageFactory.getWebDriver();

        if (driverWeb instanceof WebDriver) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenshotPNG(driverWeb);
            saveTextLog(getTestMethodName(iTestResult) + " passed and screenshot taken!");
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult));
        Object testClass = iTestResult.getInstance();

        driverWeb = PageFactory.getWebDriver();

        if (driverWeb instanceof WebDriver) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult).replace("tc_", "").replace("_", " "));
            saveScreenshotPNG(driverWeb);
            saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}