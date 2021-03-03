package Exercise1;

public class ComputerDemo {
    public static void main(String[] args) {
        Computer computer1 = new Computer(2015, 2200, 500, 495);
        Computer computer2 = new Computer(2020, 2000, true, 1000, 995,"Linux");

        int result = computer1.comparePrice(computer2);

        if(result == 1){
            System.out.println("Computer 2 is more expensive.");
            computer2.computerInfo();
            computer1.computerInfo();
        }else if(result == -1){
            System.out.println("Computer 1 is more expensive");
            computer1.computerInfo();
            computer2.computerInfo();
        }else{
            System.out.println("Computers have equals price");
            computer1.computerInfo();
            computer2.computerInfo();
        }
    }
}
