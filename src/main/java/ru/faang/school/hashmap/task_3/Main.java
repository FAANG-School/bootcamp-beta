package ru.faang.school.hashmap.task_3;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final List<Student> studentList = new ArrayList<>();

    {
        studentList.add(new Student("Adam Black", "IT", 1));
        studentList.add(new Student("Ben Rock", "Management", 3));
        studentList.add(new Student("Clark Ross", "Marketing", 3));
        studentList.add(new Student("Drake Upton", "IT", 1));
        studentList.add(new Student("Eton Jameson", "IT", 2));
        studentList.add(new Student("Frank Harrington", "Finance", 4));
        studentList.add(new Student("Garry Simon", "Management", 1));
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.addStudent("Holly White", "Marketing", 3);

        main.removeStudent("Eton Jameson", "IT", 2);

        main.getStudentsByFacultyAndYear("IT", 1).forEach(System.out::println);

        main.showAllStudentsByFacultyAndYear();
    }

    private Map<Pair<String, Integer>, List<Student>> getStudentsByAllFacultyAndYear(List<Student> studentList) {
        Map<Pair<String, Integer>, List<Student>> studentsMap = new HashMap<>();

        studentList.forEach(student -> {
            if (studentsMap.containsKey(new Pair<>(student.getFaculty(), student.getYear()))) {
                studentsMap.get(new Pair<>(student.getFaculty(), student.getYear())).add(student);
            } else {
                studentsMap.put(new Pair<>(student.getFaculty(), student.getYear()), new ArrayList<>());
                studentsMap.get(new Pair<>(student.getFaculty(), student.getYear())).add(student);
            }
        });

        return studentsMap;
    }

    private void addStudent(String name, String faculty, int year) {
        studentList.add(new Student(name, faculty, year));
    }

    private void removeStudent(String name, String faculty, int year) {
        studentList.remove(new Student(name, faculty, year));
    }

    private List<Student> getStudentsByFacultyAndYear(String faculty, int year) {
        return getStudentsByAllFacultyAndYear(studentList).get(new Pair<>(faculty, year));
    }

    private void showAllStudentsByFacultyAndYear() {
        getStudentsByAllFacultyAndYear(studentList).forEach((pair, list) -> {
            System.out.printf("Faculty: %s, year: %d\n", pair.getKey(), pair.getValue());
            list.forEach(System.out::println);
        });
    }
}