package com.airmee.staging.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendOrderPageTest {

    @FindBy(xpath="//button[@role='option']")
    WebElement option;

    @FindBy(xpath="//input[@role='combobox']")
    WebElement combobox;



    public void sendOrder(){
        option.sendKeys("adress");
        combobox.click();
    }





}
