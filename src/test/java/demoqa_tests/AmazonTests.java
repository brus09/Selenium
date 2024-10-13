package demoqa_tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AmazonTests extends BaseTest{

    @Test
    void amazonTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Переход на сайт Amazon
        driver.get("https://www.amazon.com/");

        // Ожидание загрузки и ввод текста в поле поиска
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.sendKeys("iPhone", Keys.ENTER);

        // Список брендов для выбора
        String[] brandsToSelect = {"Apple", "Motorola", "Google"};

        // Выбор брендов по очереди
        for (String brand : brandsToSelect) {
            selectBrand(wait, brand);
        }
    }

    private void selectBrand(WebDriverWait wait, String brandName) {
        try {
            // Ожидание загрузки списка брендов
            List<WebElement> brands = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//div[@id='brandsRefinements']/ul/span/span/li/span/a")));

            // Снятие галочек со всех предыдущих брендов
            for (WebElement brand : brands) {
                // Получаем родительский элемент, чтобы найти checkbox
                WebElement checkbox = brand.findElement(By.xpath("preceding-sibling::input"));
                if (checkbox.isSelected()) {
                    checkbox.click(); // Снимаем галочку
                }
            }

            // Найти и выбрать нужный бренд
            for (WebElement brand : brands) {
                if (brand.getText().equalsIgnoreCase(brandName)) {
                    WebElement checkbox = brand.findElement(By.xpath("preceding-sibling::input"));
                    checkbox.click(); // Выбрать бренд
                    wait.until(ExpectedConditions.stalenessOf(brand)); // Ожидание обновления страницы
                    break;
                }
            }

            // Ожидание загрузки результатов после выбора бренда
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class, 'a-size-medium a-color-base a-text-normal')]")));

            // Здесь можно добавить действия для выбора телефонов с именем бренда
            selectPhonesWithBrand(wait, brandName);

        } catch (NoSuchElementException e) {
            System.out.println("Бренд не найден: " + brandName);
        } catch (TimeoutException e) {
            System.out.println("Превышено время ожидания при выборе бренда: " + brandName);
        }
    }

    private void selectPhonesWithBrand(WebDriverWait wait, String brandName) {
        try {
            // Ожидание загрузки всех телефонов
            List<WebElement> phones = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//span[contains(@class, 'a-size-medium a-color-base a-text-normal') and contains(text(), '" + brandName + "')]")));

            // Выбор первых N телефонов (например, 5 для Apple и Motorola, 2 для Google)
            int numberOfPhonesToSelect = 5;
            if (brandName.equalsIgnoreCase("Google")) {
                numberOfPhonesToSelect = 2;
            }

            for (int i = 0; i < Math.min(numberOfPhonesToSelect, phones.size()); i++) {
                phones.get(i).click(); // Клик по каждому телефону
                // Возможно, вы хотите сделать паузу, чтобы подождать загрузки деталей
                Thread.sleep(2000); // Задержка для загрузки страницы телефона
                driver.navigate().back(); // Вернуться на страницу с результатами поиска
                // Ожидание повторной загрузки списка телефонов
                phones = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//span[contains(@class, 'a-size-medium a-color-base a-text-normal') and contains(text(), '" + brandName + "')]")));
            }
        } catch (NoSuchElementException e) {
            System.out.println("Телефоны с брендом " + brandName + " не найдены.");
        } catch (TimeoutException e) {
            System.out.println("Превышено время ожидания при выборе телефонов с брендом: " + brandName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//        driver.get("https://www.amazon.com/");
//        Thread.sleep(5000);
//        driver.findElement(By.id("twotabsearchtextbox"))
//                .sendKeys("Iphone", Keys.ENTER);
//        Thread.sleep(5000);
//
//
//
//        List<WebElement> brands = driver.findElements(By.xpath("//div[@id='brandsRefinements']/ul/span/span/li/span/a"));
//        for (int i = 0; i < brands.size(); i++) {
//            try {
//                brands = driver.findElements(By.xpath("//div[@id='brandsRefinements']/ul/span/span/li/span/a"));
//                if (i < brands.size()) {
//                    brands.get(i).click();
//                    Thread.sleep(3000);
//                    driver.navigate().refresh();
//                } else {
//                    System.out.println("Элемент с индексом " + i + " не найден после обновления.");
//                }
//            } catch (StaleElementReferenceException e) {
//                e.printStackTrace();
//                System.out.println("StaleElementReferenceException при работе с элементом с индексом " + i);
//            }
//        }
//    }}
