package basic_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PartialLinkTextDemo {
    @Test
    public void byLinkTextTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Thread.sleep(6000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/links");

        WebElement homeLink = driver.findElement(By.partialLinkText("Bad"));
        homeLink.click();

        String badRequestText = driver.findElement(By.xpath("//p/b[2]")).getText();
        Assert.assertTrue(badRequestText.equals("Bad Request"));
        Thread.sleep(3000);
        driver.close();
        //driver.quit();
    }
}
