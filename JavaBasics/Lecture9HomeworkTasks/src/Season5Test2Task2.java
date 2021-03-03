public class Season5Test2Task2 {
    public static void main(String[] args) {
        String result = checkRatio("SoMee Text.");
        System.out.println(result);
    }

    private static String checkRatio(String text) {
        int lowerCaseLetters = 0;
        int upperCaseLetters = 0;

        for (int i = 0; i < text.length(); i++) {
            if(Character.isLetter(text.charAt(i))){
                if(text.charAt(i) >= 64 && text.charAt(i) <= 90){
                    upperCaseLetters++;
                }else{
                    if(text.charAt(i) >= 97 && text.charAt(i) <= 122){
                        lowerCaseLetters++;
                    }
                }
            }
        }

        if(lowerCaseLetters / upperCaseLetters >= 1){
            return "Lower to Upper case: " + (lowerCaseLetters / upperCaseLetters) + ":" + 1;
        }else{
            return "Upper to Lower case: " + (upperCaseLetters / lowerCaseLetters) + ":" + 1;
        }
    }
}