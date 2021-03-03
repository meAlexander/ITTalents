import java.util.Scanner;

public class ExerciseSixteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter two numbers and see all number between them which are divided into 50.");
        int N;
        int M;

        do{
            System.out.print("Enter a first number: ");
            N = scanner.nextInt();

            System.out.print("Enter a second number: ");
            M = scanner.nextInt();
        }while(N < 10 || N > 5555 || M < 10 || M > 5555);

        if (N > M) {
            int tempM = M;
            M = N;
            N = tempM;
        }

        for (int i = M; i > N; i--) {
            if (i % 50 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}