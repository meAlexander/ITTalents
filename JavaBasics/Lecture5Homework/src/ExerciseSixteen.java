public class ExerciseSixteen {
    public static void main(String[] args) {
        double[] array = {-1.12, -2.43, 3.1, 4.2, 0, 6.4, - 7.5, 8.6, 9.1, -4};
        double[] newArray = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            if(array[i] < -0.231){
                newArray[i] = (i+1)*(i+1) + 41.25;
            }else{
                newArray[i] = array[i] * (i+1);
            }
        }

        for(double element : newArray){
            System.out.print(String.format("%.2f", element) + "  ");
        }
    }
}