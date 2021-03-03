import java.util.Scanner;

public class Season5Test2Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int attempts = 0;

        while (true){
            System.out.print("Result from first dice: ");
            int a = scanner.nextInt();

            System.out.print("Result from second dice: ");
            int b = scanner.nextInt();

            if(a >= 7 || a <= 0 || b >= 7 || b <= 0){
                System.out.println("Impossible dice results(only 1 to 6)");
                continue;
            }
            attempts++;
            int result = a + b;

            if(result == 7){
                counter++;
                if(counter == 3){
                    System.out.println("Congratulation. You achieve seven consecutive sums of value '7'.");
                    System.out.println("Total tries you have done to achieve this result: " + attempts);
                    break;
                }
            }else {
                counter = 0;
            }
        }
    }
}