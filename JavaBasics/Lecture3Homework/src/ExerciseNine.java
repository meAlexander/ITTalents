import java.util.Scanner;

public class ExerciseNine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter two numbers and see all numbers between them except for numbers divided into 3.");
        int sum = 0;

        System.out.print("Enter a first number: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Enter a second number: ");
        int secondNumber = scanner.nextInt();

        if(firstNumber > secondNumber){
            int tempFirstNumber = firstNumber;
            firstNumber = secondNumber;
            secondNumber = tempFirstNumber;
        }

        for (int i = firstNumber; i <= secondNumber; i++) {
            if (i % 3 == 0) {
                System.out.println("skip " + i);
                continue;
            } else {
                sum += i;
                if(sum > 200){
                    System.out.println("\nThe sum of numbers(except for numbers divided into 3) became more that 200 and the program stop!");
                    break;
                }
                System.out.print(i + " ");
            }
        }
    }
}