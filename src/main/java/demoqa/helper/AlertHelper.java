package demoqa.helper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public AlertHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public Alert getAlert(){
        return driver.switchTo().alert();
    }

    public boolean isAlertPresent(){
        return getAlert()!=null; // можно короткий метод так или длинный чере try
//        try{
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e){
//            return false;
//        }
    }

    public void acceptAlert(){
        wait.//new WebDriverWait(driver, Duration.ofSeconds(10))
                until(ExpectedConditions.alertIsPresent());
        if (!isAlertPresent()){
            return;
        }
        getAlert().accept();
    }

    public void dismissAlert(){ // для отклонения Алерта точнее объявления
        wait.until(ExpectedConditions.alertIsPresent());
        if (!isAlertPresent()){
            return;
        }
        getAlert().dismiss();
    }

    public void sendKeysAlert(String text){
        wait.until(ExpectedConditions.alertIsPresent());
        if (!isAlertPresent()){
            return;
        }
        getAlert().sendKeys(text);
    }
}
