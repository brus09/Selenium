package advancedLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class XpathDemo {
    @Test
    void absoluteXpathDemoText() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Thread.sleep(6000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[5]/div/button"));
    }
    @Test
            void relativeDemoText() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://demoqa.com/date-picker");
//
//        WebElement submitBtn = driver.findElement(By.xpath("//button[@id='submit']"));
//        WebElement submitBtn1 = driver.findElement(By.xpath("//button[@type='button' and text()='Submit']"));
//        WebElement submitBtn2 = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
//        WebElement submitBtn3 = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
//        WebElement submitBtn4 = driver.findElement(By.xpath("//input[@placeholder='Full Name' and @type='text' or @id='userName']"));
//        WebElement submitBtn5 = driver.findElement(By.xpath("//*[@placeholder='Full Name']"));
//        WebElement submitBtn6 = driver.findElement(By.xpath("//div[@id='output']/div/p[@id='currentAddress']"));
//        WebElement submitBtn7 = driver.findElement(By.xpath("//p[@id='currentAddress']"));
//        WebElement submitBtn8 = driver.findElement(By.xpath("//h1[text()='Text Box']"));
//        WebElement submitBtn9 = driver.findElement(By.xpath("//h1[contains(text(),'Text')]"));
//        WebElement submitBtn10 = driver.findElement(By.xpath("//h3[contains(text(),'Фаиза / Faiza')]"));
//        WebElement submitBtn11 = driver.findElement(By.xpath("//h3[normalize-space()='Фаиза / Faiza']"));
//        WebElement submitBtn12 = driver.findElement(By.xpath("//span[starts-with(text(),'Перед')]"));
//        WebElement submitBtn13 = driver.findElement(By.xpath("//input[starts-with(@id,'userE')]"));
//        WebElement submitBtn14 = driver.findElement(By.xpath("//div[@id='brandsRefinements']/ul[1]/span/span[position()=3]"));
//        WebElement submitBtn15 = driver.findElement(By.xpath("//div[@id='brandsRefinements']/ul[1]/span/span[position()=4]"));
//        WebElement submitBtn16 = driver.findElement(By.xpath("//div[@id='brandsRefinements']/ul[1]/span/span[last()]"));
//        WebElement submitBtn17 = driver.findElement(By.xpath("//span[round(text())='999']")); //999.99 --> 1000
//        WebElement submitBtn18 = driver.findElement(By.xpath("//span[floor(text())='999']")); //999.99 --> 999


//        WebElement calendar = driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day react-datepicker__day') and not(contains(@class, 'react-datepicker__day--outside-month')) ]"));

        WebElement dateInput = driver.findElement(By.id("dateAndTimePickerInput"));
        dateInput.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__day")));
        String octoberDaysXPath = "//div[contains(@class, 'react-datepicker__day react-datepicker__day') and not(contains(@class, 'react-datepicker__day--outside-month')) ]";


        List<WebElement> octoberDays = driver.findElements(By.xpath(octoberDaysXPath));

        // Проверяем, что были выбраны все 31 день октября
        Assert.assertEquals(octoberDays.size(), 31, "Должно быть выбрано 31 день октября.");

        // Дополнительно можно вывести каждый найденный день
        for (WebElement day : octoberDays) {
            System.out.println( day.getText() + " - октября ");

            Thread.sleep(1000);
        }
        driver.close();
    }

 }

