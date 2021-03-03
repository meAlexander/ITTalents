import java.util.Scanner;

public class ExerciseSix {
    public static void main(String[] args) {
        getInput();
    }

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);
        String text;
        do {
            System.out.print("Enter a sentence: ");
            text = scanner.nextLine();
        }while (text.length() < 1);
        transformSentence(text);
    }

    public static void transformSentence(String text) {
        String[] splitText = text.split("[,]+\\s|[\\s]|[,]");
        StringBuilder builder = new StringBuilder();

        for (String s : splitText) {
            String word = s.substring(0, 1).toUpperCase() + s.substring(1);
            builder.append(word).append(" ");
        }
        System.out.println(builder);
    }
}