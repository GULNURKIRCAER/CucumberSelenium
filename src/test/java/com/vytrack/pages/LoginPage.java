package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//input[@name='_username']")
    public WebElement userName;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement submit;

    public void login(String userNameStr, String passwordStr) {
        this.userName.sendKeys(userNameStr);
        this.password.sendKeys(passwordStr, Keys.ENTER);
        // verification that we logged
    }
}