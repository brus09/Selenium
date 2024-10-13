package basic_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ByClassDemo {
    @Test
    void byClassDemoTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Thread.sleep(6000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/webtables");

        WebElement addNewRecord = driver.findElement(By.className("btn-primary"));
        addNewRecord.click();
        Thread.sleep(3000);
        driver.close();
    }
}
