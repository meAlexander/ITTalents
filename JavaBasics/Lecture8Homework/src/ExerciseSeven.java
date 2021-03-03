import java.util.Scanner;

public class ExerciseSeven {
    public static void main(String[] args) {
        getInput();
    }

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);
        String[] splitText;
        do{
        System.out.print("Enter words: ");
        String text = scanner.nextLine();

        splitText = text.split("\\s");
        }while (splitText[0].length() <= 0);

        String longestWord = getLongestWord(splitText);

        System.out.println(splitText.length + " word, " +
                "longest word is with " + longestWord.length() + " symbols.");
    }

    public static String getLongestWord(String[] splitText) {
        String longestWord = splitText[0];
        for (int i = 1; i < splitText.length; i++) {
            if(longestWord.length() < splitText[i].length()){
                longestWord = splitText[i];
            }
        }
        return longestWord;
    }
}
