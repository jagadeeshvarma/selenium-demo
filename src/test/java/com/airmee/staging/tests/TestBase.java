package com.airmee.staging.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public Properties properties;
    String URL;
    String USER;
    String PASSWORD;

    public TestBase(){
        properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/test/resources/environment.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(String browser){
        URL = properties.getProperty("URL");
        USER = properties.getProperty("USER");
        PASSWORD = properties.getProperty("PASSWORD");

        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }


}
