import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostCommonLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter some text: ");
        getOccurringChar(scanner.nextLine().toUpperCase());
    }

    static void getOccurringChar(String text) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        char[] strArray = text.toCharArray();

        for (char c : strArray) {
            if (!Character.isLetter(c)) {
                continue;
            }
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        int sumOfLetters = 0;
        for (Integer i : charCountMap.values()) {
            sumOfLetters += i;
        }

        int finalSumOfLetters = sumOfLetters;
        charCountMap.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " " +
                        new DecimalFormat(".##").format(((float) e.getValue() / finalSumOfLetters) * 100) + " percent"));
    }
}