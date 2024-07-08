package com.pkg.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseClass {

    public WebDriver driver;
    public ExcelDataProvider excel;
    public ConfigDataProvider config;

    public ExtentReports report;
    public ExtentTest logger;

    @BeforeSuite
    public void setupDataProviderBeforeSuit() {
        //Creating Object for the ExcelDataProvider Class to read to data from file
        excel = new ExcelDataProvider();
        config=new ConfigDataProvider();

        //Creating Object for the ExtentReport to create extent report and start logging into our Code.
        //Also declare report.flush() method in the tearDown method to add results in ExtentReport after each method.
        ExtentSparkReporter extentSpark=new ExtentSparkReporter(new File("./Reports/ExtentReportFreeCRM_"+HelperClass.getcurrentDateTime()+".html"));
        report=new ExtentReports();
        report.attachReporter(extentSpark);
    }

    @BeforeClass
    public void setup() {
        driver = BrowserFactory.startApplication(driver, config.getConfigBrowserData(), config.getConfigQAurlData());
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }

    //Taking Screenshot after each Test Method Failure
    @AfterMethod
    public void AttachScreenShot(ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            //Attaching failure screenshot in the report.
            logger.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(HelperClass.CaptureScreenshot(driver)).build());
        }
        else if (result.getStatus()==ITestResult.SUCCESS) {
            //Attaching success screenshot in the report.
            logger.pass("Test Case Passed", MediaEntityBuilder.createScreenCaptureFromBase64String(HelperClass.CaptureScreenshot(driver)).build());
        }
        else if (result.getStatus()==ITestResult.SKIP) {
            //Attaching success screenshot in the report.
            logger.skip("Test Case Skipped", MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.CaptureScreenshot(driver)).build());
        }

        //Adding result into Extent Report after each method
        report.flush();
    }
}
