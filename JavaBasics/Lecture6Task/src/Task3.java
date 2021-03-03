public class Task3 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 23, 5, 5},
                {4, 2, 55, 3},
                {6, 2, 11, 33}
        };

        int maxElementOnRow = 0;
        for (int row = 0; row < matrix.length; row++) {
            maxElementOnRow = matrix[row][0];
            for (int col = 0; col < matrix[row].length; col++) {
                if(maxElementOnRow < matrix[row][col]){
                    maxElementOnRow = matrix[row][col];
                }
            }
            System.out.println("Max element on row " + row + " is " + maxElementOnRow);
        }
    }
}