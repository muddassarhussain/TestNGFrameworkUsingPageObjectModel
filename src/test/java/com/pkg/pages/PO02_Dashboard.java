package com.pkg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class PO02_Dashboard {

    WebDriver driver;
    public PO02_Dashboard(WebDriver driver)
    {
        this.driver=driver;
    }

    @FindBy(css = "i[class='close icon']")
    WebElement CloseIcon;

    @FindBy(xpath = "//b[contains(text(),'Test Company')]")
    WebElement TextPresentOnDashboardScreen;


    public void UserOnDashboard()
    {

    }

}
