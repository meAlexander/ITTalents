public class Task10 {
    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 4, 4, 4, 4, 4, 1, 1, 4, 1};
        int counter = 1;
        int tempCounter = 0;
        int value = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]){
                    counter++;
                }
                if(tempCounter < counter){
                    tempCounter = counter;
                    value = arr[i];
                }
            }
            counter = 0;
        }
        System.out.println("Element " + value + " repeats " + tempCounter + " times");
    }
}