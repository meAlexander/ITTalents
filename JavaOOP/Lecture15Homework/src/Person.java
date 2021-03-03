public class Person {
    private String name;
    private int age;
    private boolean isMale;

    public  Person(){

    }
    public Person(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    public int getAge() {
        return age;
    }

    public void showPersonInfo(){
        System.out.println("Name: " + this.name +
                            " Age: " + this.age +
                            " Is male: " + this.isMale);
    }
}