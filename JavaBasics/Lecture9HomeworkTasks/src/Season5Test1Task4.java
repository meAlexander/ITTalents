import java.util.Arrays;
import java.util.Scanner;

public class Season5Test1Task4 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'b', 'b', 'b', 'b', 'b', 'b'},
                {'b', 'b', ' ', ' ', ' ', 'b'},
                {'b', 'b', ' ', ' ', ' ', 'b'},
                {'b', 'b', 'b', 'b', ' ', 'b'},
                {'b', 'b', 'b', 'b', 'b', 'b'},
                {'b', 'b', 'b', 'b', 'b', 'b',}
        };

        paintBrush(matrix, 6, 5);
    }

    private static void paintBrush(char[][] matrix, int x, int y) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (x >= matrix.length || x < 0 || y >= matrix[0].length || y < 0 || matrix[x][y] == 'b') {
                System.out.println("Inappropriate coordinates");

                System.out.print("Enter new x: ");
                x = scanner.nextInt();

                System.out.print("Enter new y: ");
                y = scanner.nextInt();
            } else {
                break;
            }
        }
        matrix[x][y] = 'x';

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == ' ') {
                    matrix[row][col] = 'r';
                }
            }
        }
        //print matrix
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "  ");
            }
            System.out.println();
        }
    }
}