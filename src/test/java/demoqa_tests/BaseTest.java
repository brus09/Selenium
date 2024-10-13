package demoqa_tests;

import demoqa.drivers.DriverManager;
import demoqa.helper.WebElementActions;
import demoqa.module_Import.DemoqaPages;
import demoqa.module_Import.ImportHelpers;
import demoqa.pages.Amazon;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    public WebElementActions webElementActions;
public ImportHelpers helper;
    public DemoqaPages demoqaPages;
    public Amazon amazon;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = DriverManager.getDriver();
        webElementActions = new WebElementActions();
        helper = new ImportHelpers(driver);
        demoqaPages = new DemoqaPages();
        amazon = new Amazon(driver);
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverManager.closeDriver();
    }
}
