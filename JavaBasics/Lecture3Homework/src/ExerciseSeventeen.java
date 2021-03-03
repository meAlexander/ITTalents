import java.util.Scanner;

public class ExerciseSeventeen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a number(3-20) and a symbol and see the square.");
        int number;

        System.out.print("Enter a symbol: ");
        char symbol = scanner.next().charAt(0);

        do {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
        }while(number < 3 || number > 20);

        for (int row = 0; row < number - 1; row++) {
            //make first and last row
            if (row == 0 || row == number - 2) {
                for (int col = 0; col < number; col++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            if (row == number - 2) {
                break;
            }
            //make the square inside
            for (int col = 0; col < number; col++) {
                if (col == 0 || col == number - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(symbol);
                }
            }
            System.out.println();
        }
    }
}