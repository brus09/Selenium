package demoqa.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class FirefoxWebDriver {


    // Путь к файлу firefox.exe



      public static WebDriver loadFirefoxDriver (){
          FirefoxOptions options = new FirefoxOptions();
          options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
          WebDriver driver = new FirefoxDriver(options);
          System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");//
        // WebDriver driver = new FirefoxDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            return driver;
        }

}
