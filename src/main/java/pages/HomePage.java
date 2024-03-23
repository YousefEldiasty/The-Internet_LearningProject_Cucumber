package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

public class HomePage {

    private final WebDriver driver;
    private final By formAuthenticationLink = By.linkText("Form Authentication");
    private final By dropdownLink = By.linkText("Dropdown");
    private By hoverLink = By.linkText("Hovers");
    private By javaScriptAlerts = By.linkText("JavaScript Alerts");
    private By fileUpload = By.linkText("File Upload");
    private By wysiwygEditor = By.linkText("WYSIWYG Editor");
    private By largeAneDeepDom = By.linkText("Large & Deep DOM");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLink(By locator){
        driver.findElement(locator).click();
    }
    public LoginPage clickFormAuthentication(){
        clickLink(formAuthenticationLink);
        return new LoginPage(driver);
    }
    public DropdownPage clickDropdown(){
        clickLink(dropdownLink);
        return new DropdownPage(driver);
    }
    public HoverPage clickHover(){
        clickLink(hoverLink);
        return new HoverPage(driver);
    }
    public AlertsPage clickJavaScriptAlert(){
        clickLink(javaScriptAlerts);
        return new AlertsPage(driver);
    }
    public UploadFile clickFileUpload(){
        clickLink(fileUpload);
        return new UploadFile(driver);
    }
    public WysiwygEditorPage clickWysiwygEditor(){
        clickLink(wysiwygEditor);
        return new WysiwygEditorPage(driver);
    }
    public LargeAndDeepDomPage clickLargeAndDeepDom(){
        clickLink(largeAneDeepDom);
        return new LargeAndDeepDomPage(driver);
    }
}
