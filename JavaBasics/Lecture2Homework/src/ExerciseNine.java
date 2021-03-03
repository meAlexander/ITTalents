import java.util.Scanner;

public class ExerciseNine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter two two digit number between 10 and 99!");

        System.out.print("Enter number one: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Enter number two: ");
        int secondNumber = scanner.nextInt();

        if((firstNumber < 10 || firstNumber > 99) || (secondNumber < 10 || secondNumber > 99)){
            System.out.println("Your number is out of the boundary!");
        }else {
            int multiplication = firstNumber * secondNumber;
            int lastDigitOfMultiplication = multiplication % 10;

            System.out.println("Multiplication result: " + multiplication +
                               "\nLast digit of multiplication: " + lastDigitOfMultiplication);

            if(lastDigitOfMultiplication % 2 == 0){
                System.out.println("Last digit of multiplication is: even");
            }else{
                System.out.println("Last digit of multiplication is: odd");
            }
        }
    }
}