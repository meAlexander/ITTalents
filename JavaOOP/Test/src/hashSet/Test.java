package hashSet;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Test {
    private final HashSet<Employee> employees = new HashSet<>();

    public void fillInEmployee() {
        Employee employee1 = new Employee("Pesho", 800);
        Employee employee2 = new Employee("Tosho", 500);
        Employee employee3 = new Employee("Vasko", 1500);
        Employee employee4 = new Employee("Mitko", 2500);
        Employee employee5 = new Employee("Mitko", 2600);
        Employee employee6 = new Employee("Gosho", 2600);
        Employee employee7 = new Employee("Alex", 500);
        Employee employee8 = new Employee("Gosho", 2600);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);
    }

    public void viewAllEmployee() {
        employees.forEach(System.out::println);
    }

    public void getFirstRichestEmployee(){
        Employee richest = employees.stream()
                .max((e1, e2) -> e1.getSalary() - e2.getSalary()).orElse(null);
        System.out.println(richest);
    }

    public void getFirstPoorestEmployee(){
        Employee poorest = employees.stream()
                .min(Comparator.comparingInt(Employee::getSalary)).orElse(null);
        System.out.println(poorest);
    }

    public void viewTheRichestEmployees() {
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getSalary,
                        TreeMap::new,
                        Collectors.toCollection(HashSet::new)
                ))
                .lastEntry()
                .getValue()
                .forEach(System.out::println);
    }

    public void viewThePoorestEmployees() {
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getSalary,
                        TreeMap::new,
                        Collectors.toList()
                ))
                .firstEntry()
                .getValue()
                .forEach(System.out::println);
    }

    public void viewDifferentEmployeeSalaries() {
        employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .forEach(System.out::println);
    }

    public void viewAllEmployeesOrderByName(){
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}