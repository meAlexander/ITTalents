package tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Company {
    private final String companyName;
    private final HashMap<String, HashSet<Employee>> departmentEmployees;

    public final static String SORT_BY_NAME = "name";
    public final static String SORT_BY_SALARY = "salary";
    public final static String SORT_BY_AGE = "age";

    public Company(String companyName) {
        this.companyName = companyName;
        this.departmentEmployees = new HashMap<>();
    }

    public void addEmployeeToDepartment(String departmentName, Employee employee) {
        if (!departmentEmployees.containsKey(departmentName)) {
            departmentEmployees.put(departmentName, new HashSet<>());
        }
        departmentEmployees.get(departmentName).add(employee);
    }

    public void sortEmployeesBy(String compare) {
        System.out.println("=====Sorted by " + compare + "=======");
        HashSet<Employee> employeeHashSet = new HashSet<>();
//        for(HashSet<Employee> a1 : departmentEmployees.values()){
//            employeeHashSet.addAll(a1);
//        }

        employeeHashSet = departmentEmployees.values()
                .stream()
                .flatMap(Set::stream)
                .collect(Collectors.toCollection(HashSet::new));

        Comparator<Employee> employeeComparator = Comparator
                .comparing(Employee::getID);
        switch (compare) {
            case SORT_BY_AGE:
                employeeComparator = Comparator.comparing(Employee::getAge);
                break;
            case SORT_BY_NAME:
                employeeComparator = Comparator.comparing(Employee::getName);
                break;
            case SORT_BY_SALARY:
                employeeComparator = Comparator.comparing(Employee::getSalary);
                break;
        }

        employeeHashSet.stream()
                .sorted(employeeComparator)
                .forEach(System.out::println);
    }

    public void viewAllEmployeesByDepartment(String department) {
        departmentEmployees.entrySet()
                .stream()
                .filter(e -> e.getKey().equals(department))
                .map(Map.Entry::getValue)
                .flatMap(Set::stream)
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public void setSalariesForSpecificMonth(int month) {
        departmentEmployees.values()
                .stream()
                .filter(e -> month == 12)
                .flatMap(Set::stream)
                .forEach(Employee::updateSalaryWithTenPercent);

        departmentEmployees.values()
                .forEach(e->e.forEach(System.out::println));
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + this.companyName + '\'' +
                ",\ndepartmentEmployees=" + this.departmentEmployees +
                "}";
    }
}