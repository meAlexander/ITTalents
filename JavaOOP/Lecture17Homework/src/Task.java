public class Task {
    private String name;
    private int workingHours;

    public Task(String name, int workingHours) {
        setName(name);
        setWorkingHours(workingHours);
    }

    public String getName() {
        return name;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        }else{
            System.out.println("Name is not valid!");
        }
    }

    public void setWorkingHours(int workingHours) {
        if (workingHours > 0) {
            this.workingHours = workingHours;
        } else {
            System.out.println("Min time for task to be done is 1 hour.");
        }
    }

    public void doneTask(){
        this.workingHours = 0;
    }

    public void updateTask(int hours){
        this.workingHours -= hours;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", workingHours=" + workingHours +
                '}';
    }
}