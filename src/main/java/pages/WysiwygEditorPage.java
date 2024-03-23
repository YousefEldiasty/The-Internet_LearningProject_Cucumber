package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WysiwygEditorPage {
    private WebDriver driver;
    String frameId = "mce_0_ifr";
    private By textAreaFrame = By.id("tinymce");
    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }
    public void switchToFrame(){
        driver.switchTo().frame(frameId);
    }
    public void clearTextArea(){
        switchToFrame();
        // Implicit Wait
//        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        // Explicit Wait
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(textAreaFrame)));
        // Fluent Waits
        FluentWait<WebDriver> fWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofSeconds(1))
                                .ignoring(NoSuchElementException.class);
        fWait.until(ExpectedConditions.visibilityOf(driver.findElement(textAreaFrame)));
        driver.findElement(textAreaFrame).clear();
        switchOutOfFrame();
    }
    public void editTextArea(String text){
        switchToFrame();
        driver.findElement(textAreaFrame).sendKeys(text);
        switchOutOfFrame();
    }
    public void switchOutOfFrame(){
        driver.switchTo().parentFrame();
    }
    public String getFrameText(){
        switchToFrame();
        String text = driver.findElement(textAreaFrame).getText();
        switchOutOfFrame();
        return text;
    }
}
