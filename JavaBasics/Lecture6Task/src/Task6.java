public class Task6 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 23, 5, 5, 9},
                {4, 55, 3, 2, 7, 13, 19},
                {6, 2, 11, 33, 12}
        };
        for (int row = 0; row < matrix.length; row++) {
            if (row % 2 == 0) {
                int min = matrix[row][0];
                for (int col = 1; col < matrix[row].length; col++) {
                    if (min > matrix[row][col]) {
                        min = matrix[row][col];
                    }
                }
                System.out.println("Min element on even row " + row + " is " + min);
            } else {
                int max = matrix[row][0];
                for (int col = 1; col < matrix[row].length; col++) {
                    if (max < matrix[row][col]) {
                        max = matrix[row][col];
                    }
                }
                System.out.println("Max element on odd row " + row + " is " + max);
            }
        }
    }
}