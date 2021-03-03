import java.util.Arrays;
import java.util.Scanner;

public class ExerciseTen {
    public static void main(String[] args) {
        getInput();
    }

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        transformText(text);
    }

    public static void transformText(String text) {
        StringBuilder newText = new StringBuilder();
        char[] letters = text.toCharArray();

        for(char c : letters){
            newText.append((char) (c + 5));
        }
        System.out.println(newText);
    }
}