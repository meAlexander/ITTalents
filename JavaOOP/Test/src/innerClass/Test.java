package innerClass;

public class Test {
    public String name;
    protected double salary = 1;
    private int age;
    public static String egn;
    int ID;

    public Test(String name) {
        this.name = name;
    }

    public static Test getNewTest(String name){
        return new Test(name);
    }

      class InnerClass {
        public String nameInner;
        protected double salaryInner;
        private int ageInner;
        protected  String egnInner;

        public InnerClass(String nameInner) {
            this.nameInner = nameInner;
        }

        public void doSmthInner() {
            egn = "da";

        }
    }

    public void doSmth() {
        egn = "da";
        Test.InnerClass c;

    }
}