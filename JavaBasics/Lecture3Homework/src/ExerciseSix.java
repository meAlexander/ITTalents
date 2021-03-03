import java.util.Scanner;

public class ExerciseSix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a number bigger than 1 and see sum of all number from 1 to it.");
        int sum = 0;
        int number;

        do{
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
        }while(number < 1);

        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        System.out.println("The sum is: " + sum);
    }
}