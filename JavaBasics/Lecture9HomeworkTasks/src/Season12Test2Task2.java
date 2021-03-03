import java.util.Arrays;

public class Season12Test2Task2 {
    public static void main(String[] args) {
        char[] c = orderChars("Some  5text");
        System.out.println(Arrays.toString(c));
    }

    private static char[] orderChars(String text) {
        char[] orderedChars = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            orderedChars[i] = text.charAt(i);
        }

        for (int i = 0; i < orderedChars.length; i++) {
            int index = i;
            char symbol = orderedChars[i];

            for (int j = i+1; j < orderedChars.length; j++) {
                if(symbol > orderedChars[j]){
                    symbol = orderedChars[j];
                    index = j;
                }
            }
            char tempChar = orderedChars[i];
            orderedChars[i] = symbol;
            orderedChars[index] = tempChar;
        }

        return orderedChars;
    }
}