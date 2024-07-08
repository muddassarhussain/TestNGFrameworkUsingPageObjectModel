package com.pkg.utility;

import org.apache.poi.util.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

//To handle the Screenshots, Frames, Alerts, Multiple Windows, Sync Issues, JS Executor
public class HelperClass {
    //Capture Screenshot when your test is done
    //Making this method as Static so whenever i need to call it i can directly call it. no need to create the object.
    public static String CaptureScreenshot(WebDriver driver) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Creating local variable to return screenshot path to attach it into the Extent Report.
        String ScreenshotPath=System.getProperty("user.dir")+"/Screenshots/FreeCRM_"+getcurrentDateTime()+".png";
        try {
            FileHandler.copy(src, new File(ScreenshotPath));
            //Converting image into base64
            byte[] imageBytes=IOUtils.toByteArray(new FileInputStream(ScreenshotPath));
            return Base64.getEncoder().encodeToString(imageBytes);
           // System.out.println("Testcase Screenshot Captured Successfully");
        } catch (IOException e) {
            System.out.println("Unable to capture screenshot " + e.getMessage());
        }
        return ScreenshotPath;
    }

    //GettingCurrent Date & Time and embedding it screenshot name to be unique.(using it in above method)
    public static String getcurrentDateTime()
    {
        DateFormat customFormat=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        Date currentDate=new Date();
        return customFormat.format(currentDate);
    }

    public void HandleFrames() {

    }

    public void ToHandleAlerts() {

    }
}
