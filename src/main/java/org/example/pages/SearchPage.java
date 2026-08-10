
package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='მწარმოებელი']")
    private WebElement manufacturer;

    @FindBy(xpath = "//img[@alt='Toyota']")
    private WebElement manufacturerLogo;

    @FindBy(xpath = "//span[normalize-space()='მოდელი']")
    private WebElement productModel;

    @FindBy(xpath = "(//label[normalize-space()='Camry'])[1]")
    private WebElement exactModel;

    @FindBy(xpath = "//span[normalize-space()='არჩევა']")
    private WebElement chooseButton;

    @FindBy(xpath = "//button[normalize-space()='გასაგებია']")
    private WebElement secondCookie;

    @FindBy(xpath = "//button[contains(normalize-space(), 'ძებნა')]")
    private WebElement searchButton;

    @FindBy(xpath = "//button[contains(.,'ქართული')]")
    private WebElement languageButtonGeorgian;


    @FindBy(xpath = "//li[normalize-space()='ინგლისური']")
    private WebElement englishOption;




    public void clickManufacturerButton() {
        click(manufacturer);
    }

    public void selectManufacturer() {
       // wait.until(ExpectedConditions.elementToBeClickable(manufacturerLogo));
        click(manufacturerLogo);
    }

    public void selectModel() {
        //wait.until(ExpectedConditions.elementToBeClickable(productModel));
        click(productModel);
    }

    public void selectExactModel(){
       // wait.until(ExpectedConditions.elementToBeClickable(exactModel));
        click(exactModel);
    }

    public void clickChooseButton(){
       // wait.until(ExpectedConditions.elementToBeClickable(chooseButton));
        click(chooseButton);
    }

    public void clickSecodCookie(){
        //wait.until(ExpectedConditions.elementToBeClickable(secondCookie));
        click(secondCookie);
    }

    public void clickSearchButton(){
       // wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        click(searchButton);
    }
    public void clickLanguageButtonGeorgian() {
        //wait.until(ExpectedConditions.elementToBeClickable(languageButtonGeorgian));
        click(languageButtonGeorgian);
    }
    public void selectEnglishLanguage() {
        //wait.until(ExpectedConditions.elementToBeClickable(englishOption));
        click(englishOption);
    }

    }





















