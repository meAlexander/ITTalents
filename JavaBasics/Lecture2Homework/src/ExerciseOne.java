import java.util.Scanner;

public class ExerciseOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter two numbers and check if third number is between them!");

        System.out.print("Enter number one:");
        double numberOne = scanner.nextDouble();

        System.out.print("Enter number two:");
        double numberTwo = scanner.nextDouble();

        System.out.print("Enter number three:");
        double numberThree = scanner.nextDouble();

        if((numberThree > numberOne && numberThree < numberTwo) || (numberThree < numberOne && numberThree > numberTwo)){
            System.out.println("The number " + numberThree + " IS between " + numberOne + " and " + numberTwo);
        }else{
            System.out.println("The number " + numberThree + " IS NOT between " + numberOne + " and " + numberTwo);
        }
    }
}