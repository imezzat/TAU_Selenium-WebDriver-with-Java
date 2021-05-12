package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;

    /**
    this part is not very clear to me
     */
    private String linkXpath_Format = ".//a[contains(text(),'%s')";
    private By link_Example1 = By.linkText("Example 1: Element on page that is hidden");
    private By link_Example2 = By.linkText("Example 2: Element rendered after the fact");

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    public DynamicLoadingExample1Page clickExample1(){
        driver.findElement(link_Example1).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2(){
        driver.findElement(link_Example2).click();
        return new DynamicLoadingExample2Page(driver);
    }

    public DynamicLoadingExample2Page DynamicLoadingExample2PageNewWindow (){
        driver.findElement(link_Example2).sendKeys(Keys.chord(Keys.LEFT_CONTROL,Keys.ENTER));
        return new DynamicLoadingExample2Page(driver);
    }


}
