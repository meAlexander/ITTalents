import java.util.Scanner;

public class ExerciseEleven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to enter a number of branches and see the tree.");

        System.out.print("Enter a number of branches: ");
        int numberOfBranches = scanner.nextInt();

        for (int row = 0; row < numberOfBranches; row++) {
            //loop for spaces
            for (int spaces = row; spaces < numberOfBranches - 1; spaces++) {
                System.out.print(" ");
            }
            //loop for stars
            for (int stars = 0; stars < 2 * row + 1; stars++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //empty tree
        for (int row = 0; row < numberOfBranches; row++) {
            //loop for spaces
            for (int spaces = row; spaces < numberOfBranches - 1; spaces++) {
                System.out.print(" ");
            }
            //loop for stars
            for (int stars = 0; stars < 2 * row + 1; stars++) {
                //check if row is not first or last
                if (row != 0 && row != numberOfBranches - 1){
                    //check if stars is not first or last
                    if (stars != 0 && stars != 2 * row){
                        System.out.print(" ");
                    }else{
                        System.out.print("*");
                    }
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}