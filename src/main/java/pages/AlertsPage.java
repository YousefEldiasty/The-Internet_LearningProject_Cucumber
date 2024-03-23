package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private final WebDriver driver;
    private final By acceptedAlertB = By.xpath("//button[text()=\"Click for JS Alert\"]");
    private final By confirmAlertB = By.xpath("//button[text()=\"Click for JS Confirm\"]");
    private final By promptAlertB = By.xpath("//button[text()=\"Click for JS Prompt\"]");
    private final By resultOfAlert = By.id("result");
    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAlerts(By locator){
        driver.findElement(locator).click();
    }
    public String getResult(){
        return driver.findElement(resultOfAlert).getText();
    }
    public String acceptedAlert() throws InterruptedException {
        clickAlerts(acceptedAlertB);
        //Thread.sleep(1000);
        String actualText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return actualText;
    }

    public String confirmAlert(){
        clickAlerts(confirmAlertB);
        String actualText = driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();
        return actualText;
    }

    public String promptAlert(String input) throws InterruptedException {
        clickAlerts(promptAlertB);
        String actualText = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys(input);
        driver.switchTo().alert().accept();
        return actualText;
    }

}
