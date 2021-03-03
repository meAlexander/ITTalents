package treeMap;

import java.time.LocalDate;

public class Boss extends Person{
    public Boss(String name, double salary, LocalDate birthdayDate) {
        super(name, salary, birthdayDate);
    }

    @Override
    public String toString() {
        return "\n----Boss{" +
                "bossName='" + super.getName() + '\'' +
                ", salary=" + super.getSalary() +
                ", birthdayDate=" + super.getBirthdayDate() +
                "}";
    }
}