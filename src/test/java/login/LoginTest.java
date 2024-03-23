package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SecurePage;

public class LoginTest extends BaseTests {

    @Test
    public void successfulLoginTest(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUserNameField("tomsmith");
        loginPage.setPasswordFieldField("SuperSecretPassword!");
        SecurePage securePage = loginPage.clickOnLoginButton();
        String actualResult = securePage.getAlertText();
        Assert.assertTrue(actualResult.contains("You logged into a secure area!"),"Error in AlertText");
    }
}
