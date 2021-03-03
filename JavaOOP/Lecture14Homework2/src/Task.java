public class Task {
    private String name;
    private int workingHours;

    public Task(String name, int workingHours) {
        setName(name);

        if (workingHours > 0) {
            this.workingHours = workingHours;
        } else {
            System.out.println("Min time for task to be done is 1 hour.");
        }
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
        if (workingHours >= 0) {
            this.workingHours = workingHours;
        } else {
            System.out.println("Min time for task to be done is 1 hour.");
        }
    }
}