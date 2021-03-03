public class ExerciseTwenty {
    public static void main(String[] args) {
        System.out.println("You will see a square with all digits(1-9).");

        for (int row = 1; row < 10; row++) {
            for (int col = row; col < 10; col++) {
                System.out.print(col + " ");
            }

            for (int col2 = 0; col2 < row; col2++) {
                    System.out.print(col2 + " ");
            }
            System.out.println();
        }
    }
}