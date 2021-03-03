public class Employee {
    private String name;
    private Task currentTask;
    private int hoursLeft;

    public Employee(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public int getHoursLeft() {
        return hoursLeft;
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        }else{
            System.out.println("Name is not valid!");
        }
    }

    public void setCurrentTask(Task currentTask) {
        if (currentTask != null) {
            this.currentTask = currentTask;
        }
    }

    public void setHoursLeft(int hoursLeft) {
        if (hoursLeft > 0 && hoursLeft < 25) {
            this.hoursLeft = hoursLeft;
        }
    }

    public void work() {
        if (currentTask != null) {
            if (currentTask.getName() != null && name != null) {
                if (currentTask.getWorkingHours() >= hoursLeft) {
                    currentTask.setWorkingHours(currentTask.getWorkingHours() - hoursLeft);
                    hoursLeft = 0;
                } else {
                    hoursLeft -= currentTask.getWorkingHours();
                    currentTask.setWorkingHours(0);
                }
            } else {
                System.out.println("Invalid data for current task or employee!");
            }
        } else {
            System.out.println("No current task!");
        }
    }

    public void showReport() {
        if (currentTask != null) {
            if (currentTask.getName() != null && name != null) {
                System.out.println("Employee: " + this.name +
                        ", Task name: " + this.currentTask.getName() +
                        ", Hours left for employee: " + hoursLeft +
                        ", Hours left for task to be done: " + this.currentTask.getWorkingHours());
            }
        }
    }
}