import java.util.Scanner;

public class ExerciseEight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = scanner.nextInt();

        for (int times = 0; times < n; times++) {
            for (int row = times; row < n - 1; row++) {
                System.out.print(" ");
            }
            for (int col = 0; col < 2*times + 1; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int row = 0; row < n; row++) {
            //loop for spaces
            for (int spaces = row; spaces < n - 1; spaces++) {
                System.out.print(" ");
            }
            //loop for stars
            for (int stars = 0; stars < 2 * row + 1; stars++) {
                //check if row is not first or last
                if (row != 0 && row != n - 1){
                    //check if stars is not first or last
                    if (stars != 0 && stars != 2 * row){
                        System.out.print(" ");
                    }else{
                        System.out.print("*");
                    }
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}