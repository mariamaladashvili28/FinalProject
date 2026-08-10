package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WelcomePage extends BasePage {

    public WelcomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class,'header-auth-button')]")
    private WebElement loginButton;

    @FindBy(id = "cookiescript_accept")
    private WebElement acceptCookies;

    @FindBy(xpath = "//input[@name='query']")
    private WebElement searchField;

    @FindBy(xpath = "//span[text()='ქირავდება']")
    private WebElement rentButton;

    @FindBy(xpath = "//label[.//input[@name='rentDaily']]")
    private WebElement rentDaily;

    @FindBy(xpath = "//input[@name='rentDaily']")
    private WebElement dailyRentCheckbox;




    public void clickAcceptCookies(){
       // wait.until(ExpectedConditions.elementToBeClickable(acceptCookies));
        click(acceptCookies);
    }

    public void clickLoginButton(){
        //wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        click(loginButton);
    }

    public void searchProduct(String productName){
        wait.until(ExpectedConditions.visibilityOf(searchField));
        click(searchField);
        searchField.clear();
        searchField.sendKeys(productName);
        searchField.sendKeys(Keys.ENTER);

    }

    public void clickRentButton(){
        wait.until(ExpectedConditions.visibilityOf(rentButton));
        click(rentButton);
    }

    public void clickRentDaily(){
        wait.until(ExpectedConditions.visibilityOf(rentDaily));
        click(rentDaily);
    }
    public boolean isDailyRentSelected() {
        return dailyRentCheckbox.isSelected();
    }

}

