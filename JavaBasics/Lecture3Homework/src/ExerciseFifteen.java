import java.util.Scanner;

public class ExerciseFifteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a number and see the sum from 1 to your number.");

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

//        int sum = 0;
//        for (int i = 1; i <= number; i++) {
//            sum += i;
//        }
//        System.out.println("The sum of numbers is: " + sum);

        int i = 1, sum = 0;
        do{
            sum += i;
            i++;
        }while (i <= number);
        System.out.println("The sum of numbers is: " + sum);
    }
}