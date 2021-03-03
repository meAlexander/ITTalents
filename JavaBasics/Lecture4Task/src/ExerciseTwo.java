public class ExerciseTwo {
    public static void main(String[] args) {
        for (int i = 0; i <= 50; i++) {
            if(i % 2 != 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for (int i = 51; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.print(i + " ");
            }
        }
    }
}