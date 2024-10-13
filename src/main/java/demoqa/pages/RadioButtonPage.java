package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButtonPage extends BasePage{
    @FindBy(css = "label[for='yesRadio']")
    public WebElement yesRadio;

    @FindBy(css = "label[for='impressiveRadio']")
    public WebElement impressiveRadio;

    @FindBy(id = "noRadio")
    public WebElement noRadioInput;

    @FindBy(css = ".text-success")
    public WebElement resultText;

    public RadioButtonPage clickYesRadio() {
        webElementActions.click(this.yesRadio);
        return this;
    }

    public RadioButtonPage clickImpressiveRadio() {
        webElementActions.click(this.impressiveRadio);
        return this;
    }

    public boolean isNoRadioDisabled() {
        return !noRadioInput.isEnabled();
    }

    public String getResultText() {
        return webElementActions.getTextFromElement(this.resultText);
    }
}

