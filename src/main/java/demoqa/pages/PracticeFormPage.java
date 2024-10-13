package demoqa.pages;

import demoqa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormPage extends BasePage {



    public PracticeFormPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(xpath = "//label[@for='gender-radio-1']") // Пол можно выбрать через радиокнопку
    public WebElement male;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    public WebElement female;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    public WebElement other;

    @FindBy(id = "userNumber")
    public WebElement phoneNumber;

    @FindBy(className = "react-datepicker__input-container") // Календарь для выбора даты рождения
    public WebElement dateOfBirthInput;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']") // Календарь для выбора даты рождения
    public WebElement monthSelectField;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']") // Календарь для выбора даты рождения
    public WebElement yearSelectField;

    @FindBy(id = "subjectsInput")
    public WebElement subjects;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    public WebElement sports;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    public WebElement reading;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    public WebElement music;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPictureBtn;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    public WebElement currentAddress;

    @FindBy(xpath = "//div[contains(text(), 'Select State')]") // Например, выбор штата
    public WebElement stateSelection;

    @FindBy(xpath = "//div[contains(text(), 'Select City')]") // Например, выбор города
    public WebElement citySelection;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    public PracticeFormPage inputFirstName(String firstName) {
        webElementActions.scrollToElement(this.firstName);
        webElementActions.input(this.firstName, firstName);
        return this;
    }

    public PracticeFormPage inputLastName(String lastName) {
        webElementActions.scrollToElement(this.lastName);
        webElementActions.input(this.lastName, lastName);
        return this;
    }

    public PracticeFormPage inputUserEmail(String userEmail) {
        webElementActions.input(this.userEmail, userEmail);
        return this;
    }


    public PracticeFormPage selectGender(String gender) {
        switch (gender.toLowerCase()) {
            case "male":
                webElementActions.navigateToElement(male);
                webElementActions.click(male);
                break;
            case "female":
                webElementActions.navigateToElement(female);
                webElementActions.click(female);
                break;
            case "other":
                webElementActions.navigateToElement(other);
                webElementActions.click(other);
                break;
            default:
                throw new IllegalArgumentException("Choose a valid gender");
        }
        return this;
    }


    public PracticeFormPage inputUserPhoneNumber(String userPhoneNumber) {
        webElementActions.input(this.phoneNumber, userPhoneNumber);

        return this;
    }


    public PracticeFormPage selectBirthDate(String year, String month, String day) throws InterruptedException {
        webElementActions.click(dateOfBirthInput);
        Select selectMonth = new Select(monthSelectField);
        Select selectYear = new Select(yearSelectField);
        selectMonth.selectByVisibleText(month);
        selectYear.selectByValue(year);
        WebElement dayOfBirth = DriverManager.getDriver().findElement(By.xpath(chooseDate(day)));
        webElementActions.click(dayOfBirth);
        Thread.sleep(5000);
        return this;

    }

    private String chooseDate(String day){
        if (Integer.parseInt(day) < 10){
            String adjustedDay = "0".concat(day);
            return String.format("//div[contains(@class, 'day--0%s')]", adjustedDay);
        }
        return String.format("//div[contains(@class, 'day--0%s')]", day);
    }

    public PracticeFormPage inputSubject(String... subject) {
        webElementActions.navigateToElement(subjects);
        webElementActions.click(subjects);
        for (String s : subject) {
            subjects.sendKeys(s);
            subjects.sendKeys(Keys.ENTER);
        }
        return this;
    }

    public PracticeFormPage selectHobbies(int... index){
        for (int i : index){
            switch (i){
                case 1:
                    webElementActions.navigateToElement(sports);
                    webElementActions.click(sports);
                    break;
                case 2:
                    webElementActions.navigateToElement(reading);
                    webElementActions.click(reading);
                    break;
                case 3:
                    webElementActions.navigateToElement(music);
                    webElementActions.click(music);
                    break;
                default:
                    throw new IllegalArgumentException("Select a valid hobby");
            }
        }
        return this;
    }

    public PracticeFormPage uploadPicture(){
        String path = "D:\\Spring2024\\GitSpring2024\\Selenium\\src\\main\\resources\\images\\Godzilla.jpg";
        webElementActions.input(uploadPictureBtn, path);
        return this;
    }

    public PracticeFormPage inputCurrentAddress(String currentAddress){
        webElementActions.scrollToElement(this.currentAddress);
        webElementActions.input(this.currentAddress, currentAddress);
        return this;
    }

    public PracticeFormPage selectStateAndCity(int stateIndex, int cityIndex) throws InterruptedException {
        webElementActions.navigateToElement(stateSelection);
        webElementActions.click(stateSelection);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectState(stateIndex))));
        state.click();
        webElementActions.navigateToElement(citySelection);
        webElementActions.click(citySelection);
        WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectCity(selectState(stateIndex), cityIndex))));
        city.click();
        Thread.sleep(1000);
        return this;
    }

    private String selectState(int stateIndex){
        return switch (stateIndex){
            case 1 -> "//div[contains(text(), 'NCR')]";
            case 2 -> "//div[contains(text(), 'Uttar Pradesh')]";
            case 3 -> "//div[contains(text(), 'Haryana')]";
            case 4 -> "//div[contains(text(), 'Rajasthan')]";
            default -> throw new IllegalArgumentException("Select a valid state");
        };
    }

    private String selectCity(String state, int cityIndex){
        String stateFormated = state.substring(state.indexOf("'") + 1, state.lastIndexOf("'")).toLowerCase();
        switch (stateFormated){
            case "ncr":
                return getNcrCity(cityIndex);
            case "uttar pradesh":
                return getUttarCity(cityIndex);
            case "haryana":
                return cityIndex == 1 ? "//div[contains(text(), 'Karnal')]" : "//div[contains(text(), 'Panipat')]";
            case "rajasthan":
                return cityIndex == 1 ? "//div[contains(text(), 'Jaipur')]" : "//div[contains(text(), 'Jaiselmer')]";
            default:
                throw new IllegalArgumentException("There is no such city in the Uttar Pradesh state(choose one of these: Arga, Lucknow, Merrut)");
         }
    }

    private static String getUttarCity (int cityIndex){
        return switch (cityIndex){
            case 1 -> "//div[contains(text(), 'Arga')]";
            case 2 -> "//div[contains(text(), 'Lucknow')]";
            case 3 -> "//div[contains(text(), 'Merrut')]";
            default ->
                throw new IllegalArgumentException("There is no such city in the Uttar Pradesh state(choose one of these: Arga, Lucknow, Merrut)");

        };
    }
    private static String getNcrCity (int cityIndex){
        return switch (cityIndex){
            case 1 -> "//div[contains(text(), 'Delhi')]";
            case 2 -> "//div[contains(text(), 'Gurgaon')]";
            case 3 -> "//div[contains(text(), 'Noida')]";
            default ->
                    throw new IllegalArgumentException("There is no such city in the Uttar Pradesh state(choose one of these: Arga, Lucknow, Merrut)");

        };
    }



    public PracticeFormPage submit() throws InterruptedException {
        Thread.sleep(3000);
        webElementActions.click(submitBtn);
        return this;
    }

}




