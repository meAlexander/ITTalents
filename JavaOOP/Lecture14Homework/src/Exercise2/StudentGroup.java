package Exercise2;

public class StudentGroup {
    private String groupSubject;
    private Student[] students;
    private int freePlaces;
    private int number = 0;

    public StudentGroup(){
        freePlaces = 5;
        students = new Student[freePlaces];
    }

    public StudentGroup(String subject){
        this();
        this.groupSubject = subject;
    }

    public String getGroupSubject(){
        return this.groupSubject;
    }

    public void addStudent(Student a){
        if(a.getSubject().equals(groupSubject) && freePlaces > 0){
            students[number++] = a;
            freePlaces--;
        }
    }

    public void emptyGroup(){
        freePlaces = 5;
        students = new Student[freePlaces];
    }

    public String theBestStudent(){
        Student bestStudents = students[0];
        for (Student student : students) {
            if(student == null){
                break;
            }
            if(bestStudents.getGrade() < student.getGrade()){
                bestStudents = student;
            }
        }
        return bestStudents.getName();
    }

    public void printStudentsInGroup(){
        for (Student student : students) {
            if(student == null){
                break;
            }
            System.out.println("Group: " + this.getGroupSubject() + ", Name: " +
                    student.getName() + ", Age: " +
                    student.getAge() + ", Grade: " +
                    student.getGrade() + ", Money: " +
                    student.getMoney() + ", Year: " +
                    student.getYearInCollege() + ", Degree: " +
                    student.isHasDegree());
        }
    }
}