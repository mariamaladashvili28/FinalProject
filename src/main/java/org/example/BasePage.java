package org.example;

import org.example.utils.ConfigReader;
import org.example.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getLong("wait")));
        PageFactory.initElements(driver, this);
    }

    public void waitForElementToBeClikalble(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void click(WebElement element) {
        waitForElementToBeClikalble(element);
        element.click();
        Utils.logInfo("click on" + element);

    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}