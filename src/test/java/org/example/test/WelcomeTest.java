package org.example.test;

import org.example.BaseTest;
import org.example.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WelcomeTest extends BaseTest {
    @Test//(groups = {"smoke"})
    public void searchProduchByName(){
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickAcceptCookies();
        welcomePage.searchProduct("Volkswagen");
        Assert.assertTrue(welcomePage.getCurrentUrl().contains("Volkswagen"));
    }

    @Test(groups = {"smoke"})
    public void searchWithRent(){
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickAcceptCookies();
        welcomePage.clickRentButton();
        welcomePage.clickRentDaily();
        Assert.assertTrue(welcomePage.isDailyRentSelected(), "Daily rent checkbox is not selected");


    }






}
