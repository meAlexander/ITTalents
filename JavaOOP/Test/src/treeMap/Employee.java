package treeMap;

import java.time.LocalDate;

public class Employee extends Person {
    public Employee(String name, double salary, LocalDate birthdayDate) {
        super(name, salary, birthdayDate);
    }

    public void updateSalaryWithTenPercent() {
        super.setSalary(super.getSalary() * 1.1);
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + super.getName() + '\'' +
                ", salary=" + super.getSalary() +
                ", birthdayDate=" + super.getBirthdayDate() +
                "}\n";
    }
}