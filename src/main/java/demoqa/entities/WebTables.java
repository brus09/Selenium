package demoqa.entities;

import java.util.Objects;

public class WebTables {
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;

    public WebTables(String firstName, String lastName, String email, String age, String salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebTables webTables = (WebTables) o;
        return salary == webTables.salary && Objects.equals(firstName, webTables.firstName) && Objects.equals(lastName, webTables.lastName) && Objects.equals(email, webTables.email) && Objects.equals(department, webTables.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, salary, department);
    }

    @Override
    public String toString() {
        return "WebTables{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
