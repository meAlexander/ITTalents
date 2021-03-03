public class ExerciseFive {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int sumRows = 0;
        int tempSumRows = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                sumRows += arr[row][col];
            }

            if (tempSumRows < sumRows) {
                tempSumRows = sumRows;
            }
            sumRows = 0;
        }

        int sumCols = 0;
        int tempSumCols = 0;
        for (int col = 0; col < arr.length; col++) {
            for (int row = 0; row < arr[col].length; row++) {
                sumCols += arr[row][col];
            }

            if (tempSumCols < sumCols) {
                tempSumCols = sumCols;
            }
            sumCols = 0;
        }

        System.out.println("Max sum in row: " + tempSumRows);
        System.out.println("Max sum in col: " + tempSumCols);

        if (tempSumRows > tempSumCols) {
            System.out.println("Max sum in row is > than max sum in cols.");
        } else if (tempSumRows < tempSumCols) {
            System.out.println("Max sum in row is < than max sum in cols.");
        } else {
            System.out.println("Max sum in row is = max sum in cols.");
        }
    }
}