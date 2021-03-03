public class Employee {
    private String name;
    private Task currentTask;
    private int hoursLeft;
    protected static AllWork allWork;

    public Employee(String name) {
        setName(name);
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        } else {
            System.out.println("Name is not valid!");
        }
    }

    public AllWork getAllWork() {
        return allWork;
    }

    public void setCurrentTask(Task currentTask) {
        if (currentTask != null && currentTask.getWorkingHours() > 0) {
            this.currentTask = currentTask;
        }
    }

    public void work() {
        if (this.currentTask.getWorkingHours() > 0) {
            while (this.hoursLeft > 0) {
                showReport();
                if (this.currentTask.getWorkingHours() > this.hoursLeft) {
                    this.currentTask.updateTask(this.hoursLeft);
                    this.hoursLeft = 0;
                } else {
                    this.hoursLeft -= this.currentTask.getWorkingHours();
                    this.currentTask.doneTask();

                    showReport();
                    Task newTask = allWork.getNextTask();
                    if (newTask == null) {
                        return;
                    }
                    this.setCurrentTask(newTask);
                }
            }
            showReport();
        }
    }

    public void startWorkDay() {
        this.hoursLeft = 8;
    }

    public void showReport() {
        if (this.currentTask != null) {
            if (this.currentTask.getName() != null && this.name != null) {
                System.out.println("Employee: " + this.name +
                        ", Task: " + this.currentTask.getName() +
                        ", Hours left for employee: " + this.hoursLeft +
                        ", Hours left for task to be done: " + this.currentTask.getWorkingHours());
            }
        }
    }
}