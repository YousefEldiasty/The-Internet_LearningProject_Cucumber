package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import CucumberPages.LoginPage;
import org.testng.Assert;


public class LoginDefinition {
    public WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setupBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @Given("navigate to the login Page")
    public void navigate_to_the_login_Page() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("^user enter \"(.*)\" and \"(.*)\"$")
    public void userEnterData(String username, String password) {
        loginPage.loginSteps(username,password);
    }

    @And("user click on Login")
    public void clickOnLogin() {
        loginPage.passwordElement.sendKeys(Keys.ENTER);
    }
    @Then("user cloud login successfully")
    public void userLoginSuccessfully() {
        String expectedResult = "You logged into a secure area!";
        String actualResult = driver.findElement(loginPage.flashPom()).getText();
        Assert.assertTrue(actualResult.contains(expectedResult),"Error Message: Text Is Wrong");
    }
    @Then("user cloud login unSuccessfully")
    public void userCloudLoginUnSuccessfully() {
        String expectedResult = "You logged into a secure area!";
        String actualResult = driver.findElement(loginPage.flashPom()).getText();
        Assert.assertTrue(actualResult.contains(expectedResult),"Error Message: Text Is Wrong");
    }
    @And("user go to secure page")
    public void userGoToSecurePage() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure","Url Isn't the Expected");
    }

    @And("user still in same page")
    public void userStillInSamePage() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/login","Url Isn't the Expected");
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
