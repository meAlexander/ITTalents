public class ExerciseFive {
    public static void main(String[] args) {
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }

        for(int element : array){
            System.out.print(element + " ");
        }
    }
}