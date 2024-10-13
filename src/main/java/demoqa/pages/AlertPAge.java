package demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPAge extends BasePage{

    @FindBy(id="alertButton")
    public WebElement alertButton;

    @FindBy(id="timerAlertButton")
    public WebElement timerAlertButton;

    @FindBy(id="confirmButton")
    public WebElement confirmButton;

    @FindBy(id="promtButton")
    public WebElement promtButton;
}
