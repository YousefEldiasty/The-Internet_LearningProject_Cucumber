package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By userNameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButtonField = By.className("fa");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setUserNameField(String username){
        driver.findElement(userNameField).sendKeys(username);
    }
    public void setPasswordFieldField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public SecurePage clickOnLoginButton(){
        driver.findElement(loginButtonField).click();
        return new SecurePage(driver);
    }
}
