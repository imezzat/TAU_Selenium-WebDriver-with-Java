package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorSlider {
    private WebDriver driver;
    private By slider = By.tagName("input");
    private By value = By.id("range");

    public HorSlider(WebDriver driver) {
        this.driver=driver;
    }

    /**
     *
     * @param val should be between 0 & 5 with 0.5 increments
     */
    public void setHorzSliderToVal(double val){
        for(int i=0;i<(int)val/0.5;i++)
        driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
    }

    public double getHorSliderVal(){
        return Double.parseDouble(driver.findElement(value).getText());
    }

}
