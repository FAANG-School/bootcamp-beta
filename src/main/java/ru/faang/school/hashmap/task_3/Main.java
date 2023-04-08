package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Main {

    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        addStudent("John", "CS", 1);
        addStudent("Jane", "Mathematics", 1);
        addStudent("Bob", "Engineering", 1);
        addStudent("Alice", "CS", 1);
        addStudent("Mike", "Mathematics", 2);
        addStudent("Sarah", "Engineering", 2);
        addStudent("David", "CS", 1);
        addStudent("Emily", "Mathematics", 2);
        addStudent("Chris", "Engineering", 3);

        findStudents("Mathematics", 2);

        printStudentsGroupedByFacultyAndYear();

        convertListToMap();
    }

    public static void addStudent(String name, String faculty, Integer year) {
        STUDENTS.add(new Student(name, faculty, year));
    }

    public static void removeStudent(String name, String faculty, Integer year) {
        if (STUDENTS.remove(new Student(name, faculty, year))) {
            System.out.println("Student successfully removed!");
        } else {
            System.out.printf("There's no such student: %s, %s, %d\n", name, faculty, year);
        }
    }

    public static void findStudents(String faculty, Integer year) {
        List<Student> students = STUDENTS.stream()
                .filter(student -> student.faculty().equals(faculty))
                .filter(student -> student.year().equals(year))
                .toList();

        System.out.println("Found students: " + students);
    }

    public static void printStudentsGroupedByFacultyAndYear() {
        Map<String, Map<Integer, List<Student>>> groupedStudents = STUDENTS.stream()
                .collect(groupingBy(Student::faculty, groupingBy(Student::year)));

        for (String faculty : groupedStudents.keySet()) {
            System.out.println("Faculty: " + faculty);
            var studentsByYear = groupedStudents.get(faculty);
            for (Integer year : studentsByYear.keySet()) {
                System.out.println("\tYear: " + year);
                for (Student student : studentsByYear.get(year)) {
                    System.out.println("\t\t" + student.name());
                }
            }
        }
    }

    public static void convertListToMap() {
        Map<Pair, List<Student>> collect = STUDENTS.stream()
                .collect(groupingBy(student -> new Pair(student.faculty(), student.year())));

        for (Pair pair : collect.keySet()) {
            System.out.println(pair + ":");
            for (Student student : collect.get(pair)) {
                System.out.println("\t" + student);
            }
        }
    }
}
