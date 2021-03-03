import java.util.Scanner;

public class ExerciseTwentyFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a positive number and check factorial.");
        int number;

        do {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
        } while (number < 1);

        int originalNumber = number;
        int result = 1;

        do {
            result *= number--;
        } while (number != 0);

        System.out.println(originalNumber + " factorial is " + result);
    }
}
