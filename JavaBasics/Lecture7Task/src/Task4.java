public class Task4 {
    public static void main(String[] args) {
        int[] arr = {1,0,0,0,1,1,1,0,1,1,0,1,1,0};

        for (int i = 0, n = 0; i < arr.length; i++) {
            if(arr[i] == 1){
                if(arr[n] == 0){
                    arr[i] = 0;
                }
                arr[n] = 1;
                n++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}