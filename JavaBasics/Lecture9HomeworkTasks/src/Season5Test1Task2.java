import java.util.Scanner;

public class Season5Test1Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter some text: ");
        String text = scanner.nextLine();

        String mostFrequentWord = searchMostFrequentWord(text);
        System.out.println("Most frequent word in text is: " + mostFrequentWord);
    }

    private static String searchMostFrequentWord(String text) {
        String[] words = text.split("[\\s.,]+");
        String mostFrequentWord = null;
        int tempCount = 0;
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            count = 1;
            for (int j = i + 1; j < words.length; j++) {
                if(word.equalsIgnoreCase(words[j])){
                    count++;
                }
            }
            if(count > tempCount){
                mostFrequentWord = word;
                tempCount = count;
            }
        }
        System.out.println(tempCount);
        return mostFrequentWord.toLowerCase();
    }
}