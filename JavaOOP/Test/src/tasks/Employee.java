package tasks;

import java.text.DecimalFormat;
import java.util.Objects;

public class Employee{
    private final String name;
    private final int age;
    private double salary;
    private final int ID;

    public Employee(String name, int age, double salary, int ID) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public int getAge() {
        return age;
    }
    public int getID() {
        return ID;
    }
    public void updateSalaryWithTenPercent(){
        this.salary = Double.parseDouble(new DecimalFormat(".##")
                    .format(this.salary*1.1).replace(',', '.'));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", ID=" + ID +
                "}";
    }
}