public class ExerciseEight {
    public static void main(String[] args) {
        int[] array = {2, 2, 2, 3, 3, 3, 3, 3, 3, 6, 6, 6, 6, 6, 6, 6, 0, 0, 0, 0, 0, 0, 0};
        int value = 0;
        int repeat = 0;
        int counter = 0;
        int counter2 = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                counter++;
            }
            //if elements are not equals save element, save repetitions and continue
            //or if we are at the end of array(array[i+1] is the last elements)
            //save last element if repetitions are more than previous most repetitive element, save repetitions and loop will end
            if (array[i] != array[i + 1] || i + 1 == array.length - 1) {
                //if we have two or more sequences with equals repetitions we get the last one
                if (counter2 <= counter) {
                    value = array[i];
                    repeat = counter;
                    counter2 = counter;
                }
                counter = 0;
            }
        }

        //print element which repeats N times + 1
        //because if we have 3 comparisons we have 4 equals elements
        for (int i = 0; i < repeat + 1; i++) {
            System.out.print(value + " ");
        }
    }
}