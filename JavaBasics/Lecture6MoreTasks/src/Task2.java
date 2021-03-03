public class Task2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        for (int col = 0; col < matrix.length; col++) {
            for (int row = matrix[col].length - 1; row >= 0; row--) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}