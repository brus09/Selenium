package demoqa_tests;

import demoqa.data.MockDataGenerator;
import demoqa.entities.WebTables;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest{

    @Test
    void testAddNewRecord() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        demoqaPages.webTablesPage.fillFormWithData(MockDataGenerator.randomWebTables());
        Thread.sleep(5000);

    }

    @Test
    public void testEditRecord() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        // Данные для редактирования записи
        WebTables editedRecord = new WebTables("Bernard", "Vegas", "Berra@example.com", "39", "10000", "Insurance");

        // Редактировать первую запись (индекс 1)
        demoqaPages.webTablesPage.editRecordAtIndex(3, editedRecord);
        Thread.sleep(5000);
        // Проверить, что данные были успешно изменены
//
    }

    @Test
    public void testDeleteRecord() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        // Удалить первую запись (индекс 1)
        demoqaPages.webTablesPage.deleteRecordAtIndex(1);
        Thread.sleep(5000);

    }

}
