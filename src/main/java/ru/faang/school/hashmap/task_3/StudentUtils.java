package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentUtils {

    private static List<Student> students = new ArrayList<>();

    public static void addNewStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.add(student);
        System.out.println("Student : " + student.getName() + " has been added to Student List");
    }

    public static void removeStudent(String name, String faculty, int year) {
        students.removeIf(student -> student.getName().equals(name)
                && student.getFaculty().equals(faculty)
                && student.getYear() == year);
        System.out.println("Student : " + name +" has been removed from the Student List");
    }

    public static List<Student> findStudentsByFacultyAndYear(String faculty, int year, Map<String, List<Student>> studentMap) {
        Map<String, List<Student>> studentsMap = groupStudentsByFacultyAndYear(students);
        String key = faculty + "-" + year;
        List<Student> students = studentsMap.get(key);
        if (students == null) {
            students = new ArrayList<>();
        }
        return students;
    }

    public static void printAllStudents(Map<String, List<Student>> studentMap) {

        for (String key : studentMap.keySet()) {
            System.out.println("Faculty : " + key.split("-")[0] + ", Year : " + key.split("-")[1] + ":");
            List<Student> students = studentMap.get(key);
            for (Student student : students) {
                System.out.println("***"+student.getName()+"***");
            }
        }
    }

    public static Map<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<String, List<Student>> map = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + "-" + student.getYear();
            List<Student> list = map.getOrDefault(key, new ArrayList<>());
            list.add(student);
            map.put(key, list);
        }
        return map;
    }
}
