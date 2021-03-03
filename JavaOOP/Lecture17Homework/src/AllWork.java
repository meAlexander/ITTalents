import java.util.Arrays;

public class AllWork {
    private Task[] tasks;
    private int freePlacesForTasks;
    private int currentUnassignedTask;
    private int position = 0;

    public AllWork(int currentUnassignedTask) {
        this.tasks = new Task[10];
        this.freePlacesForTasks = 10;
        this.currentUnassignedTask = currentUnassignedTask;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public void addTask(Task task){
        if(freePlacesForTasks > 0){
            if(Arrays.asList(tasks).contains(task)){
                System.out.println("This task is already added!");
                return;
            }
            tasks[position++] = task;
            freePlacesForTasks--;
        }else{
            System.out.println("No more tasks can be accepted!");
        }
    }

    public Task getNextTask() {
        if (currentUnassignedTask < 10) {
            if(tasks[currentUnassignedTask].getWorkingHours() > 0) {
                return tasks[currentUnassignedTask++];
            }else {
                getNextTask();
            }
        }
        return null;
    }

    public boolean isAllWorkDone(){
        boolean flag = true;

        for (Task task : tasks) {
            if (task != null) {
                if (task.getWorkingHours() != 0) {
                    flag = false;
                }
            }
        }
        return flag;
    }
}