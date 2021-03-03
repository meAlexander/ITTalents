import java.util.Scanner;

public class ExerciseTwentyFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a number(10-30000) and check whether a number is a palindrome or not.");
        int number;

        do{
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
        }while(number < 10 || number > 30000);

        int reversedInteger = 0, digit, originalNumber;

        originalNumber = number;
        do{
            digit = number % 10;
            reversedInteger = reversedInteger * 10 + digit;
            number /= 10;
        }while(number != 0);

        if (reversedInteger == originalNumber){
            System.out.println("The number: " + originalNumber + " is a palindrome.");
        }else{
            System.out.println("The number: " + originalNumber + " is NOT a palindrome.");
        }
    }
}