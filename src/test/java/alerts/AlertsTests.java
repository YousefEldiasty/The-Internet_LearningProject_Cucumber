package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTests extends BaseTests {

    @Test
    public void testAcceptedAlert() throws InterruptedException {
        var acceptedAlert = homePage.clickJavaScriptAlert();
        String actualText = acceptedAlert.acceptedAlert();
        Assert.assertTrue(actualText.contains("I am a JS Alert"),"error in Text on Accepted alert");
        Assert.assertTrue(acceptedAlert.getResult().contains("You successfully clicked an alert"),"Wrong result for acceptedAlert");
    }

    @Test
    public void testConfirmAlert(){
        var confirmAlert = homePage.clickJavaScriptAlert();
        String actualText = confirmAlert.confirmAlert();
        Assert.assertTrue(actualText.contains("I am a JS Confirm"),"error in Text on confirm alert");
        Assert.assertTrue(confirmAlert.getResult().contains("You clicked: Cancel"),"Wrong result for confirmAlert");
    }

    @Test
    public void testPromptAlert() throws InterruptedException {
        var promptAlert = homePage.clickJavaScriptAlert();
        String input = "joe";
        String actualText = promptAlert.promptAlert(input);
        Assert.assertTrue(actualText.contains("I am a JS prompt"),"error in Text on prompt alert");
        Assert.assertTrue(promptAlert.getResult().contains(input),"Wrong result for promptAlert");
    }
}
