import java.util.Scanner;

public class Season5Test2Task4 {
    public static void main(String[] args) {
        fillMatrixWithStars(10);
    }

    private static void fillMatrixWithStars(int n) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[n][n];
        int count = 0;

        while (true) {
            System.out.println("Enter cell for '*'");
            System.out.print("Enter row: ");
            int row = scanner.nextInt();

            System.out.print("Enter col: ");
            int col = scanner.nextInt();

            if (row < 0 || row >= n || col < 0 || col >= n) {
                System.out.println("Coordinates does not exists");
                continue;
            }
            matrix[row][col] = '*';
            count++;

            if (count == 10) {
                break;
            }
        }

        fillMatrixWithNumbers(matrix);
    }

    private static void fillMatrixWithNumbers(char[][] matrix) {
        int count = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != '*') {
                    if (row == 0 && col == 0) {
                        if (matrix[row][col + 1] == '*') {
                            count++;
                        }
                        if (matrix[row + 1][col] == '*') {
                            count++;
                        }
                        if (matrix[row + 1][col + 1] == '*') {
                            count++;
                        }
                        if (count != 0) {
                            matrix[row][col] = (char) (count + '0');
                        }
                        count = 0;
                    } else if (row == 0 && col == matrix[row].length - 1) {
                        if (matrix[row][col - 1] == '*') {
                            count++;
                        }
                        if (matrix[row + 1][col - 1] == '*') {
                            count++;
                        }
                        if (matrix[row + 1][col] == '*') {
                            count++;
                        }
                        if (count != 0) {
                            matrix[row][col] = (char) (count + '0');
                        }
                    } else if (row == matrix.length - 1 && col == 0) {
                        if (matrix[row - 1][col] == '*') {
                            count++;
                        }
                        if (matrix[row - 1][col + 1] == '*') {
                            count++;
                        }
                        if (matrix[row][col + 1] == '*') {
                            count++;
                        }
                        if (count != 0) {
                            matrix[row][col] = (char) (count + '0');
                        }
                    } else if (row == matrix.length - 1 && col == matrix[row].length - 1) {
                        if (matrix[row - 1][col - 1] == '*') {
                            count++;
                        }
                        if (matrix[row - 1][col] == '*') {
                            count++;
                        }
                        if (matrix[row][col - 1] == '*') {
                            count++;
                        }
                        if (count != 0) {
                            matrix[row][col] = (char) (count + '0');
                        }
                    } else if (row == 0) {
                        if (matrix[row][col - 1] == '*') {
                            count++;
                        }
                        if (matrix[row][col + 1] == '*') {
                            count++;
                        }
                        if (matrix[row + 1][col - 1] == '*') {
                            count++;
                        }
                        if (matrix[row + 1][col] == '*') {
                            count++;
                        }
                        if (matrix[row + 1][col + 1] == '*') {
                            count++;
                        }
                        if (count != 0) {
                            matrix[row][col] = (char) (count + '0');
                        }
                    } else if (col == 0) {
                        if (matrix[row][col + 1] == '*') {
                            count++;
                        }
                        if (matrix[row - 1][col] == '*') {
                            count++;
                        }
                        if (matrix[row - 1][col + 1] == '*') {
                            count++;
                        }
                        if (matrix[row + 1][col] == '*') {
                            count++;
                        }
                        if (matrix[row + 1][col + 1] == '*') {
                            count++;
                        }
                        if (count != 0) {
                            matrix[row][col] = (char) (count + '0');
                        }
                    } else if (col == matrix[row].length - 1) {
                        if (matrix[row][col - 1] == '*') {
                            count++;
                        }
                        if (matrix[row - 1][col] == '*') {
                            count++;
                        }
                        if (matrix[row - 1][col - 1] == '*') {
                            count++;
                        }
                        if (matrix[row + 1][col] == '*') {
                            count++;
                        }
                        if (matrix[row + 1][col - 1] == '*') {
                            count++;
                        }
                        if (count != 0) {
                            matrix[row][col] = (char) (count + '0');
                        }
                    } else if (row == matrix.length - 1) {
                        if (matrix[row][col + 1] == '*') {
                            count++;
                        }
                        if (matrix[row][col - 1] == '*') {
                            count++;
                        }
                        if (matrix[row - 1][col] == '*') {
                            count++;
                        }
                        if (matrix[row - 1][col + 1] == '*') {
                            count++;
                        }
                        if (matrix[row - 1][col - 1] == '*') {
                            count++;
                        }
                        if (count != 0) {
                            matrix[row][col] = (char) (count + '0');
                        }
                    } else {
                        if (matrix[row][col + 1] == '*') {
                            count++;
                        }
                        if (matrix[row][col - 1] == '*') {
                            count++;
                        }
                        if (matrix[row - 1][col - 1] == '*') {
                            count++;
                        }
                        if (matrix[row - 1][col] == '*') {
                            count++;
                        }
                        if (matrix[row - 1][col + 1] == '*') {
                            count++;
                        }
                        if (matrix[row + 1][col - 1] == '*') {
                            count++;
                        }
                        if (matrix[row + 1][col] == '*') {
                            count++;
                        }
                        if (matrix[row + 1][col + 1] == '*') {
                            count++;
                        }
                        if (count != 0) {
                            matrix[row][col] = (char) (count + '0');
                        }
                    }
                }
                count = 0;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }
}