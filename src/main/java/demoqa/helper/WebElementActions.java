package demoqa.helper;

import demoqa.drivers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementActions {

    Actions actions = new Actions(DriverManager.getDriver());

    public WebElementActions click(WebElement element){
        element.click();
        return this;
    }

    public WebElementActions input(WebElement element, String txt){
        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        element.sendKeys(txt);
        return this;
    }

    public WebElementActions navigateToElement(WebElement element){
        actions.moveToElement(element).build().perform();
        return this;
    }

    public WebElementActions scrollToElement(WebElement element){
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }


    public WebElementActions jsClick(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);
        return this;
    }

    public WebElementActions waitElementToBeVisible(WebElement element){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15) )
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions waitElementToBeClickable(WebElement element){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15) )
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public String getTextFromElement(WebElement element){
        waitElementToBeVisible(element);
        return element.getText();

    }

    public WebElementActions doubleClick(WebElement element){
        waitElementToBeClickable(element);
        actions.doubleClick(element).build().perform();
        return this;
    }

    public WebElementActions rightClick (WebElement element){
        waitElementToBeClickable(element);
        actions.contextClick(element).build().perform();
        return this;
    }

    public WebElementActions clickMe(WebElement element){
        waitElementToBeClickable(element);
        actions.click(element).build().perform();
        return this;
    }

//    public WebElementActions waitElementToBeClickAble(WebElement element){
//        FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
//                .withTimeout(Duration.ofSeconds(30))
//                .pollingEvery(Duration.ofSeconds(5))
//                .ignoring(NoSuchElementException.class);
//
//        WebElement element = wait.until(driver1 -> driver1.findElement(By.id("elementId")) );
//        element.click();
//        driver.quit();
//    }

}
