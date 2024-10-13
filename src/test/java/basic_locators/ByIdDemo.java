package basic_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class ByIdDemo {
    @Test
            void byIdTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Thread.sleep(6000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInput = driver.findElement(By.id("userName"));
        fullNameInput.sendKeys("John Doe");

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("john1.doe@gmail.com");

        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        currentAddressInput.sendKeys("Wall street 123");

        WebElement permanentAddressInput = driver.findElement(By.id("permanentAddress"));
        permanentAddressInput.sendKeys("Some street 123");

        WebElement submitBtn = driver.findElement(By.id("submit"));
       // WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
       // submitBtn.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(submitBtn).perform();
        submitBtn.click();

        Thread.sleep(2000);


        String responseName = driver.findElement(By.id("name")).getText();
        Assert.assertTrue(responseName.contains("John Doe"));

        String responseEmail = driver.findElement(By.id("email")).getText();
        Assert.assertTrue(responseEmail.contains("john1.doe@gmail.com"));


        String currentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        Assert.assertTrue(currentAddress.contains("Wall street 123"));

        String permanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();
        Assert.assertTrue(permanentAddress.contains("Some street 123"));
//        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
//        String responseCurrentAddress = currentAddressElement.getText();
//        System.out.println("Actual text: " + responseCurrentAddress);
//        Assert.assertEquals(responseCurrentAddress, "Wall street 123");



//        String responseCurrentAddress = driver.findElement(By.id("currentAddress")).getText();
//        System.out.println("Actual text: " + responseCurrentAddress);
//        Assert.assertEquals(responseCurrentAddress, "Wall street 123");
       // Assert.assertTrue(responseCurrentAddress.contains("Wall street 123"));
//
//        String responsePermanentAddress = driver.findElement(By.id("permanentAddress")).getText();
//        Assert.assertTrue(responsePermanentAddress.contains("Some street 123"));
        //Assert.assertEquals(responseName.getText(), "John Doe");
//        driver.close();
//        driver.quit();

    }

}
