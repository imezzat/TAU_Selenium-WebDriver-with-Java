package cookies;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CookiesTests extends BaseTests {

    @Test
    public void deleteCookie(){
        homepage.deleteCookie("optimizelyBuckets");
        assertTrue(!homepage.getCookies().contains("optimizelyBuckets"),"deleted cookie is still there.");
    }
}
