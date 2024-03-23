package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HoverPage {
    private WebDriver driver;
    private final By figureBox = By.className("figure");
    private final By figCaptionBox = By.className("figcaption");
    public HoverPage(WebDriver driver) {
        this.driver = driver;
    }
    // @Param index start at 1 But in List Start with 0.
    public FigureCaption hoverOverfigure(int index){
        WebElement figureElement = driver.findElements(figureBox).get(index-1);
        Actions actions = new Actions(driver);
        actions.moveToElement(figureElement).perform();
        return new FigureCaption(figureElement.findElement(figCaptionBox));
    }
    public class FigureCaption{
        public WebElement figCaption;
        private By figCaptionHeader = By.tagName("h5");
        private By figCaptionLink = By.tagName("a");
        public FigureCaption(WebElement figCaption) {
            this.figCaption = figCaption;
        }
        public boolean isFigureCaptionDisplayed(){
            return figCaption.isDisplayed();
        }
        public String getTitle(){
            return figCaption.findElement(figCaptionHeader).getText();
        }
        public String getLink(){
            return figCaption.findElement(figCaptionLink).getAttribute("href");
        }
        public String getLinkText(){
            return figCaption.findElement(figCaptionLink).getText();
        }
    }

}
