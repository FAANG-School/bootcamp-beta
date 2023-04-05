package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("Harry", "Gryffindor", 1991));
        students.add(new Student("Draco", "Slytherin", 1991));
        students.add(new Student("Hanna", "Hufflepuff", 1990));
        students.add(new Student("Edvard", "Gryffindor", 1994));
    }

    public static void main(String[] args) {

        printStudentGroup();
        addStudent("Ron", "Gryffindor", 1991);
        addStudent("Hermione", "Gryffindor", 1991);
        printStudentGroup();
        removeStudent("Hermione", "Gryffindor", 1991);
        removeStudent("Harry", "Gryffindor", 1991);
        addStudent("Bill", "Hufflepuff", 1990);
        printStudentGroup();
    }

    public static Map<Group, List<Student>> getGroups(List<Student> students) {
        return students.stream().collect(Collectors.groupingBy(student -> new Group(student)));
    }

    public static void addStudent(String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
        System.out.printf("Student %s added to faculty: %s in %d year. \n", name, faculty, year);
    }

    public static void removeStudent(String name, String faculty, int year) {
        Student current = new Student(name, faculty, year);
        if (students.contains(current)) {
        students.remove(current);
            System.out.printf("The student %s was removed.\n", name);
        }else {
            System.out.println("The student has not been found");
        }
    }

    public static void printStudentGroup(){
        getGroups(students).entrySet()
                .forEach(entry ->
                        System.out.printf("The group %s includes %s students.\n", entry.getKey(), entry.getValue()));
    }
}

