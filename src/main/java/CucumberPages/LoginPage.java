package CucumberPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    // Constructor
    public LoginPage(WebDriver driver ){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    // Find Element Page Factory
    @FindBy(name = "username")
    WebElement userNameElement;
    @FindBy(name = "password")
    public WebElement passwordElement;
    // Find Element Using Methods
    public By flashPom(){
        return By.className("flash");
    }
    public By logoutPom(){
        return By.cssSelector("a[href=\"/logout\"]");
    }

    public void loginSteps(String username,String password){
        userNameElement.clear();
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
    }
}
