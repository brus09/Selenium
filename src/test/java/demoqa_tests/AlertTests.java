package demoqa_tests;

import org.testng.annotations.Test;

public class AlertTests extends BaseTest{

    @Test
    void alertTest() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/alerts");
        webElementActions.click(demoqaPages.getAlertPAge().alertButton);
        Thread.sleep(3000);
        helper.getAlertHelper().acceptAlert();
        Thread.sleep(3000);
    }

    @Test
    void alertTest1() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/alerts");
        webElementActions.click(demoqaPages.getAlertPAge().timerAlertButton);
        Thread.sleep(8000);
        helper.getAlertHelper().acceptAlert();
        Thread.sleep(3000);
    }

    @Test
    void alertTest2() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/alerts");
        webElementActions.click(demoqaPages.getAlertPAge().confirmButton);
        Thread.sleep(3000);
        //alertHelper.dismissAlert();
       helper.alertHelper.acceptAlert();
        Thread.sleep(3000);
    }

    @Test
    void alertTest3() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/alerts");
        webElementActions.click(demoqaPages.getAlertPAge().promtButton);
        Thread.sleep(3000);
        //alertHelper.dismissAlert();
        helper.alertHelper.acceptAlert();
        Thread.sleep(3000);
    }
}
