package basic_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ByNameDemo {
    @Test
    public void demo1 () throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       // Thread.sleep(6000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.sendKeys("Admin");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        String expectedTitle = "Dashboard";
        WebElement title = driver.findElement(By.xpath("//h6"));
        //System.out.println(title);

        String actualTitle = title.getText();
        System.out.println(actualTitle);

        Assert.assertEquals(actualTitle,expectedTitle);
        Thread.sleep(4000);

        driver.close();
    }
}
