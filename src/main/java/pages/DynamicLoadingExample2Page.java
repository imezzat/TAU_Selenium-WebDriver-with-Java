package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DynamicLoadingExample2Page {
    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadedText = By.id("finish");

    public static String getUrl() {
        return url;
    }

    private static final String url = "https://the-internet.herokuapp.com/dynamic_loading/2";

    public DynamicLoadingExample2Page(WebDriver driver) {
        this.driver = driver;
    }
    public void clickStart(){
        driver.findElement(startButton).click();
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds((5))).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadedText));
    }

    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }

    public boolean checkStartButtonIsDisplayed(){
        return driver.findElement(startButton).isDisplayed();
    }

}
