import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter columns: ");
        int cols = scanner.nextInt();

        int[][] arr = new int[rows][cols];
        int counter = 1;
        int row = 0;
        int col = 0;
        int tempRow = 0;
        int tempCol = 0;
        for (int cell = 0; cell < rows*cols; cell++) {
            arr[row][col] = counter++;
            row--;
            col++;
            if(row < 0 || col == cols){
                tempRow++;
                if (tempRow == rows){
                    tempRow--;
                    tempCol++;
                }
                row = tempRow;
                col = tempCol;
            }
        }

        for (int[] elements : arr) {
            for (int element : elements) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}