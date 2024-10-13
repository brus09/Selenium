package demoqa_tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest{

    @Test
    public void testSelectYesRadio() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/radio-button");
        demoqaPages.getRadioButtonPage().clickYesRadio(); // Кликаем по радиокнопке "Yes"
        Thread.sleep(3000);
        String result = demoqaPages.getRadioButtonPage().getResultText();

        Assert.assertEquals(result, "Yes", "Проверка, что выбрано 'Yes'");
    }

    @Test
    public void testSelectImpressiveRadio() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/radio-button");
        demoqaPages.getRadioButtonPage().clickImpressiveRadio(); // Кликаем по радиокнопке "Impressive"
        Thread.sleep(3000);
        String result = demoqaPages.getRadioButtonPage().getResultText();

        Assert.assertEquals(result, "Impressive", "Проверка, что выбрано 'Impressive'");
    }

    @Test
    public void testSelectNoRadio() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/radio-button");

        boolean isDisabled = demoqaPages.getRadioButtonPage().isNoRadioDisabled();
        Thread.sleep(3000);
        Assert.assertTrue(isDisabled, "Проверка, что радиокнопка 'No' недоступна для выбора");

    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
