package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        var uploadPage = homepage.clickFileUpload();
        uploadPage.upload_file("/home/ibrahim/IdeaProjects/webdriver_java/resources/chromedriver");
        assertEquals(uploadPage.getUploadedFilesText(),"chromedriver","Uploaded files' name is incorrect");
    }
}
