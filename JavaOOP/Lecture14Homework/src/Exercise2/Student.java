package Exercise2;

public class Student {
    private String name;
    private String subject;
    private double grade;
    private int yearInCollege;
    private int age;
    private boolean hasDegree;
    private double money;

    public Student(){
        this.grade = 4;
        this.yearInCollege = 1;
        this.hasDegree = false;
        this.money = 0;
    }

    public Student(String name, String subject, int age){
        this();
        this.name = name;
        this.subject = subject;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade){
        if(grade < 2 || grade > 6){
            System.out.println("Invalid grade!");
            return;
        }
        this.grade = grade;
    }

    public int getYearInCollege() {
        return yearInCollege;
    }

    public int getAge() {
        return age;
    }

    public boolean isHasDegree() {
        return hasDegree;
    }

    public double getMoney() {
        return money;
    }

    public void upYear(){
        if(this.yearInCollege < 3){
            yearInCollege++;
        }else if(this.yearInCollege == 3){
            yearInCollege++;
            hasDegree = true;
            System.out.println("This year " + this.name + " will be graduated.");
        }else{
            System.out.println("The student " + this.name + " has already graduated!");
        }
    }

    public double receiveScholarship(double min, double amount){
        if (this.grade >= min && this.age < 30){
            this.money += amount;
        }else{
            System.out.println("Requirements are not covered for scholarship.");
        }
        return this.money;
    }
}