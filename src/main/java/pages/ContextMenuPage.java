package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private WebDriver driver;
    private By hot_spot = By.id("hot-spot");
    public ContextMenuPage(WebDriver driver){
        this.driver=driver;
    }


    public void rightClickHotspot(){
        WebElement figure = driver.findElement(hot_spot);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).contextClick().perform();
    }

    public String getAlertMsg(){
        return driver.switchTo().alert().getText();
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }

}
