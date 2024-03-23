package javaScript;

import base.BaseTests;
import org.testng.annotations.Test;

public class Scroll extends BaseTests {
    //Git Test
    @Test
    public void testScrollPage() throws InterruptedException {
        var largeAndDeepDom = homePage.clickLargeAndDeepDom();
        largeAndDeepDom.ScrollToTable();
        largeAndDeepDom.getDriver();
    }

}
