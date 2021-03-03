public class Task1 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 23, 5, 5},
                {4, 2, 55, 3},
                {6, 2, 11, 33}
        };

        int max = matrix[0][0];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(max < matrix[row][col]){
                    max = matrix[row][col];
                }
            }
        }
        System.out.println("Max element: " + max);
    }
}