package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTests {
    @Test
    public void testScrollToTable(){
        homepage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrolltoFifthParagraph(){
        homepage.clicInfiniteScroll().scrollToParagraph(5);
    }
}
