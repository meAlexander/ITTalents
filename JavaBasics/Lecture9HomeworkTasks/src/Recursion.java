public class Recursion {
    public static void main(String[] args) {
        int a = recursion(0, 1, 12);
        System.out.println(a);
    }

    private static int recursion(int previous, int current, int end) {
        if(end == 1){
            return current;
        }
        return recursion(current, previous+current,  --end);
    }
}