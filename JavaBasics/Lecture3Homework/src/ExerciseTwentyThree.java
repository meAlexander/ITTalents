public class ExerciseTwentyThree {
    public static void main(String[] args) {
        System.out.println("You will see the multiplication table without repetition.");
        int row = 1;
        int col = 0;

        while (row != 10) {
            col = row;
            while(col != 10) {
                System.out.print(row + ":" + col + " ");
                col++;
            }
            System.out.println();
            row++;
        }
    }
}