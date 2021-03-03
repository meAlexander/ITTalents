import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter columns: ");
        int cols = scanner.nextInt();

        int[][] arr = new int[rows][cols];
        int counter = 1;
        for (int col = 0; col < cols; col++) {
            if(col % 2 == 0){
                for (int row = 0; row < rows; row++) {
                    arr[row][col] = counter++;
                }
            }else{
                for (int row = rows - 1; row >= 0; row--) {
                    arr[row][col] = counter++;
                }
            }
        }

        for(int[] elements : arr){
            for(int element : elements){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}