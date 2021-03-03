public class ExerciseThree {
    public static void main(String[] args) {
        System.out.println("All odd numbers between -10 and 10.");

        for (int i = -10; i <= 10; i++) {
            if(i % 2 != 0){
                System.out.print(i + " ");
            }
        }
    }
}