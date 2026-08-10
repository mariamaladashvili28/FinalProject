package org.example.test;

import org.example.BaseTest;
import org.example.pages.LoginPage;
import org.example.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
     @Test
     @Parameters({"email","password"})
    public void loginValid (String email,String password){
         WelcomePage welcomePage = new WelcomePage(driver);
         LoginPage loginPage = new LoginPage(driver);

         welcomePage.clickAcceptCookies();
         welcomePage.clickLoginButton();

         Assert.assertTrue(driver.getCurrentUrl().contains("https://auth.tnet.ge/ka/user/login/"));
          loginPage.login(email, password);
         Assert.assertTrue(loginPage.checkUserIcon());

    }
}
