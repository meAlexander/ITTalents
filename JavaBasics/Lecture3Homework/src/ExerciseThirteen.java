import java.util.Scanner;

public class ExerciseThirteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("All natural three digit numbers with sum of digits equals to number enter from console.");

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if(number < 1 || number > 27){
            System.out.println("Your number is incorrect!");
        }else {
            for (int i = 100; i <= 999; i++) {
                int firstDigit = i / 100;
                int secondDigit = (i / 10) % 10;
                int thirdDigit = i % 10;

                int sum = firstDigit + secondDigit + thirdDigit;
                if (sum == number) {
                    System.out.print(i + " ");
                } else {
                    continue;
                }
            }
        }
    }
}