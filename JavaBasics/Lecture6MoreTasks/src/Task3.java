public class Task3 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        int tempSumRow = 0;
        int tempSumCol = 0;
        int sumRow = 0;
        int sumCol = 0;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                sumRow += matrix[col][row];
                sumCol += matrix[row][col];
            }
            if(tempSumRow < sumRow){
                tempSumRow = sumRow;
            }
            if(tempSumCol < sumCol){
                tempSumCol = sumCol;
            }
            sumRow = 0;
            sumCol = 0;
        }

        System.out.println("Max sum row: " + tempSumRow);
        System.out.println("Max sum col: " + tempSumCol);

        if(tempSumRow > tempSumCol){
            System.out.println("Max sum row is > than max sum col");
        }else if(tempSumRow < tempSumCol){
            System.out.println("Max sum row is < than max sum col");
        }else{
            System.out.println("Max sum row is = to max sum col");
        }
    }
}