package hashMap;

public class Demo {
    public static void main(String[] args) {
        Test test1 = new Test();
        test1.fillInBossEmployeeMap();

        System.out.println("=======View all bosses ordered by salary and their employees=======");
        test1.viewAllBossesAndEmployees();

        System.out.println("=======View all employees after salary increase=======");
        test1.updateAllEmployeeSalaries();
        test1.viewOnlyEmployees();

        System.out.println("=======View the richest Boss=======");
        test1.viewTheRichestBoss();

        System.out.println("=======View the poorest Boss=======");
        test1.viewThePoorestBoss();

        System.out.println("======View the poorest Employee=========");
        test1.viewThePoorestEmployee();

        System.out.println("======View the richest Employee=========");
        test1.viewTheRichestEmployee();

        System.out.println("======View the oldest Employee=========");
        test1.viewTheOldestEmployee();

        System.out.println("======View all Employee salaries=========");
        test1.viewAllSalaries();

//        System.out.println("==============");
//        test1.test();
    }
}