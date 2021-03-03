import java.util.Scanner;

public class ExerciseSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter A: ");
        short a = scanner.nextShort();
        short b, c;

        do{
            System.out.print("Enter B: ");
            b = scanner.nextShort();

            System.out.print("Enter C: ");
            c = scanner.nextShort();
        }while (b > 7 && c > 7);


    }
}