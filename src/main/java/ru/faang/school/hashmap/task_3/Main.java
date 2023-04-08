package ru.faang.school.hashmap.task_3;


import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>(List.of(
                new Student("student1", "IT", 1),
                new Student("student2", "Economic Sciences", 1),
                new Student("student3", "History", 2),
                new Student("student4", "History", 2),
                new Student("student4", "IT", 1),
                new Student("student5", "IT", 1)));

        Map<PairFacultyYear, List<Student>> studentMap = sortStudentsByFacultyAndYear(studentList);
        getAllStudents(studentMap);
        addStudentToMap(studentMap, new Student("student6", "Economic Sciences", 1));
        addStudentToMap(studentMap, new Student("student7", "Fake faculty", 10));
        System.out.println();
        getAllStudents(studentMap);
        System.out.println();
        removeStudentFromMap(studentMap, "student1", "IT", 1);
        removeStudentFromMap(studentMap, "student7", "Fake faculty", 10);
        removeStudentFromMap(studentMap, "123", "asd", 13);
        getAllStudents(studentMap);
        System.out.println();
        getByFacultyAndYear(studentMap, "IT", 1);
        System.out.println();
        getByFacultyAndYear(studentMap, "123", 123);


    }

    static Map<PairFacultyYear, List<Student>> sortStudentsByFacultyAndYear(List<Student> list) {
        Map<PairFacultyYear, List<Student>> studentMap = new HashMap<>();
        for (Student student : list) {
            addStudentToMap(studentMap, student);
        }
        return studentMap;
    }

    static void addStudentToMap(Map<PairFacultyYear, List<Student>> map, Student student) {
        PairFacultyYear pair = new PairFacultyYear(student.getFaculty(), student.getYear());
        List<Student> value = map.getOrDefault(pair, new ArrayList<>());
        value.add(student);
        map.put(pair, value);
    }

    static void removeStudentFromMap(Map<PairFacultyYear, List<Student>> map, String name, String faculty, int year) {
        PairFacultyYear pair = new PairFacultyYear(faculty, year);
        Student student = new Student(name, faculty, year);
        List<Student> value = map.getOrDefault(pair, new ArrayList<>());
        value.remove(student);
        if (value.isEmpty()) {
            map.remove(pair);
        } else {
            map.put(pair, value);
        }
    }

    static void getByFacultyAndYear(Map<PairFacultyYear, List<Student>> map, String faculty, int year) {
        PairFacultyYear pair = new PairFacultyYear(faculty, year);
        List<Student> list = map.getOrDefault(pair, new ArrayList<>());
        System.out.println("Список студентов " + faculty + " " + year + " курса:");
        for (Student student : list) {
            System.out.println(student.getName());
        }
    }

    static void getAllStudents(Map<PairFacultyYear, List<Student>> map) {
        for (Map.Entry<PairFacultyYear, List<Student>> entry : map.entrySet()) {
            System.out.println("Список учеников факультета " + entry.getKey().getFaculty() +
                    " " + entry.getKey().getYear() + " курса:");
            for (Student student : entry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }


}
