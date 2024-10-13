package demoqa_tests;

import org.testng.annotations.Test;

public class BrowserWindowTest extends BaseTest{

    @Test
    void windowTest() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/browser-windows");
        for (int i = 0; i < 3; i++) {
            webElementActions.click(demoqaPages.browserWindowsPage.newTab);
        }
        Thread.sleep(4000);
        helper.windowHelper.switchToDefaultWindow();
        Thread.sleep(4000);
    }
}
