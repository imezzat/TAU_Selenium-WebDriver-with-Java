import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {
    @Test
    public void testWaitUntilHidden(){
        var loadingPage = homepage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(),"Hello World!","Inaccurate Loading Text");
    }

    @Test
    public void testWaitUntilVisible(){
        var loadingPage = homepage.clickDynamicLoading().clickExample2();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(),"Hello World!","Inaccurate Loading Text");
    }
}
