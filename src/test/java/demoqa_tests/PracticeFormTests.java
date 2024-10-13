package demoqa_tests;

import demoqa.drivers.DriverManager;
import demoqa.pages.PracticeFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class PracticeFormTests {

    WebDriver driver = DriverManager.getDriver();
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void testPracticeForm() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        practiceFormPage.inputFirstName("Ron")
                .inputLastName("Shon")
                .inputUserEmail("ron-shon@mail.com")
                .selectGender("male")
                .inputUserPhoneNumber("0777000777")
                .selectBirthDate("1990", "June", "10")
                .inputSubject("Maths", "Economics", "Computer")
                .selectHobbies(1,2)
                .uploadPicture()
                .inputCurrentAddress("Wall street")
                .selectStateAndCity(2, 2)
                .submit();

        Thread.sleep(2000);
       // driver.close();
        WebElement resultName = driver.findElement(By.xpath("//td[text()='Student Name']/following-sibling::td"));
        WebElement resultEmail = driver.findElement(By.xpath("//td[text()='Student Email']/following-sibling::td"));
        WebElement resultGender = driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td"));
        WebElement resultMobile = driver.findElement(By.xpath("//td[text()='Mobile']/following-sibling::td"));
        WebElement resultDateOfBirth = driver.findElement(By.xpath("//td[text()='Date of Birth']/following-sibling::td"));
        WebElement resultSubjects = driver.findElement(By.xpath("//td[text()='Subjects']/following-sibling::td"));
        WebElement resultHobbies = driver.findElement(By.xpath("//td[text()='Hobbies']/following-sibling::td"));
        WebElement resultPicture = driver.findElement(By.xpath("//td[text()='Picture']/following-sibling::td"));
        WebElement resultAddress = driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td"));
        WebElement resultStateAndCity = driver.findElement(By.xpath("//td[text()='State and City']/following-sibling::td"));
        Thread.sleep(4000);
        Assert.assertEquals(resultName.getText(), "Ron Shon");
        Assert.assertEquals(resultEmail.getText(), "ron-shon@mail.com");
        Assert.assertEquals(resultGender.getText(), "Male");
        Assert.assertEquals(resultMobile.getText(), "0777000777");
        Assert.assertEquals(resultDateOfBirth.getText(), "10 June,1990");
        Assert.assertEquals(resultSubjects.getText(), "Maths, Economics, Computer Science");
        Assert.assertEquals(resultHobbies.getText(), "Sports, Reading");
        Assert.assertEquals(resultPicture.getText(), "Godzilla.jpg");
        Assert.assertEquals(resultAddress.getText(), "Wall street");
        Assert.assertEquals(resultStateAndCity.getText(), "Uttar Pradesh Lucknow");
    }

    @AfterTest
    void tearDown(){
        driver.quit();
    }
}
