package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String topFrame = "frame-top";
    private String bottomFrame = "frame-bottom";
    String Left_frame = "frame-left";
    String Bottom_frame = "frame-bottom";


    private By frame_text = By.tagName("body");

    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }

    private void switchtoLeftFrame(){
        driver.switchTo().frame(Left_frame);
    }

    public String getLeftFrameText(){
//        return driver.switchTo().frame(driver.findElement(Left_frame)).findElement(By.tagName("body")).getText();
        driver.switchTo().frame(topFrame);
        switchtoLeftFrame();
        String text = getFrameText();
        switchtoMainArea();
        switchtoMainArea();
        return text;
    }

    private String getFrameText(){
        return driver.findElement(frame_text).getText();
    }
    private void switchtoBottomFrame(){
        driver.switchTo().frame(Bottom_frame);
    }
    public String getBottomFrameText(){
        switchtoBottomFrame();
        String text =getFrameText();
        switchtoMainArea();
        return text;
    }


    private void switchtoMainArea(){
        driver.switchTo().parentFrame();
    }



}
