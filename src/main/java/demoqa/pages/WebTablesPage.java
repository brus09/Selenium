package demoqa.pages;

import demoqa.entities.WebTables;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static demoqa.drivers.DriverManager.driver;

public class WebTablesPage extends BasePage {
    @FindBy(id = "addNewRecordButton")
    public WebElement addNewRecordButton;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement email;

    @FindBy(id = "age")
    public WebElement age;

    @FindBy(id = "salary")
    public WebElement salary;

    @FindBy(id = "department")
    public WebElement department;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @Step("Click Add New Record")
    public WebTablesPage clickAddNewRecord() {
        addNewRecordButton.click();
        return this;
    }

    @Step("Input First Name: {0}")
    public WebTablesPage inputFirstName(String firstName) {
        webElementActions.input(this.firstName, firstName);
        return this;
    }

    @Step("Input Last Name: {0}")
    public WebTablesPage inputLastName(String lastName) {
        webElementActions.input(this.lastName, lastName);
        return this;
    }

    @Step("Input Email: {0}")
    public WebTablesPage inputEmail(String email) {
        webElementActions.input(this.email, email);
        return this;
    }

    @Step("Input Age: {0}")
    public WebTablesPage inputAge(String age) {
        webElementActions.input(this.age, age);
        return this;
    }

    @Step("Input Salary: {0}")
    public WebTablesPage inputSalary(String salary) {
        webElementActions.input(this.salary, salary);
        return this;
    }

    @Step("Input Department: {0}")
    public WebTablesPage inputDepartment(String department) {
        webElementActions.input(this.department, department);
        return this;
    }

    @Step("Submit Form")
    public WebTablesPage submit() {
        submitButton.click();
        return this;
    }

    public WebTablesPage fillFormWithData(WebTables data) {
        clickAddNewRecord()
                .inputFirstName(data.getFirstName())
                .inputLastName(data.getLastName())
                .inputEmail(data.getEmail())
                .inputAge(data.getAge())
                .inputSalary(data.getSalary())
                .inputDepartment(data.getDepartment())
                .submit();
        return this;
    }
    // Локатор для кнопки редактирования на основе индекса строки
    @FindBy(xpath = "//div[@class='rt-tr-group'][{0}]//span[@title='Edit']")
    public WebElement editButton;

    // Локатор для кнопки удаления на основе индекса строки
    @FindBy(xpath = "//div[@class='rt-tr-group'][{0}]//span[@title='Delete']")
    public WebElement deleteButton;



    @Step("Click Edit Button for record at index: {0}")
    public WebTablesPage clickEditButton(int rowIndex) {
        WebElement editBtn = driver.findElement(By.xpath("//div[@class='rt-tr-group'][" + rowIndex + "]//span[@title='Edit']"));
        editBtn.click();
        return this;
    }

    @Step("Click Delete Button for record at index: {0}")
    public WebTablesPage clickDeleteButton(int rowIndex) {
        WebElement deleteBtn = driver.findElement(By.xpath("//div[@class='rt-tr-group'][" + rowIndex + "]//span[@title='Delete']"));
        deleteBtn.click();
        return this;
    }

    @Step("Edit record at index: {0}")
    public WebTablesPage editRecordAtIndex(int rowIndex, WebTables newData) {
        clickEditButton(rowIndex);

        // Очищаем каждое поле перед вводом новых данных
        this.firstName.clear();
        inputFirstName(newData.getFirstName());

        this.lastName.clear();
        inputLastName(newData.getLastName());

        this.email.clear();
        inputEmail(newData.getEmail());

        this.age.clear();
        inputAge(newData.getAge());

        this.salary.clear();
        inputSalary(newData.getSalary());

        this.department.clear();
        inputDepartment(newData.getDepartment());

        // Подтверждаем изменения
        submit();
        return this;
    }

    @Step("Delete record at index: {0}")
    public WebTablesPage deleteRecordAtIndex(int rowIndex) {
        clickDeleteButton(rowIndex);
        return this;
    }

}

