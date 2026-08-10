package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.example.utils.ConfigReader;
import org.example.utils.DriverManager;

public class BaseTest {
    protected WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("base.url"));
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        DriverManager.quiDriver();
    }


}
