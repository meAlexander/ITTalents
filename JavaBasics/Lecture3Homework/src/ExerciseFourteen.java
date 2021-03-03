import java.util.Scanner;

public class ExerciseFourteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a number(10-200) and see all natural numbers smaller than entered from console divided into 7.");
        int number;

        do{
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
        }while (number < 10 || number > 200);

        for (int i = number; i >= 10; i--) {
            if(i % 7 == 0){
                System.out.print(i + " ");
            }
        }
    }
}