import java.util.Scanner;

public class ExerciseTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of square 2D array: ");
        int size = scanner.nextInt();
        int[][] arr = new int[size][size];

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print("Enter value for element ["+row+"]["+col+"]: ");
                arr[row][col] = scanner.nextInt();
            }
        }

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(row == col){
                    System.out.print(arr[row][col] + " ");
                }
            }
        }
        System.out.println();
        for (int row = 0; row < arr.length; row++) {
            for (int col = arr[row].length - 1; col >= 0; col--) {
                if(row + col == 3){
                    System.out.print(arr[row][col] + " ");
                }
            }
        }
    }
}