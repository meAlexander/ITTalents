import java.util.Scanner;

public class ExerciseSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a number bigger than 0 and see first N numbers divided into 3.");
        int number;

        do {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
        }while(number < 1);

        int n = 0;
        for (int i = 0; i < number; i++) {
            n += 3;
            System.out.print(n + " ");
        }
    }
}