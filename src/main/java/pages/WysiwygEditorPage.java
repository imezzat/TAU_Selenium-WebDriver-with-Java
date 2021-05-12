package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String editorIframeId="mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("div.tox-toolbar__group:nth-child(5) > button:nth-child(1)");
    private By increaseIndentButton = By.cssSelector("div.tox-toolbar__group:nth-child(5) > button:nth-child(2)");
    public WysiwygEditorPage(WebDriver driver){
        this.driver=driver;
    }

    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    public void increaseIndentation(){
        driver.findElement(increaseIndentButton).click();
    }

    public void decreaseIndentation(){
        driver.findElement(decreaseIndentButton).click();
    }

    public String getTextFromEditor(){
        switchToEditArea();
        var text =driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }
}
