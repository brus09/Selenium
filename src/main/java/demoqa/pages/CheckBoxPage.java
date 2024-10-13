package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends BasePage{

    @FindBy(css = "label[for='tree-node-home']")
    public WebElement homeCheckBox;

    @FindBy(css = "label[for='tree-node-desktop']")
    public WebElement desktopCheckBox;

    @FindBy(css = "label[for='tree-node-documents']")
    public WebElement documentsCheckBox;

    @FindBy(css = "label[for='tree-node-downloads']")
    public WebElement downloadsCheckBox;

    @FindBy(css = "button[title='Toggle']")
    public WebElement expandAllButton;

    @FindBy(id = "result")
    public WebElement result;

    public CheckBoxPage clickHomeCheckBox() {
        webElementActions.click(this.homeCheckBox);
        return this;
    }

    public CheckBoxPage clickDesktopCheckBox() {
        webElementActions.click(this.desktopCheckBox);
        return this;
    }

    public CheckBoxPage clickDocumentsCheckBox() {
        webElementActions.click(this.documentsCheckBox);
        return this;
    }

    public CheckBoxPage clickDownloadsCheckBox() {
        webElementActions.click(this.downloadsCheckBox);
        return this;
    }

    public CheckBoxPage expandAll() {
        webElementActions.click(this.expandAllButton);
        return this;
    }

    public String getResult() {
        return webElementActions.getTextFromElement(this.result);
    }
}
