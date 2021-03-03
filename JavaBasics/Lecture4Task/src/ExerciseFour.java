import java.util.Scanner;

public class ExerciseFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        int flag = 0;

        do{
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
        }while(number == 0 || number == 1);

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                System.out.println(number + " is not a prime number.");
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println(number + " is a prime number.");
        }


    }
}