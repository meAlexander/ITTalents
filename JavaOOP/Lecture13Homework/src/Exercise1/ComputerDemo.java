package Exercise1;

public class ComputerDemo {
    public static void main(String[] args) {
        Computer computer1 = new Computer();
        Computer computer2 = new Computer();

        computer1.year = 2015;
        computer1.price = 1100;
        computer1.hardDiskMemory = 500;
        computer1.freeMemory = 495;
        computer1.operationSystem = "Windows";
        computer1.isNotebook = true;

        computer2.year = 2020;
        computer2.price = 1800;
        computer2.hardDiskMemory = 1000;
        computer2.freeMemory = 995;
        computer2.operationSystem = "Linux";
        computer2.isNotebook = false;

        computer2.useMemory(100);
        computer1.changeOperationSystem("Ubuntu");

        computer1.computerInfo();
        computer2.computerInfo();
    }
}