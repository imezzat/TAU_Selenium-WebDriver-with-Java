package navigation;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample2Page;

import static org.testng.Assert.assertTrue;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator(){
        homepage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void testSwitchToTab(){
        homepage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }

    @Test
    public void testSwitchToTabDynamicExample2(){
        var dynamicLoadingPageEx2 = homepage.clickDynamicLoading().DynamicLoadingExample2PageNewWindow();
        getWindowManager().switchToTabByURL(DynamicLoadingExample2Page.getUrl());
        assertTrue(dynamicLoadingPageEx2.checkStartButtonIsDisplayed(),"start button is not displayed");
    }
}
