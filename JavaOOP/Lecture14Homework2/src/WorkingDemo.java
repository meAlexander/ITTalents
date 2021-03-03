public class WorkingDemo {
    public static void main(String[] args) {
        Task task1 = new Task("Digging", 6);
        Employee employee = new Employee("Petar");

        employee.setCurrentTask(task1);

        employee.setHoursLeft(4);
        employee.work();
        employee.showReport();

        employee.setHoursLeft(9);
        employee.work();
        employee.showReport();

        task1.setWorkingHours(3);
        employee.setHoursLeft(5);
        employee.work();
        employee.showReport();

        task1.setWorkingHours(-2);
    }
}