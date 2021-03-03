package treeSet;

public class Employee implements Comparable<Employee>{
    private final String name;
    private final int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        if(this.name.equals(o.name)){
            return this.salary - o.salary;
        }
        if(this.salary >= o.salary) {
            return 1;
        }
        return -1;
    }

    public Employee getEmployee(){
        return this;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "treeSet.Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
