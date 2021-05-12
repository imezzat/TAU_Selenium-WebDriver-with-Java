package base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    private EventFiringWebDriver driver;
    protected HomePage homepage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
//        System.setProperty("webdriver.gecko.driver","resources/geckodriver");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
//        driver = new EventFiringWebDriver(new FirefoxDriver());
        driver.register(new EventReporter());
        driver.manage().window().setPosition(new Point(980,37));
//        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
        /**
         * Implicit Waits
         *
         * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         */

        goHome();
        setCookie();

//        driver.manage().window().maximize();
//        System.out.println(driver.getTitle());
//        System.out.println(driver.findElements(By.tagName("a")).size());
//        driver.findElement(By.linkText("Shifting Content")).click();
//        driver.findElement(By.linkText("Example 1: Menu Element")).click();
//        System.out.println(driver.findElements(By.tagName("li")).size());

    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homepage = new HomePage(driver);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
//    public static void main(String[]args){
//        BaseTests test = new BaseTests();
//        test.setUp();
//
//    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/"+result.getName()+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        /**
         * runs test without opening the browser
         */
//        options.setHeadless(true);
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau","123")
                .domain("the-internet.herokuapp.com").build();
        driver.manage().addCookie(cookie);
    }
}
