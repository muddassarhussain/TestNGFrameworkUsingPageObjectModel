package com.pkg.testcases;

import com.pkg.pages.PO01_LoginApp;
import com.pkg.utility.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TC01_LoginApp extends BaseClass {

    @Test
    public void loginAppTest() {
        logger= report.createTest("Login to CRM Test");
        //Initialising the PageFactory and this will return the Object of LoginApp class
        PO01_LoginApp LoginPageObject = PageFactory.initElements(driver, PO01_LoginApp.class);
        logger.info("Starting Application");
        //Sending two parameter in LoginApp_Method to get the data from excel sheet.
        LoginPageObject.LoginApp_Method(excel.getExcelStringData("DataSheet", 0, 0), excel.getExcelStringData("DataSheet", 0, 1));
        logger.pass("Login Successful");
        //Capture The screenshot

    }
}
