package hashMap;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Person{
    private final String name;
    private double salary;
    private final LocalDate birthdayDate;

    public Person(String name, double salary, LocalDate birthdayDate) {
        this.name = name;
        this.salary = salary;
        this.birthdayDate = birthdayDate;
    }

    void setSalary(double salary) {
        this.salary = Double.parseDouble(new DecimalFormat(".##")
                .format(salary).replace(',', '.'));
    }

    public String getName() {
        return name;
    }
    public double getSalary() {
        return this.salary;
    }
    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}