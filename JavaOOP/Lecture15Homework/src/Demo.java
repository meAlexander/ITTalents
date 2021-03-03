public class Demo {
    public static void main(String[] args) {
        Person[] arrayPerson = new Person[10];

        Person person1 = new Person("Ivan", 25, true);
        Person person2 = new Person("Mariq", 30, false);

        Student student1 = new Student("Todor", 20, true, 4.80);
        Student student2 = new Student("Violeta", 22, false, 5.75);

        Employee employee1 = new Employee("Martin", 45, true, 50);
        Employee employee2 = new Employee("Petar", 52, true, 65);

        arrayPerson[0] = person1;
        arrayPerson[1] = person2;

        arrayPerson[2] = student1;
        arrayPerson[3] = student2;

        arrayPerson[4] = employee1;
        arrayPerson[5] = employee2;

        for (Person person : arrayPerson) {
            if (person instanceof Student) {
                ((Student) person).showStudentInfo();
            } else if (person instanceof Employee) {
                ((Employee) person).showEmployeeInfo();
            } else if (person != null) {
                person.showPersonInfo();
            }
        }

        for (Person person : arrayPerson) {
            if (person instanceof Employee) {
                System.out.println("Overtime money: "
                        + ((Employee) person).calculateOvertime(2));
            }
        }
    }
}