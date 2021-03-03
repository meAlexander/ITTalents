import java.util.Scanner;

public class ExerciseTwo {
    public static void main(String[] args) {
        getInput();
    }

    public static void getInput() {
        Scanner scanner = new Scanner(System.in);
        String text;
        String[] getWords;
        do {
            System.out.print("Enter two words(10-20 characters each): ");
            text = scanner.nextLine();
            getWords = text.split("\\s+");
        } while (getWords.length <= 1 || getWords[0].length() > 20 || getWords[0].length() < 10 ||
                getWords[1].length() > 20 || getWords[1].length() < 10);

        String word1 = getWords[0];
        String word2 = getWords[1];

        String newWord = exchangeFirstFiveCharacters(word1, word2);
        int longerWordLength = getLongerWord(word1, word2);

        printInfo(longerWordLength, newWord);
    }

    public static String exchangeFirstFiveCharacters(String word1, String word2){
        String newWord = word2.substring(0, 5) + word1.substring(5);

        return newWord;
    }

    public static int getLongerWord(String word1, String word2){
        int longerWord = Math.max(word1.length(), word2.length());

//        if(word1.length() >= word2.length()){
//            return word1.length();
//        }else{
//            return word2.length();
//        }
        return longerWord;
    }

    public static void printInfo(int length, String newWord){
        System.out.println(length + " " + newWord);
    }
}