package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {
    private WebDriver driver;
    private By inputField = By.id("target");
    private By resultText = By.id("result");
    public KeyPressesPage(WebDriver driver){
        this.driver=driver;
    }

    public void enterTet(String text){
        driver.findElement(inputField).sendKeys(text);
    }

    public void enterPI(){
        enterTet(Keys.chord(Keys.LEFT_CONTROL,Keys.LEFT_SHIFT+"U")+"3c0"
        //        +Keys.ENTER
        );
    }

    public String getResult(){
        return driver.findElement(resultText).getText();
    }

}
