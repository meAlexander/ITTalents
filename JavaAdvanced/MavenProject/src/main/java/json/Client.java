package json;

public class Client {
    private String name;
    private int age;
    private Child child;

    public Client(String name, int age, Child child) {
        this.name = name;
        this.age = age;
        this.child = child;
    }

    public Client() {

    }

    @Override
    public String toString() {
        return "json.Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", " + child +
                '}';
    }
}