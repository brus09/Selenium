package demoqa.data;

import com.github.javafaker.Faker;
import demoqa.entities.TextBox;
import demoqa.entities.WebTables;

public class MockDataGenerator {

    private static Faker faker = new Faker();

    public static String randomFullName(){
        return faker.name().fullName();
    }

    public static String randomEmail(){
        return faker.internet().emailAddress();
    }

    public static String randomAddress(){
        return faker.address().fullAddress();
    }

    public static TextBox randomTextBox(){
        String fullName = randomFullName();
        String email = randomEmail();
        String currentAddress = randomAddress();
        String permanenAddress = randomAddress();
        TextBox textBox = new TextBox(fullName, email, currentAddress, permanenAddress);
        return textBox;
    }

    public static String randomFirstName(){
        return faker.name().firstName();
    }

    public static String randomLastName(){
        return faker.name().lastName();
    }

    public static String randomEmailWeb(){
        return faker.internet().emailAddress();
    }

    public static String randomAge(){
        return String.valueOf(faker.number().numberBetween(18, 65));
    }

    public static String randomSalary(){
        return String.valueOf(faker.number().numberBetween(30000, 150000));
    }

    public static String randomDepartment(){
        return faker.commerce().department();
    }

    public static WebTables randomWebTables(){
        String firstName = randomFirstName();
        String lastName = randomLastName();
        String email = randomEmailWeb();
        String age = randomAge();
        String salary = randomSalary();
        String department = randomDepartment();
        WebTables webTables = new WebTables(firstName, lastName, email, age, salary, department);
        return webTables;
    }


}
