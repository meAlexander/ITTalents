import java.util.Scanner;

public class ExerciseEight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a number bigger that 0 and see the table.");
        int number;

        do {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
        }while (number < 1);

        int tempValue = number - 1;
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number; col++) {
                System.out.print(tempValue + "");
            }
            System.out.println();
            tempValue += 2;
        }
    }
}