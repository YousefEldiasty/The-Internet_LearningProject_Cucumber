package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameWysiwygTests extends BaseTests {
    @Test
    public void testFrameEditor(){
        var wysiwygyEditor = homePage.clickWysiwygEditor();
        wysiwygyEditor.clearTextArea();
        String text = "LOve you";
        wysiwygyEditor.editTextArea(text);
        Assert.assertEquals(wysiwygyEditor.getFrameText(),text,"the Text in WysiwygEditor not Correct");
        wysiwygyEditor.switchOutOfFrame();
    }
}
