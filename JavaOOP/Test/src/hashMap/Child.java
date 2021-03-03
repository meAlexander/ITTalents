package hashMap;

import java.time.LocalDate;

public class Child {
    private String name;
    private LocalDate birthdayDate;

    public Child(String name, LocalDate birthdayDate) {
        this.name = name;
        this.birthdayDate =birthdayDate;
    }

    public String getName() {
        return name;
    }
    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", birthdayDate=" + birthdayDate +
                '}';
    }
}