package demoqa.pages;

import demoqa.data.MockDataGenerator;
import demoqa.drivers.DriverManager;
import demoqa.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    WebElementActions webElementActions = new WebElementActions();
    MockDataGenerator mockDataGenerator = new MockDataGenerator();

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}
