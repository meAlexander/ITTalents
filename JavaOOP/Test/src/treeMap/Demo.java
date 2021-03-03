package treeMap;

public class Demo {
    public static void main(String[] args) {
        Test test = new Test();
        test.fillInBossEmployeeMap();

        System.out.println("=======View all bosses ordered by salary and their employees=======");
        test.viewAllBossesAndEmployees();

        System.out.println("=======View all employees after salary increase=======");
        test.updateAllEmployeeSalaries();
        test.viewOnlyEmployees();

        System.out.println("=======View the richest Boss=======");
        test.viewTheRichestBoss();

        System.out.println("=======View the poorest Boss=======");
        test.viewThePoorestBoss();

        System.out.println("======View the poorest Employee=========");
        test.viewThePoorestEmployee();

        System.out.println("======View the richest Employee=========");
        test.viewTheRichestEmployee();

        System.out.println("======View the oldest Employee=========");
        test.viewTheOldestEmployee();

        System.out.println("======View all Employee salaries=========");
        test.viewAllSalaries();

        System.out.println("==============");
        test.test();
    }
}