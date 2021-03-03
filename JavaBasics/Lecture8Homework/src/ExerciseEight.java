import java.util.Scanner;

public class ExerciseEight {
    public static void main(String[] args) {
        getInput();
    }

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = scanner.nextLine();

        if(reverseWord(word)){
            System.out.println("Yes.");
        }else{
            System.out.println("No.");
        }
    }

    public static boolean reverseWord(String word) {
        StringBuilder builder = new StringBuilder(word);
        builder.reverse();

        return word.equals(builder.toString());
    }
}