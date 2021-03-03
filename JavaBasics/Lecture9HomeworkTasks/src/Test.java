public class Test {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(Integer.toBinaryString(a) + " -> " + a);

        for (int i = 1; i < 8; i++) {
            int c = a << i;
            System.out.println(Integer.toBinaryString(c) + " -> " + c);
        }

        //int d = 0b10000000000000000000000000000000;

        int u = -50;
        System.out.println(Integer.toBinaryString(u) + " -> " + u);
        //u = ~u + 1;

        System.out.println();
        System.out.println(Integer.toBinaryString(~u) + " -> " + ~u);
        System.out.println();

       // System.out.println(Integer.toBinaryString(u) + " -> " + u);
    }
}