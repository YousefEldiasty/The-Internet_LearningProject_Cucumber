package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTests extends BaseTests {
    @Test
    public void testValidFileUpload(){
        var fileUpload = homePage.clickFileUpload();
        String path = "E:\\ITI-Intensive\\UI_AUTOMATION\\TestUniversity\\TestUniversityCourse\\resources\\wifi.jpg";
        fileUpload.addFile(path);
        Assert.assertTrue(fileUpload.getResult().contains("wifi.jpg"),"the uploaded file incorrect");
    }
}
