public class Student extends Person{
    private double score;

    public Student(){

    }

    public Student(String name, int age, boolean isMale, double score){
        super(name, age, isMale);
        this.score = score;
    }

    public void showStudentInfo(){
        showPersonInfo();
        System.out.println("Score: " + this.score);
    }
}
