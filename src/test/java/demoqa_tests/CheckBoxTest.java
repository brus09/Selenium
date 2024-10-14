package demoqa_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest{


    @Test(groups = {"API", "TC-17"})
    public void testSelectHomeCheckBox() throws InterruptedException {

        helper.getBrowserManager().openURL("https://demoqa.com/checkbox");
        demoqaPages.checkBoxPage.clickHomeCheckBox(); // Кликаем по чекбоксу "Home"
        Thread.sleep(3000);
        String result = demoqaPages.checkBoxPage.getResult();
        Thread.sleep(3000);
        Assert.assertTrue(result.contains("home"), "Проверка, что выбрано 'home'");
    }

    @Test
    public void testSelectDesktopCheckBox() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/checkbox");
        demoqaPages.checkBoxPage.expandAll(); // Разворачиваем все ветки дерева
        Thread.sleep(3000);
        demoqaPages.checkBoxPage.clickDesktopCheckBox(); // Кликаем по чекбоксу "Desktop"
        Thread.sleep(3000);
        String result = demoqaPages.checkBoxPage.getResult();
        Assert.assertTrue(result.contains("desktop"), "Проверка, что выбрано 'desktop'");
    }

    @Test
    public void testSelectDocumentsCheckBox() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/checkbox");
        demoqaPages.checkBoxPage.expandAll();
        Thread.sleep(3000);
        demoqaPages.checkBoxPage.clickDocumentsCheckBox(); // Кликаем по чекбоксу "Documents"
        Thread.sleep(3000);
        String result = demoqaPages.checkBoxPage.getResult();
        String expectedResult = "You have selected :\ndocuments\nworkspace\nreact\nangular\nveu\noffice\npublic\nprivate\nclassified\ngeneral";

        Assert.assertEquals(result, expectedResult, "Проверка, что выбрано 'documents' и все дочерние элементы");
       // Assert.assertTrue(result.contains("documents"), "Проверка, что выбрано 'documents'");
    }

    @Test
    public void testSelectDownloadsCheckBox() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/checkbox");
        demoqaPages.getCheckBoxPage().expandAll();
        Thread.sleep(3000);
        demoqaPages.getCheckBoxPage().clickDownloadsCheckBox(); // Кликаем по чекбоксу "Downloads"
        Thread.sleep(3000);
        String result = demoqaPages.getCheckBoxPage().getResult();
        Assert.assertTrue(result.contains("downloads"), "Проверка, что выбрано 'downloads'");
    }

    @Test
    public void testExpandAllAndSelectMultiple() throws InterruptedException {
        helper.getBrowserManager().openURL("https://demoqa.com/checkbox");
        demoqaPages.getCheckBoxPage().expandAll(); // Разворачиваем все ветки дерева
        Thread.sleep(3000);
        demoqaPages.getCheckBoxPage().clickHomeCheckBox(); // Выбираем несколько чекбоксов
        Thread.sleep(3000);
        demoqaPages.getCheckBoxPage().clickDesktopCheckBox();
        Thread.sleep(3000);

        String result = demoqaPages.getCheckBoxPage().getResult();
        Assert.assertTrue(result.contains("documents"), "Проверка, что выбрано 'documents'");
        Assert.assertTrue(result.contains("downloads"), "Проверка, что выбрано 'downloads'");
    }
}
