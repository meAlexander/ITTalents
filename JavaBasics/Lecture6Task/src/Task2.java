public class Task2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 23, 5, 5},
                {4, 2, 55, 3},
                {6, 2, 11, 33}
        };

        int sum = 0;
        int tempSum = 0;
        int tempRow = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }

            if(sum > tempSum){
                tempRow = row;
            }
            tempSum = sum;
            sum = 0;
        }
        System.out.println("Row with max sum of elements: " + tempRow);
    }
}