public class Task6 {
    public static void main(String[] args) {
        char[][] arr = {
                {'a', 'g', 'v', 'd'},
                {'f', 't', 'u', 'o'},
                {'z', 'x', 'c', 'q'},
                {'r', 'l', 'p', 'f'}
        };

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(row == col){
                    System.out.print(arr[row][col]);
                }
            }
        }
    }
}