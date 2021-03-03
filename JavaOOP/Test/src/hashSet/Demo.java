package hashSet;

public class Demo {
    public static void main(String[] args) {
        Test test = new Test();
        test.fillInEmployee();

        System.out.println("==========View all employee ordered by salary========");
        test.viewAllEmployee();

        System.out.println("==========View different employee salaries========");
        test.viewDifferentEmployeeSalaries();

        System.out.println("==========View first poorest employee========");
        test.getFirstPoorestEmployee();

        System.out.println("==========View first richest employee========");
        test.getFirstRichestEmployee();

        System.out.println("==========View all richest employee========");
        test.viewTheRichestEmployees();

        System.out.println("==========View all poorest employee========");
        test.viewThePoorestEmployees();

        System.out.println("==========View all employees ordered by name========");
        test.viewAllEmployeesOrderByName();
    }
}