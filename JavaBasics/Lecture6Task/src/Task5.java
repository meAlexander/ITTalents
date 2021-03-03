public class Task5 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 23, 5, 5, 9},
                {4, 55, 3, 2, 7, 13, 19},
                {6, 2, 11, 33, 12}
        };

        int counterOdd = 0;
        int counterEven = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] % 2 == 0){
                    counterEven++;
                }else{
                    counterOdd++;
                }
            }
        }

        if(counterEven > counterOdd){
            System.out.println("Even numbers are more: " +
                    counterEven + " > " + counterOdd);
        }else if(counterEven < counterOdd){
            System.out.println("Odd numbers are more: " +
                    counterEven + " < " + counterOdd);
        }else{
            System.out.println("Even and odd numbers are equal: " +
                    counterEven + " = " + counterOdd);
        }
    }
}