package ru.faang.school.hashmap.task_3;

import java.util.*;

public class Main {
    public static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        studentList.add(new Student("Egor", "Math", 5));
        studentList.add(new Student("Valentin", "Economic", 3));
        studentList.add(new Student("Andrey", "Economic", 3));
        studentList.add(new Student("Vlad", "Math", 3));
        studentList.add(new Student("Dima", "Economic", 5));
        AddStudent(studentList, "Maksim", "Math", 5);
        outputStudents(studentList);
        System.out.println("___________________");
        searchStudent(studentList, "Economic", 3);
        System.out.println("___________________");
        removeStudent(studentList, "Egor", "Math", 5);
        outputStudents(studentList);
    }

    private static void AddStudent(List<Student> students, String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    private static void removeStudent(List<Student> students, String name, String faculty, int year) {
        Student removeStudent = new Student(name, faculty, year);
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.equals(removeStudent))
                iterator.remove();
        }
    }

    private static void searchStudent(List<Student> students, String faculty, int year) {
        Map<Pair, List<String>> map = setMap(students);
        Pair pair = new Pair(faculty, year);
        for (Map.Entry<Pair, List<String>> entry : map.entrySet()) {
            if (pair.equals(entry.getKey())) {
                System.out.println(entry.getValue());
            }
        }
    }

    private static void outputStudents(List<Student> students) {
        System.out.println(setMap(students));
    }

    private static Map<Pair, List<String>> setMap(List<Student> students) {
        Map<Pair, List<String>> pairListMap = new HashMap<>();
        for (Student student : students) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            pairListMap.getOrDefault(pair, new ArrayList<>()).add(student.getName());
        }
        return pairListMap;
    }
}
