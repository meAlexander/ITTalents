import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, -1, 2, 5, 3, 1, 1, 8, 7, 0, 9};

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for (int position = 0; position < arr.length / 2; position++) {
            int minValueIndex = position;
            int maxValueIndex = position;

            for (int currentElementIndex = 1 + position; currentElementIndex < arr.length - position; currentElementIndex++) {
                if (arr[minValueIndex] > arr[currentElementIndex]) {
                    minValueIndex = currentElementIndex;
                }

                if (arr[maxValueIndex] < arr[currentElementIndex]) {
                    maxValueIndex = currentElementIndex;
                }
            }

            int temp1 = arr[position];
            arr[position] = arr[minValueIndex];
            arr[minValueIndex] = temp1;

            //ако текущият елемент се окаже най-голям, то ние вече сме го разменили с най-малкия в текущата итерация
            //и сме го сложили(най-големия) на мястото откъдето сме взели най-малкия
            //затова трябва да разменим местата на най-големия елемент,
            //който се намира на мястото откъдето сме взели най-малкия(взели сме го от arr[minValueIndex]), с последния елемент
            if (maxValueIndex == position) {
                int temp2 = arr[arr.length - 1 - position];
                arr[arr.length - 1 - position] = arr[minValueIndex];
                arr[minValueIndex] = temp2;
            }else{
                int temp3 = arr[arr.length - 1 - position];
                arr[arr.length - 1 - position] = arr[maxValueIndex];
                arr[maxValueIndex] = temp3;
            }
        }
    }
}