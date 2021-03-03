import java.util.Scanner;

public class ExerciseTwoSecondWay {
    public static void main(String[] args) {
        getInput();
    }

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);
        String text;
        String[] getWords;
        do {
            System.out.print("Enter two words(10-20 characters all): ");
            text = scanner.nextLine();
            getWords = text.split("\\s+");
        } while (getWords.length <= 1 || getWords[0].length() + getWords[1].length() > 20 ||
                getWords[0].length() + getWords[1].length() < 10);

        String word1 = getWords[0];
        String word2 = getWords[1];

        String longerWord = getLongerWord(word1, word2);
        String newWord = exchangeFirstFiveCharacters(word1, word2);

        printInfo(longerWord.length(), newWord);
    }

    public static String exchangeFirstFiveCharacters(String word1, String word2) {
        String newWord;
        //if word2 is smaller than 5 get characters from 0 to word2.length
        if (word2.length() < 5) {
            newWord = word2 + word1.substring(word2.length());
        } else if (word1.length() < 5) {
            newWord = word1 + word2.substring(word1.length());
        }else{
            newWord = word2.substring(0, 5) + word1.substring(5);
        }
        return newWord;
    }

    public static String getLongerWord(String word1, String word2) {
        if (word1.length() >= word2.length()) {
            return word1;
        } else {
            return word2;
        }
    }

    public static void printInfo(int length, String newWord) {
        System.out.println(length + " " + newWord);
    }
}