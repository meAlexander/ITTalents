package Exercise2;

public class College {
    public static void main(String[] args) {
        Student student1 = new Student("Ivan", "ITI", 19);
        Student student2 = new Student("Martin", "ITI", 18);
        Student student3 = new Student("Petar", "ITI", 21);
        Student student4 = new Student("Dimitar", "KST", 23);

        student1.setGrade(5.20);
        student3.setGrade(5.80);
        //test
        student2.setGrade(8);

        System.out.println(student1.getName() + "`s money: " + student1.receiveScholarship(4.5, 120));
        System.out.println(student3.getName() + "`s money: " + student3.receiveScholarship(4.5, 120));
        //test
        student2.receiveScholarship(4.5, 120);

        student1.upYear();
        student1.upYear();
        //test
        student1.upYear();
        //test
        student1.upYear();
        student2.upYear();
        student4.upYear();

        StudentGroup group1 = new StudentGroup("ITI");
        StudentGroup group2 = new StudentGroup("KST");

        group1.addStudent(student1);
        group1.addStudent(student2);
        group1.addStudent(student3);
        group2.addStudent(student4);

        System.out.println("Best student in group " + group1.getGroupSubject() +
                                " is " + group1.theBestStudent());
        System.out.println("Best student in group " + group2.getGroupSubject() +
                " is " + group2.theBestStudent());

        System.out.println("---------");
        group1.printStudentsInGroup();
        group2.printStudentsInGroup();
    }
}