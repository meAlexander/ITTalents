public class ExerciseSeventeen {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 8, 1, 3};
        int flag = 0;

        for (int i = 1; i < array.length - 1; i++) {
            if (i - 1 == 0) {
                //if first element is bigger or equal
                //to next element break the loop
                if (array[i - 1] >= array[i]) {
                    flag = 1;
                    break;
                }
            } else if (i % 2 == 0) {
                //if current element(with even index) is bigger or equal
                //to previous or next element break the loop
                if (array[i] >= array[i - 1] || array[i] >= array[i + 1]) {
                    flag = 1;
                    break;
                }
            } else {
                //if current element(with odd index) is smaller or equal
                //to previous or next element break the loop
                if (array[i] <= array[i - 1] || array[i] <= array[i + 1]) {
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 1) {
            System.out.println("The condition is NOT executed correctly.");
        } else {
            System.out.println("The condition is executed correctly.");
        }
    }
}