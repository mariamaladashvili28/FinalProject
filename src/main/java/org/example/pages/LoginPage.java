package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@data-testid='login-form__input-username']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@data-testid='login-form__input-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@data-testid='login-form__button-submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[contains(@class,'rounded-full') and contains(@class,'overflow-hidden')]")
    private WebElement userIcon;

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        click(loginButton);
    }

    public boolean checkUserIcon(){
        wait.until(ExpectedConditions.visibilityOf(userIcon));
        return userIcon.isDisplayed();
    }

    public void login(String email,String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    }



