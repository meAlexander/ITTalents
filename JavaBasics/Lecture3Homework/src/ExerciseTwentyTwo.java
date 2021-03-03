import java.util.Scanner;

public class ExerciseTwentyTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a number and see first ten numbers bigger than your which are divided into 2, 3, 5.");

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int counter = 0;
        while (counter != 10){
            number++;
            if(number % 2 == 0 || number % 3 == 0 || number % 5 == 0){
                System.out.print(++counter + ":" + number + "  ");
            }
        }
    }
}