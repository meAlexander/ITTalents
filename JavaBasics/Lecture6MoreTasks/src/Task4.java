public class Task4 {
    public static void main(String[] args) {
        int[][] matrix = {
                {11, 17, 4, 10},
                {29, 4, 18, 18},
                {22, 14, 5, 5},
                {1, 27, 1, 11},
                {25, 2, 27, 6},
                {21, 24, 2, 3}
        };
        int rowsAndCols;
        if(matrix.length > matrix[0].length){
            rowsAndCols = matrix.length;
        }else{
            rowsAndCols = matrix[0].length;
        }

        int[][] newSquareMatrix = new int[rowsAndCols][rowsAndCols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                newSquareMatrix[row][col] = matrix[row][col];
            }
        }

        for(int[] row : newSquareMatrix){
            for(int element : row){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}