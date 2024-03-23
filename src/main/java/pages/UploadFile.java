package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadFile {
    private final WebDriver driver;
    private final By uploadFile = By.id("file-upload");
    private final By uploadButton = By.id("file-submit");
    private By uploadedFile = By.id("content");
    public UploadFile(WebDriver driver) {
        this.driver = driver;
    }
    public void clickUploadButton(){driver.findElement(uploadButton).click();}
    public void addFile(String path){
        driver.findElement(uploadFile).sendKeys(path);
        clickUploadButton();
    }
    public String getResult(){
        return driver.findElement(uploadedFile).getText();
    }
}
