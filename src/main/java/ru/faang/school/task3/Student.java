package ru.faang.school.task3;

import java.util.*;

public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && Objects.equals(name, student.name) && Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("A", "B", 1));
        students.add(new Student("B", "B", 1));
        students.add(new Student("BA", "B", 1));
        students.add(new Student("C", "C", 2));
        students.add(new Student("CC", "C", 1));

        printAllStudentsGroupByFacultAndYear(createMap(students));
    }

    public static Map<String, List<Student>> createMap(List<Student> students) {
        Map<String, List<Student>> data = new HashMap<>();
        for (Student x : students) {
            String key = x.faculty + " : " + x.year;
            if (!data.containsKey(key)) {
                data.put(key, new ArrayList<>());
            }
            data.get(key).add(x);
        }
        return data;
    }

    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void deleteStudent(List<Student> students, Student student) {
        if (students.contains(student)) {
            students.remove(student);
        }
    }

    public static List<Student> findStudentsGroupByFacultAndYear(Map<String, List<Student>> data, String key) {
        return data.get(key);
    }

    public static void printAllStudentsGroupByFacultAndYear(Map<String, List<Student>> data) {
        for (Map.Entry<String, List<Student>> x : data.entrySet()) {
            System.out.println(
                    x.getValue()
            );
        }
    }
}
