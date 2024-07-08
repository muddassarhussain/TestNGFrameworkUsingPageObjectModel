package com.pkg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PO01_LoginApp {

    // Constructor
    WebDriver driver;

    public PO01_LoginApp(WebDriver driver) {
        this.driver = driver;
    }

    // Webelements
    @FindBy(xpath = "//span[text()='Log In']")
    WebElement LoginBtn;

    @FindBy(name = "email")
    WebElement WebEleUserName;

    @FindBy(name = "password")
    WebElement WebElePassword;

    @FindBy(xpath = "//div[text()='Login']")
    WebElement WebEleClickLogin;

    // Methods
    public void LoginApp_Method(String EnterUserName, String EnterPassword) {
        LoginBtn.click();
        WebEleUserName.sendKeys(EnterUserName);
        WebElePassword.sendKeys(EnterPassword);
        WebEleClickLogin.click();
    }
}
