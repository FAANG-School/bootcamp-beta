package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> studentBase = new ArrayList<>();

    public static Map<Pair, List<Student>> getStudentsGroup(List<Student> studentsList) {
        Map<Pair, List<Student>> groupedMap = new HashMap<>(); // which modifier need to use?

        for (Student student : studentsList) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            if (groupedMap.containsKey(pair)) {
                groupedMap.get(pair).add(student); // just adding the student to list if we have such pair
            } else {
                List<Student> studentList = new ArrayList<>();
                studentList.add(student);
                groupedMap.put(pair, studentList);
                // groupedMap.put(pair, new ArrayList<>().add(student)); - do not understood why it`s not working
            }
        }
        return groupedMap;
    }

    public static void addStudent(Student student) {
        studentBase.add(student);
    }

    public static void removeStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        if (studentBase.contains(student)) {
            System.out.println("Удален: " + student);
            studentBase.remove(student);
        } else {
            System.out.println("Такого студента нет в базе!");
        }
    }

    public static void printAllStudents() {
        System.out.println("\nСписок студентов:");
        for (Student student : studentBase) {
            System.out.println(student);
        }
    }

    public static void printGroupedList(Map<Pair, List<Student>> groupedList) {
        System.out.println("\nСписок студентов по факультетам и курсам:");
        for (Map.Entry<Pair, List<Student>> entry: groupedList.entrySet()) {
            System.out.println(String.format("Факультет: %s, курс: %d",
                    entry.getKey().getFaculty(), entry.getKey().getYear()));
            for (Student student: entry.getValue()) {
                System.out.println(student);
            }
            System.out.println();
        }
    }

    public static void getStudents(String faculty, int year) {
        System.out.println(String.format("\nИщем студентов по факультету %s и курса %d ...", faculty, year));
        Map<Pair, List<Student>> groupedStudents = getStudentsGroup(studentBase);
        Pair pair = new Pair(faculty, year);
        if (groupedStudents.containsKey(pair)) {
            System.out.println("Нашли и вот они:");
            for (Student student: groupedStudents.get(pair)) {
                System.out.println(student);
            }
        } else {
            System.out.println("Таких студентов нет :(");
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Ваня", "Математика", 2);
        Student student2 = new Student("Таня", "Математика", 3);
        Student student3 = new Student("Петя", "Физика", 1);
        Student student4 = new Student("Петя", "Химия", 3);
        Student student5 = new Student("Ярык", "Физра", 4);
        Student student6 = new Student("Женя", "Математика", 3);
        Student student7 = new Student("Паша", "Математика", 3);

        addStudent(student1);
        addStudent(student2);
        addStudent(student3);
        addStudent(student4);
        addStudent(student5);
        addStudent(student6);
        addStudent(student7);
        printAllStudents();

        Map<Pair, List<Student>> groupedStudents = getStudentsGroup(studentBase);
        printGroupedList(groupedStudents);

        removeStudent("Петя", "Химия", 3);
        printAllStudents();

        getStudents("Химия", 5);
        getStudents("Математика", 3);
    }
}
