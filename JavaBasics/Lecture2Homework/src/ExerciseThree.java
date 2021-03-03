import java.util.Scanner;

public class ExerciseThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter two numbers and exchange their values!");

        System.out.print("Enter number one: ");
        double numberOne = scanner.nextDouble();

        System.out.print("Enter number two: ");
        double numberTwo = scanner.nextDouble();

        System.out.println("Exchanging their values....");

        double tempNumberOne = numberOne;
        numberOne = numberTwo;
        numberTwo = tempNumberOne;

        System.out.println("Number one after exchange: " + numberOne);
        System.out.println("Number two after exchange: " + numberTwo);
    }
}