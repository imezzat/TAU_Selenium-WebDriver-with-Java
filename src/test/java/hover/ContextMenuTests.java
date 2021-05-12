package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testRightClick(){
        var contextMenuPage = homepage.clickContextMenu();
        contextMenuPage.rightClickHotspot();
        assertEquals(contextMenuPage.getAlertMsg(),"You selected a context menu","Wrong context menu message");
        contextMenuPage.alert_clickToAccept();
        return;
    }
}
