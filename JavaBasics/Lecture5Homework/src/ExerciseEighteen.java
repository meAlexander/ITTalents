public class ExerciseEighteen {
    public static void main(String[] args) {
        int[] array = {18, 19, 32, 1, 3, 4, 5, 6, 7, 8};
        int[] array2 = {1, 2, 3, 4, 5, 16, 17, 18, 27, 11};
        int[] array3 = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if(array[i] >= array2[i]){
                array3[i] = array[i];
            }else{
                array3[i] = array2[i];
            }
        }

        for(int element : array3){
            System.out.print(element + " ");
        }
    }
}