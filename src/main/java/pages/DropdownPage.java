package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private final WebDriver driver;
    private final By dropdownField = By.id("dropdown");
    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }
    public Select findDropdownElement(){
        return new Select(driver.findElement(dropdownField));
    }
    public void selectFromDropdown(String option){
        findDropdownElement().selectByVisibleText(option);
    }
    // instead of lambda use method reference (e-e.getText()) - (WebElement::getText)
    public List<String> getSelectedOption(){
        List<WebElement> selectedElement = findDropdownElement().getAllSelectedOptions();
        return selectedElement.stream().map(WebElement::getText).collect(Collectors.toList());
    }



}
