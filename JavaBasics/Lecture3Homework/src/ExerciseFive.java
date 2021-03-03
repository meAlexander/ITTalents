import java.util.Scanner;

public class ExerciseFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter two numbers and see all numbers between them.");

        System.out.print("Enter first number: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Enter second number: ");
        int secondNumber = scanner.nextInt();

        if(firstNumber > secondNumber){
            int tempFirstNumber = firstNumber;
            firstNumber = secondNumber;
            secondNumber = tempFirstNumber;
        }

        for (int i = firstNumber; i <= secondNumber; i++) {
            System.out.print(i + " ");
        }
    }
}