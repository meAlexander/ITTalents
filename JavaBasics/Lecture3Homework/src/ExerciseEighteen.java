import java.util.Scanner;

public class ExerciseEighteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter two numbers(1-9) and see the multiplication table.");
        int firstNumber, secondNumber;
        do{
            System.out.print("Enter a first number: ");
            firstNumber = scanner.nextInt();

            System.out.print("Enter a second number: ");
            secondNumber = scanner.nextInt();
        }while(firstNumber < 1 || firstNumber > 9 || secondNumber < 1 || secondNumber > 9);

        for (int i = 1; i <= firstNumber; i++) {
            for (int j = 1; j <= secondNumber; j++) {
                System.out.println(i + "*" + j + "=" + (i * j));
            }
        }
    }
}