package demoqa.module_Import;

import demoqa.helper.AlertHelper;
import demoqa.helper.BrowserManager;
import demoqa.helper.DropdownHelper;
import org.openqa.selenium.WebDriver;

public class ImportHelpers {
    private WebDriver driver;
    public BrowserManager browserManager;
    public BrowserManager.WindowHelper windowHelper;
    public AlertHelper alertHelper;
    public DropdownHelper dropdownHelper;
    public BrowserManager.IFrameHelper iFrameHelper;

    public ImportHelpers(WebDriver driver) {
        browserManager = new BrowserManager(driver);
        windowHelper = new BrowserManager.WindowHelper(driver);
        alertHelper = new AlertHelper(driver);
        dropdownHelper = new DropdownHelper(driver);
        iFrameHelper = new BrowserManager.IFrameHelper(driver);
    }



    public BrowserManager getBrowserManager() {
        return browserManager;
    }

    public BrowserManager.WindowHelper getWindowHelper() {
        return windowHelper;
    }

    public AlertHelper getAlertHelper() {
        return alertHelper;
    }

    public DropdownHelper getDropdownHelper() {
        return dropdownHelper;
    }

    public BrowserManager.IFrameHelper getiFrameHelper() {
        return iFrameHelper;
    }
}
