package Exercise1;

public class Computer {
    int year;
    double price;
    boolean isNotebook;
    double hardDiskMemory;
    double freeMemory;
    String operationSystem;

    public Computer() {
        isNotebook = false;
        operationSystem = "Win XP";
    }

    public Computer(int year, double price, double hardDiskMemory, double freeMemory) {
        this();
        this.year = year;
        this.price = price;
        this.hardDiskMemory = hardDiskMemory;
        this.freeMemory = freeMemory;
    }

    public Computer(int year, double price, boolean isNotebook, double hardDiskMemory, double freeMemory, String operationSystem) {
        this.year = year;
        this.price = price;
        this.isNotebook = isNotebook;
        this.hardDiskMemory = hardDiskMemory;
        this.freeMemory = freeMemory;
        this.operationSystem = operationSystem;
    }

    public void changeOperationSystem(String newOperationSystem) {
        operationSystem = newOperationSystem;
    }

    int comparePrice(Computer c) {
        if (price > c.price) {
            return -1;
        } else if (price < c.price) {
            return 1;
        }
        return 0;
    }

    public void useMemory(int memory) {
        if (freeMemory < memory) {
            System.out.println("Not enough memory!");
            return;
        }
        freeMemory -= memory;
    }

    public void computerInfo() {
        System.out.println("Computer information: " +
                year + ", " + price + ", " +
                hardDiskMemory + ", " + freeMemory + ", " +
                operationSystem + ", " + isNotebook);
    }
}