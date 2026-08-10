package org.example.test;

import org.example.BaseTest;
import org.example.pages.SearchPage;
import org.example.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTest extends BaseTest {
    @Test
    public void searchWithFilters(){
        SearchPage searchPage = new SearchPage(driver);
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickAcceptCookies();

        searchPage.clickManufacturerButton();
        searchPage.selectManufacturer();
        searchPage.selectModel();
        searchPage.selectExactModel();
        searchPage.clickSecodCookie();
        searchPage.clickSearchButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("Camry"));
    }
    @Test//(groups = {"smoke"})
    public void changeLanguageTest() {

        SearchPage searchPage = new SearchPage(driver);
        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.clickAcceptCookies();

        searchPage.clickLanguageButtonGeorgian();
        searchPage.selectEnglishLanguage();

        Assert.assertTrue(driver.getCurrentUrl().contains("/en"));
    }

}
