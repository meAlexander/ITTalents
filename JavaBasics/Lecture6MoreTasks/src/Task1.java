public class Task1 {
    public static void main(String[] args) {
        int[][] matrix = {
                {16,3,2,13},
                {5,10,11,8},
                {9,6,7,12},
                {4,15,14,1}
        };
        int sumCols = 0;
        int sumRows = 0;
        int sumMainDiagonal = 0;
        int sumSecondDiagonal = 0;
        boolean isRowsAndColsAreEqualsToDiagonals = true;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row == col){
                    sumMainDiagonal += matrix[row][col];
                }
                if(row + col == 3){
                    sumSecondDiagonal += matrix[row][col];
                }
            }
        }
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                sumCols += matrix[row][col];
                sumRows += matrix[col][row];
            }
            if(!(sumCols == sumMainDiagonal) || !(sumRows == sumSecondDiagonal)){
                isRowsAndColsAreEqualsToDiagonals = false;
            }
            if(!(sumRows == sumMainDiagonal) || !(sumCols == sumSecondDiagonal)){
                isRowsAndColsAreEqualsToDiagonals = false;
            }
            sumCols = 0;
            sumRows = 0;
        }

        if(isRowsAndColsAreEqualsToDiagonals){
            System.out.println("A Magic square.");
        }else{
            System.out.println("Not a magic square.");
        }
    }
}