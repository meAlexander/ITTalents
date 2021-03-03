import java.util.Scanner;

public class ExerciseTwelve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("All natural three digit numbers without repeating digits.");

        for (int i = 103; i <= 908; i++) {
            int firstDigit = i / 100;
            int secondDigit = (i / 10) % 10;
            int thirdDigit = i % 10;

            if (firstDigit == secondDigit || firstDigit == thirdDigit || secondDigit == thirdDigit){
                continue;
            }else{
                System.out.print(i + " ");
            }
        }
    }
}