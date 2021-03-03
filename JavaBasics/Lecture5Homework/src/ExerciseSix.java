public class ExerciseSix {
    public static void main(String[] args) {
        int[] array1 = new int[5];
        int[] array2 = new int[5];
        int[] array3 = array2;

        //two variables in stack point two addresses in heap memory
        if (array1 == array2){
            System.out.println("array1 and array2 are Equals.");
        }else{
            System.out.println("array1 and array2 are Not equals.");
        }

        if(array1.length == array2.length){
            System.out.println("array1 and array2 have Equals length.");
        }else{
            System.out.println("array1 and array2 are have Not equals length.");
        }

        //two variables in stack point one address in heap memory
        if(array2 == array3){
            System.out.println("array2 and array3 are Equals.");
        }else{
            System.out.println("array2 and array3 are Not equals.");
        }

        int[] array4 = {4, 8, -5, 6, 9};
        int[] array5 = {4, -88, 13, 7, -6, 8, 15};
        int flag = 0;

        for (int i = 0; i < array4.length && i < array5.length; i++) {
            if(array4[i] != array5[i]){
                flag = 1;
                break;
            }
        }

        if(flag == 1){
            System.out.println("array4 and array5 are Not equals.");
        }else{
            System.out.println("array4 and array5 are equals.");
        }

        if(array4.length == array5.length){
            System.out.println("array4 and array5 have Equals length.");
        }else{
            System.out.println("array4 and array5 are have Not equals length.");
        }
    }
}