public class Season12Test2Task3 {
    public static void main(String[] args) {
        boolean a = checkLowerToUpperCase1("Some Text 55adDDDDDDDd HeRe");
        boolean b = checkLowerToUpperCase2("SoME TExT 55 abeeee HerE", 0, 0, 0);

        System.out.println("Result 1: " + a);
        System.out.println("Result 2: " + b);
    }

    private static boolean checkLowerToUpperCase2(String text, int index, int upperCaseLetters, int lowerCaseLetters) {
        if(index == text.length()){
            return lowerCaseLetters > upperCaseLetters;
        }

        if (Character.isLetter(text.charAt(index))) {
            if (Character.isUpperCase(text.charAt(index))) {
                return checkLowerToUpperCase2(text, ++index, ++upperCaseLetters, lowerCaseLetters);
            } else {
                if (Character.isLowerCase(text.charAt(index))) {
                    return checkLowerToUpperCase2(text, ++index, upperCaseLetters, ++lowerCaseLetters);
                }
            }
        }
        return checkLowerToUpperCase2(text, ++index, upperCaseLetters, lowerCaseLetters);
    }

    private static boolean checkLowerToUpperCase1(String text) {
        int lowerCaseLetters = 0;
        int upperCaseLetters = 0;

        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                if (Character.isUpperCase(text.charAt(i))) {
                    upperCaseLetters++;
                } else {
                    if (Character.isLowerCase(text.charAt(i))) {
                        lowerCaseLetters++;
                    }
                }
            }
        }
        return lowerCaseLetters > upperCaseLetters;
    }
}