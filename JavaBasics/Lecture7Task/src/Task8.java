public class Task8 {
    public static void main(String[] args) {
        boolean[][] arr = {
                {true, false, true, false},
                {true, false, false, false},
                {true, false, false, false},
                {false, false, false, true}
        };

        outeLoop:
        for (int row = 0; row < arr.length; row++) {
            for (int col = arr[row].length - 1; col >= 0; col--) {
                if(row + col == 3){
                    for (int i = 0; i < col; i++) {
                        if(arr[row][i] == true){
                            System.out.println("Contains true.");
                            break outeLoop;
                        }
                    }
                }
            }
        }
    }
}