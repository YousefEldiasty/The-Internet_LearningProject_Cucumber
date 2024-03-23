package hover;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTests extends BaseTests {
    @Test
    public void testHoverUSer1(){
        var hoverPage = homePage.clickHover();
        var figCaption = hoverPage.hoverOverfigure(1);
        Assert.assertTrue(figCaption.isFigureCaptionDisplayed(),"FigCaption Is Not Displayed");
        Assert.assertEquals(figCaption.getTitle(),"name: user1","FigCaption Title is InCorrect");
        Assert.assertTrue(figCaption.getLink().endsWith("/users/1"),"FigCaption Link is InCorrect");
        Assert.assertEquals(figCaption.getLinkText(),"View profile","FigCaption LinkText is InCorrect");
    }
}
