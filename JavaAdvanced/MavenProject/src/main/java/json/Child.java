package json;

import java.util.HashMap;

public class Child {
    private String name;
    private int age;
    private HashMap<String, Integer> grades;

    public Child() {

    }

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
        grades = new HashMap<>();
        grades.put("Math", 5);
        grades.put("Geo", 5);
        grades.put("Biology", 6);
    }

    @Override
    public String toString() {
        return "json.Child{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}