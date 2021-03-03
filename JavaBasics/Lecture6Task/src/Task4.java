public class Task4 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 23, 5, 5, 9},
                {4, 55, 3, 2, 7, 13, 19},
                {6, 2, 11, 33, 12}
        };

        int counter = 0;
        int tempCounter = 0;
        int tempRow = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] % 2 != 0){
                    counter++;
                }
            }
            if(tempCounter < counter){
                tempCounter = counter;
                tempRow = row;
            }
            counter = 0;
        }

        System.out.println("First Row with most odd numbers is " + tempRow +
                            " row with " + tempCounter + " odd numbers");
    }
}