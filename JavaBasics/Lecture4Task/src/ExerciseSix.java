import java.util.Scanner;

public class ExerciseSix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int binaryNumber = 0;
        int counter = 0;

        do{
            System.out.println("Enter positive number: ");
            n = scanner.nextInt();
        }while (n < 0);

        while (n > 0){
            int remainder = n % 2;
            if(remainder == 1){
                counter++;
            }
            binaryNumber = binaryNumber * 10 + remainder;
            n /= 2;
        }
        System.out.println(binaryNumber);
        System.out.println("<---------");
        System.out.println(counter + " 1 bits contains.");
    }
}