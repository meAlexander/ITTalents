import java.util.Scanner;

public class ExerciseThree {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        System.out.print("Enter A: ");
        int a = scanner.nextInt();

        System.out.print("Enter B: ");
        int b = scanner.nextInt();

        if (a > b){
            int tempA = a;
            a = b;
            b = tempA;
        }

        for (int i = a; i <= b; i++) {
            if(i % 3 == 0){
                System.out.print(i + " ");
            }
        }
    }
}