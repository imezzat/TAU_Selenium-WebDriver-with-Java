package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTests {

    @Test
    public void testBackSpace(){
        var keyPage = homepage.clickKeyPresses();
        keyPage.enterTet("A"+ Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(),"You entered: BACK_SPACE");
    }

    @Test
    public void testPi(){
        var keyPage = homepage.clickKeyPresses();
        keyPage.enterPI();
//        assertEquals(keyPage.getResult(),"You entered: BACK_SPACE");
    }
}
