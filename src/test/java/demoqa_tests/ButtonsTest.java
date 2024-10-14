package demoqa_tests;

import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Test(groups = {"API", "TC-16"})
    void testButtons() throws InterruptedException {
        driver.get("https://demoqa.com/buttons");
        webElementActions.doubleClick(demoqaPages.getButtonsPage().doubleClickButton);
        Thread.sleep(4000);

        webElementActions.rightClick(demoqaPages.getButtonsPage().rightClickButton);
        Thread.sleep(4000);
        webElementActions.clickMe(demoqaPages.getButtonsPage().clickMeButton);
        Thread.sleep(4000);
    }
}
