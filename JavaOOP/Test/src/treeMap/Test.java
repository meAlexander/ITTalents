package treeMap;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    private final TreeMap<Boss, TreeSet<TreeMap<Employee, ArrayList<Child>>>> mapBossEmployees = new TreeMap<>();
    private int countBosses = 0;

    public void fillInBossEmployeeMap() {
        Comparator<TreeMap<Employee, ArrayList<Child>>> treeMapComparator = ((o1, o2) ->
        {
            for (Employee a : o1.keySet()) {
                for (Employee b : o2.keySet()) {
                    if (Double.compare(a.getSalary(), b.getSalary()) > 0) {
                        return 1;
                    }
                    if (Double.compare(a.getSalary(), b.getSalary()) < 0) {
                        return -1;
                    }
                }
            }
            return 0;
        });
        //put 3 bosses, 3 treeSets(one for each boss), 3 treeMaps(one for each set),
        //and 9 employees(3 for each map) and 27 children(3 for each employee)
        generateEmployees(treeMapComparator);
        generateEmployees(treeMapComparator);
        generateEmployees(treeMapComparator);
    }

    public Boss generateBoss() {
        return new Boss("Boss " + (countBosses++), Randomizer.generateDouble(4500, 2500),
                LocalDate.now()
                        .minusYears(Randomizer.generateInt(85, 25))
                        .minusDays(Randomizer.generateInt(365, 1)));
    }

    private void generateEmployees(Comparator<TreeMap<Employee, ArrayList<Child>>> treeMapComparator) {
        TreeSet<TreeMap<Employee, ArrayList<Child>>> treeSetEmployees = new TreeSet<>(treeMapComparator);
        TreeMap<Employee, ArrayList<Child>> treeMapEmployees = new TreeMap<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Child> childArrayList = new ArrayList<>();
            generateChildren(childArrayList);

            treeMapEmployees.put(new Employee("Employee " + (i + 1), Randomizer
                    .generateDouble(1000, 3000), LocalDate.now()
                    .minusYears(Randomizer.generateInt(80, 20))
                    .minusDays(Randomizer.generateInt(365, 1))), childArrayList);
        }
        treeSetEmployees.add(treeMapEmployees);
        mapBossEmployees.put(generateBoss(), treeSetEmployees);
    }

    private void generateChildren(ArrayList<Child> childArrayList) {
        for (int i = 0; i < 3; i++) {
            childArrayList.add(new Child("Child " + (i + 1), LocalDate.now()
                    .minusYears(Randomizer.generateInt(20, 1))
                    .minusDays(Randomizer.generateInt(365, 1))));
        }
    }

    public void viewAllBossesAndEmployees() {
        mapBossEmployees.entrySet()
                .forEach(System.out::println);
    }

    public void viewOnlyEmployees() {
        mapBossEmployees.forEach((key, value) -> value
                .forEach(System.out::println));
    }

    public void updateAllEmployeeSalaries() {
        mapBossEmployees.values()
                .forEach(e ->
                        e.forEach(e1 -> e1.keySet().forEach(Employee::updateSalaryWithTenPercent)));
    }

    public void viewTheRichestBoss() {
        Boss richest = mapBossEmployees.keySet()
                .stream()
                .max(Comparator.comparing(Boss::getSalary)).orElse(null);
        System.out.println(richest);
    }

    public void viewThePoorestBoss() {
        Boss poorest = mapBossEmployees.keySet()
                .stream()
                .min(Comparator.comparing(Boss::getSalary)).orElse(null);
        System.out.println(poorest);
    }

    public void viewThePoorestEmployee() {
        TreeSet<Employee> employees = new TreeSet<>();
        for (TreeSet<TreeMap<Employee, ArrayList<Child>>> treeMapTreeSet : mapBossEmployees.values()) {
            for (TreeMap<Employee, ArrayList<Child>> treeMap : treeMapTreeSet) {
                employees.addAll(treeMap.keySet());
            }
        }
        Employee poorest = employees
                .stream()
                .min(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
        System.out.println(poorest);
    }

    public void viewTheRichestEmployee() {
        TreeSet<Employee> employees = new TreeSet<>();
        for (TreeSet<TreeMap<Employee, ArrayList<Child>>> treeMapTreeSet : mapBossEmployees.values()) {
            for (TreeMap<Employee, ArrayList<Child>> treeMap : treeMapTreeSet) {
                employees.addAll(treeMap.keySet());
            }
        }
        Employee richest = employees
                .stream()
                .max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
        System.out.println(richest);
    }

    public void viewTheOldestEmployee() {
        TreeSet<Employee> employees = new TreeSet<>();
        for (TreeSet<TreeMap<Employee, ArrayList<Child>>> treeMapTreeSet : mapBossEmployees.values()) {
            for (TreeMap<Employee, ArrayList<Child>> treeMap : treeMapTreeSet) {
                employees.addAll(treeMap.keySet());
            }
        }
        Employee oldest = employees
                .stream()
                .min(Comparator.comparing(Employee::getBirthdayDate)).orElse(null);
        System.out.println(oldest);
    }

    public void viewAllSalaries() {
        TreeSet<Double> d = new TreeSet<>();
        for (TreeSet<TreeMap<Employee, ArrayList<Child>>> a1 : mapBossEmployees.values()) {
            for (TreeMap<Employee, ArrayList<Child>> a2 : a1) {
                for (Employee a3 : a2.keySet()) {
                    d.add(a3.getSalary());
                }
            }
        }
        System.out.println(d);
    }

    public void test() {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(8);
        a.add(3);
        a.add(52);
        a.add(25);
        a.add(48);
        a.add(97);
        a.add(11);
        a.add(3);
        a.add(8);
        a.add(52);
        a.add(87);

        a.stream()
                .distinct()
                .filter(i -> i > 10)
                .sorted()
                .map(i -> i + 8)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}