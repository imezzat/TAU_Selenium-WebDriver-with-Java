package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;
    private By file_upload = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFilesMsg = By.id("uploaded-files");
    public FileUploadPage(WebDriver driver){
        this.driver=driver;
    }
    public void upload_file(String file_path){
        driver.findElement(file_upload).sendKeys(file_path);
        clickUploadButton();
    }

    public void clickUploadButton(){
        driver.findElement(uploadButton).click();
    }

    public String getUploadedFilesText(){
        return driver.findElement(uploadedFilesMsg).getText();
    }

}
