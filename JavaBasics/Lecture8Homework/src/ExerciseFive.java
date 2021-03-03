import java.util.Scanner;

public class ExerciseFive {
    public static void main(String[] args) {
        getInput();
    }

    private static void getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word1 = scanner.nextLine();

        System.out.print("Enter a word: ");
        String word2 = scanner.nextLine();

        if (compareFirstToSecondWord(word1, word2)) {
            print(word1,word2);
        } else {
            if(compareSecondToFirstWord(word1, word2)){
                print(word2,word1);
            }else{
                System.out.println("No equals symbols!");
            }
        }
    }

    public static boolean compareFirstToSecondWord(String word1, String word2) {
        char firstSymbolSecondWord = word2.charAt(0);
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == firstSymbolSecondWord) {
                return true;
            }
        }
        return false;
    }

    public static boolean compareSecondToFirstWord(String word1, String word2) {
        char firstSymbolFirstWord = word1.charAt(0);
        for (int i = 0; i < word2.length(); i++) {
            if (word2.charAt(i) == firstSymbolFirstWord) {
               return true;
            }
        }
        return false;
    }

    public static void print(String word1, String word2) {
        for (int i = 0; i < word1.length(); i++) {
            System.out.print(word1.charAt(i));
            if (word1.charAt(i) == word2.charAt(0)) {
                for (int j = 1; j < word2.length(); j++) {
                    System.out.print(word2.charAt(j));
                }
            }
            System.out.println();
        }
    }
}