package Exercise1;

public class Computer {
    int year;
    double price;
    boolean isNotebook;
    int hardDiskMemory;
    int freeMemory;
    String operationSystem;

    public void changeOperationSystem(String newOperationSystem){
        operationSystem = newOperationSystem;
    }

    public void useMemory(int memory){
        if(freeMemory < memory){
            System.out.println("Not enough memory!");
            return;
        }
        freeMemory -= memory;
    }

    public void computerInfo(){
        System.out.println("Computer information: " +
                year + ", " +
                price + ", " +
                hardDiskMemory + ", " +
                freeMemory + ", " +
                operationSystem + ", " +
                isNotebook);
    }
}