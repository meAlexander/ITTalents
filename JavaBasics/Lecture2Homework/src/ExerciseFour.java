import java.util.Scanner;

public class ExerciseFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter two numbers and order them in ascending order!");

        System.out.print("Enter number one: ");
        double numberOne = scanner.nextDouble();

        System.out.print("Enter number two: ");
        double numberTwo = scanner.nextDouble();

        System.out.println("Ordering numbers....");
        if (numberOne >= numberTwo){
            System.out.println(numberOne + "\n" + numberTwo);
        }else{
            System.out.println(numberTwo + "\n" + numberOne);
        }
    }
}