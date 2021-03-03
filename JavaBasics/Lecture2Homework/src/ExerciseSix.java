import java.util.Scanner;

public class ExerciseSix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter three numbers and exchange their values!");

        System.out.print("Enter number one: ");
        double a1 = scanner.nextDouble();

        System.out.print("Enter number two: ");
        double a2 = scanner.nextDouble();

        System.out.print("Enter number three: ");
        double a3 = scanner.nextDouble();

        double tempA1 = a1;

        a1 = a2;
        a2 = a3;
        a3 = tempA1;

        System.out.println("After exchange....");
        System.out.println("\na1 = " + a1 +
                           "\na2 = " + a2 +
                           "\na3 = " + a3);
    }
}