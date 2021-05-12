package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption(){
        var dropDownPage= homepage.clickDropDown();
        dropDownPage.selectFromDropDown("Option 1");
        var selectedOptions = dropDownPage.getSelectedoptions();
        assertEquals(selectedOptions.size(),1,"Incorrect no. of selections");
        assertTrue(selectedOptions.contains("Option 1"),"wrong option selected");
    }

    @Test
    public void testSelectMultipleOptions(){
        var dropDownPage= homepage.clickDropDown();
        dropDownPage.selectFromDropDown("Option 1","Option 2");
        var selectedOptions = dropDownPage.getSelectedoptions();
        assertEquals(selectedOptions.size(),2,"Incorrect no. of selections");
        assertTrue(selectedOptions.contains("Option 1") && selectedOptions.contains("Option 2")  ,"wrong option selected");
    }
}
