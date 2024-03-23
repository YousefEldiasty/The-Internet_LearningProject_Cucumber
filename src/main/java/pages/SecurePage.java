package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage {
    private final WebDriver driver;
    private final By Alert = By.id("flash");
    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getAlertText() {
        return driver.findElement(Alert).getText();
    }
}
