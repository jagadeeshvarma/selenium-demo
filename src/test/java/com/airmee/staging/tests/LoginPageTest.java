package com.airmee.staging.tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class LoginPageTest extends TestBase{

    LoginPage page;

    @BeforeClass
    public void setUp() {
        init("safari");
        page = PageFactory.initElements(driver,LoginPage.class);
       }

    @Test(priority = 0)
    public void verifyHomePage(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Airmee Enterprise Dashboard";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test(priority = 1)
    public void verifyLogin(){
        page.login(USER,PASSWORD);
    }

    @AfterClass
    public void tearDown() {
       driver.quit();
    }
}