package demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Amazon extends BasePage{
    private WebDriver driver;
    private String baseUrl = "https://www.amazon.com/s?k=iphone&crid=3DIHE9SPS9EPO&sprefix=iphon%2Caps%2C248&ref=nb_sb_noss_2";

    public Amazon(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для выбора чекбокса
    public void selectBrand(String brand) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement checkboxIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + brand + "']/preceding-sibling::div//i[contains(@class, 'a-icon-checkbox')]")));
            checkboxIcon.click();
        } catch (NoSuchElementException e) {
            System.out.println("Чекбокс для бренда " + brand + " не найден.");
        }
    }

    // Метод для проверки товаров по бренду
    public void checkProductNames(String brand) {
        try {
            List<WebElement> products = driver.findElements(By.className("product-class"));

            if (products.isEmpty()) {
                System.out.println("Нет доступных товаров для проверки.");
            } else {
                for (int i = 0; i < Math.min(5, products.size()); i++) {
                    WebElement product = products.get(i);
                    String brandName = product.findElement(By.className("brand-class")).getText();
                    System.out.println("Название бренда: " + brandName);
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка при проверке товаров: " + e.getMessage());
        }
    }

    // Метод для снятия чекбокса
    public void unselectBrand(String brand) {
        WebElement checkbox = driver.findElement(By.xpath("//span[text()='" + brand + "']/preceding-sibling::div//input"));
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/s?k=iphone&crid=3DIHE9SPS9EPO&sprefix=iphon%2Caps%2C248&ref=nb_sb_noss_2");

        Amazon test = new Amazon(driver);

        // Проверяем товары Apple
        test.selectBrand("Apple");
        test.checkProductNames("Apple");
        test.unselectBrand("Apple");

        // Проверяем товары OnePlus
        test.selectBrand("OnePlus");
        test.checkProductNames("OnePlus");
        test.unselectBrand("OnePlus");

        // Проверяем товары Nokia
        test.selectBrand("Nokia");
        test.checkProductNames("Nokia");
        test.unselectBrand("Nokia");

        driver.quit();
    }
}
