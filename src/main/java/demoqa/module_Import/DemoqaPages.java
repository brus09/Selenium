package demoqa.module_Import;

import demoqa.pages.*;

public class DemoqaPages {

    public TextBoxPage textBoxPage;
    public ButtonsPage buttonsPage;
    public BrowserWindowsPage browserWindowsPage;
    public AlertPAge alertPAge;
    public SelectMenuPage selectMenuPage;
    public FramesPage framesPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;
    public WebTablesPage webTablesPage;


    public DemoqaPages() {

        textBoxPage = new TextBoxPage();
        buttonsPage = new ButtonsPage();
        browserWindowsPage = new BrowserWindowsPage();
        alertPAge = new AlertPAge();
        selectMenuPage = new SelectMenuPage();
        framesPage = new FramesPage();
        checkBoxPage = new CheckBoxPage();
        radioButtonPage = new RadioButtonPage();
        webTablesPage = new WebTablesPage();


    }

    public TextBoxPage getTextBoxPage() {
        return textBoxPage;
    }

    public ButtonsPage getButtonsPage() {
        return buttonsPage;
    }

    public BrowserWindowsPage getBrowserWindowsPage() {
        return browserWindowsPage;
    }

    public AlertPAge getAlertPAge() {
        return alertPAge;
    }

    public SelectMenuPage getSelectMenuPage() {
        return selectMenuPage;
    }

    public FramesPage getFramesPage() {
        return framesPage;
    }

    public CheckBoxPage getCheckBoxPage() {
        return checkBoxPage;
    }

    public RadioButtonPage getRadioButtonPage() {
        return radioButtonPage;
    }

    public WebTablesPage getWebTablesPage() {
        return webTablesPage;
    }
}
