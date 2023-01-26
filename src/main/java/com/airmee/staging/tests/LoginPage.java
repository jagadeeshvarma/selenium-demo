package com.airmee.staging.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver =driver;
    }

    @FindBy(xpath="//input[@type='email']")
    WebElement email;

    @FindBy(xpath="//input[@type='password']")
    WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    WebElement submit;

    public void login(String user, String pass){
        email.sendKeys(user);
        password.sendKeys(pass);
        submit.click();
    }

}
