public class Task1 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 9, 7, -5, 0};
        int flag = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0){
                flag = 1;
                break;
            }
        }
        if(flag == 1){
            System.out.println("There is at least one negative number.");
        }else{
            System.out.println("All numbers are positive.");
        }
    }
}