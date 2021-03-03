package tasks;

public class Demo {
    public static void main(String[] args) {
        Company company = new Company("Tesla");

        Employee employee1 = new Employee("Mitko", 25, 3800, 5);
        Employee employee2 = new Employee("Alex", 29, 2800, 6);
        Employee employee3 = new Employee("Bobi", 19, 1600, 9);

        company.addEmployeeToDepartment("IT", employee1);
        company.addEmployeeToDepartment("IT", employee2);
        company.addEmployeeToDepartment("Cleaner", employee3);

        company.sortEmployeesBy(Company.SORT_BY_AGE);
        company.sortEmployeesBy(Company.SORT_BY_SALARY);
        company.sortEmployeesBy(Company.SORT_BY_NAME);

        System.out.println("=====View employees by department=====");
        company.viewAllEmployeesByDepartment("Cleaner");

        System.out.println("=====View employee`s salary after month increase=====");
        company.setSalariesForSpecificMonth(12);
    }
}