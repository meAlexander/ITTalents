package innerClass;

import java.util.HashMap;
import java.util.TreeMap;

public class Demo {
    public static void main(String[] args) {
        HashMap<String, Integer> a = new HashMap<>();
        TreeMap<String, Integer> b = new TreeMap<>();

        b.put("Mitko", 5);
        b.put("mitko", 8);

        a.put("Gosho", 8);
        a.put("gosho", 15);

        a.entrySet()
                .forEach(System.out::println);

        b.entrySet()
                .forEach(System.out::println);


    }
}