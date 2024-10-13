package demoqa_tests;

import org.testng.annotations.Test;

public class FramesTest extends BaseTest{

    @Test
    void testFrames(){
        helper.getBrowserManager().openURL("https://demoqa.com/frames");
        helper.getiFrameHelper().switchToIFrame(demoqaPages.getFramesPage().frame1);//переключились на фрейм Вложенный html
        System.out.println(webElementActions.getTextFromElement(demoqaPages.getFramesPage().sampleHeading)); // здесь вытащили текст
        helper.getiFrameHelper().switchToDefaultFrame(); // переключились на родителья фреймов
        System.out.println(webElementActions.getTextFromElement(demoqaPages.getFramesPage().textCenter)); // вытащили оттуда текст
        helper.getiFrameHelper().switchToFrameByIndex(2); // по индексу переключились на фторой фрейм
        System.out.println(webElementActions.getTextFromElement(demoqaPages.getFramesPage().sampleHeading)); // оттуда вытащили его текст
    }
}
