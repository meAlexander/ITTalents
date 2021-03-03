import java.util.Arrays;

public class WorkingDemo {
    public static void main(String[] args) {
        Task task1 = new Task("Digging", 6);
        Task task2 = new Task("Cleaning", 16);
        Task task3 = new Task("Coding", 9);
        Task task4 = new Task("Studying", 12);
        Task task5 = new Task("Shopping", 8);
        Task task6 = new Task("Painting", 5);
        Task task7 = new Task("Planting", 13);
        Task task8 = new Task("Renovating", 11);
        Task task9 = new Task("Cooking", 4);
        Task task10 = new Task("Analyzing", 10);

        Employee employee1 = new Employee("Petar");
        Employee employee2 = new Employee("Ivan");
        Employee employee3 = new Employee("Todor");

        AllWork allWork = new AllWork(0);
        Employee.allWork = allWork;

        allWork.addTask(task1);
        allWork.addTask(task2);
        allWork.addTask(task3);
        allWork.addTask(task4);
        allWork.addTask(task5);
        allWork.addTask(task6);
        allWork.addTask(task7);
        allWork.addTask(task8);
        allWork.addTask(task9);
        allWork.addTask(task10);

        employee1.setCurrentTask(employee1.getAllWork().getNextTask());
        employee2.setCurrentTask(employee2.getAllWork().getNextTask());
        employee3.setCurrentTask(employee3.getAllWork().getNextTask());

        int days = 1;
        while (true){
            System.out.println("Start a new working day - " + days++);
            employee1.startWorkDay();
            employee2.startWorkDay();
            employee3.startWorkDay();

            employee1.work();
            employee2.work();
            employee3.work();

            if(allWork.isAllWorkDone()){
                System.out.println("All tasks are done!");
                break;
            }
        }

        for (Task task : allWork.getTasks()){
            System.out.println(task);
        }
    }
}