public class Employee extends Person {
    private double daySalary;

    public Employee(){

    }
    public Employee(String name, int age, boolean isMale, double daySalary) {
        super(name, age, isMale);
        this.daySalary = daySalary;
    }

    public double calculateOvertime(double hours) {
        if (getAge() < 18) {
            return daySalary;
        } else {
            return daySalary * 1.5 * hours;
        }
    }

    public void showEmployeeInfo() {
        showPersonInfo();
        System.out.println("Day salary: " + daySalary);
    }
}
