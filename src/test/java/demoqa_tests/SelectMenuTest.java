package demoqa_tests;

import org.testng.annotations.Test;

import java.util.List;

import static demoqa.enums.OldStyleSelectMenuValues.GREEN;

public class SelectMenuTest extends BaseTest{

    @Test
    void selectMenuTest() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        helper.getDropdownHelper().selectByText(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, GREEN.getColors());
        Thread.sleep(3000);
        helper.getDropdownHelper().selectByIndex(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, 2);
        Thread.sleep(1000);
        helper.getDropdownHelper().selectByValue(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, "3");
        Thread.sleep(1000);
        helper.getDropdownHelper().selectByIndex(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, 4);
        Thread.sleep(1000);
        helper.getDropdownHelper().selectByIndex(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, 5);
        Thread.sleep(1000);
        helper.getDropdownHelper().selectByIndex(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, 6);
        Thread.sleep(1000);
        helper.getDropdownHelper().selectByIndex(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, 7);
        Thread.sleep(1000);
        helper.getDropdownHelper().selectByIndex(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, 8);
        Thread.sleep(1000);
        helper.getDropdownHelper().selectByIndex(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, 9);
        Thread.sleep(1000);
        helper.getDropdownHelper().selectByIndex(demoqaPages.getSelectMenuPage().oldStyleSelectMenu, 10);
        Thread.sleep(2000);
        List<String> colors = helper.getDropdownHelper().getAllDropdownValues(demoqaPages.getSelectMenuPage().oldStyleSelectMenu);
        for (String color : colors){
            System.out.println(color);
        }
        Thread.sleep(2000);
    }
}
