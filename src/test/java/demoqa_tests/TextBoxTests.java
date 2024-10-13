package demoqa_tests;

import demoqa.data.MockDataGenerator;
import org.testng.annotations.Test;

public class TextBoxTests extends BaseTest {


//    @Test
//    void testTextBox()  {
//        driver.get("https://demoqa.com/text-box");
//        demoqaPages.getTextBoxPage().inputUserName("John Doe")
//                .inputUserEmail("john.doe@mail.com")
//                .inputCurrentAddress("Wall street 123")
//                .inputPermanentAddress("Some permanent")
//                .submit();
//
//
//    }

    @Test
    void testTextBox2() throws InterruptedException {
        driver.get("https://demoqa.com/text-box");
        demoqaPages.getTextBoxPage().fillTextBoxForm(MockDataGenerator.randomTextBox());
        Thread.sleep(3000);
    }

}
