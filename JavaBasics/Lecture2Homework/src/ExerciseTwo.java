import java.util.Scanner;

public class ExerciseTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter two whole numbers and do arithmetic operations with them!");

        System.out.print("Enter number one: ");
        int numberOne = scanner.nextInt();

        System.out.print("Enter number two: ");
        int numberTwo = scanner.nextInt();

        int sum = numberOne + numberTwo;
        int difference = numberOne - numberTwo;
        int multiplication = numberOne * numberTwo;
        int remainderOfDivision = numberOne % numberTwo;
        int integerDivision = numberOne / numberTwo;

        System.out.println("\nSum: " + sum +
                           "\nDifference: " + difference +
                           "\nMultiplication: " + multiplication +
                           "\nRemainder of division: " + remainderOfDivision +
                           "\nInteger division: " + integerDivision);

        operationWithFloatingPoint(scanner);
    }

    public static void operationWithFloatingPoint(Scanner scanner){
        System.out.println("You have to enter two numbers with floating point and do arithmetic operations with them!");

        System.out.print("Enter number one: ");
        double numberOne = scanner.nextDouble();

        System.out.print("Enter number two: ");
        double numberTwo = scanner.nextDouble();

        double sum = numberOne + numberTwo;
        double difference = numberOne - numberTwo;
        double multiplication = numberOne * numberTwo;
        double remainderOfDivision = numberOne % numberTwo;
        double integerDivision = numberOne / numberTwo;

        System.out.println("\nSum: " + sum +
                           "\nDifference: " + difference +
                           "\nMultiplication: " + multiplication +
                           "\nRemainder of division: " + String.format("%.2f", remainderOfDivision) +
                           "\nInteger division: " + Math.floor(integerDivision));
    }
}