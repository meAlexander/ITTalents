package treeMap;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Person implements Comparable<Person>{
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
    public int compareTo(Person o) {
        if(getName().equals(o.getName())){
            if(getSalary() > o.getSalary()){
                return 1;
            }else if(getSalary() < o.getSalary()){
                return -1;
            }
            return 0;
        }
        if(getSalary() > o.getSalary()){
            return 1;
        }else if(getSalary() < o.getSalary()){
            return -1;
        }
        if(this.name.compareTo(o.name) > 0){
            return 1;
        }
        return -1;
    }
}