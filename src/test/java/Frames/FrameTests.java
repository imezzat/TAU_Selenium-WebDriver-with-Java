package Frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg(){
        var editorPage = homepage.clickWyswugEditor();
        editorPage.clearTextArea();

        String text1="hello";
        String text2="world";

        editorPage.setTextArea(text1);
        editorPage.increaseIndentation();
        editorPage.setTextArea(text2);
        editorPage.decreaseIndentation();

        assertEquals(editorPage.getTextFromEditor(),text1+text2,"Text is incorrect");
    }

    @Test
    public void testNestedFrames(){
        var nestedFrames = homepage.clickFrmaesPage().clickNestedFrames();
        assertEquals(nestedFrames.getLeftFrameText(),"LEFT","LEFT Frame Text is inaccurate");
        assertEquals(nestedFrames.getBottomFrameText(),"BOTTOM","BOTTOM Frame Text is inaccurate");
    }

}
