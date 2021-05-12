package HorSlider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HorSliderTests extends BaseTests {

    @Test
    public void testHorSliderVal4(){
        var horSliderPage =homepage.clickHorSlider();
         horSliderPage.setHorzSliderToVal(4);
         assertTrue(horSliderPage.getHorSliderVal()==4.0,"wrong slider value");

    }
}
