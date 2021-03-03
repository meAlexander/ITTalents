import java.util.Scanner;

public class ExerciseNineteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a number(10-99) and see the result.");
        int firstNumber;

        do{
            System.out.print("Enter a number: ");
            firstNumber = scanner.nextInt();
        }while (firstNumber < 10 || firstNumber > 99);

        while (firstNumber != 1){
            if(firstNumber % 2 != 0){
                firstNumber = firstNumber * 3 + 1;
            }else{
                firstNumber /= 2;
            }
            System.out.print(firstNumber + " ");
        }
    }
}