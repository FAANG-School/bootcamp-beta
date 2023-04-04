package ru.faang.school.hashmap.task_3;

import java.util.*;

public class Main {
    private List<Student> STUDENTS;

    public Main() {
        STUDENTS = new ArrayList<>();
        this.addStudent(new Student("Sevya", "PTO", "1"));
        this.addStudent(new Student("Kolya", "STO", "2"));
        this.addStudent(new Student("Fedya", "KSO", "1"));
        this.addStudent(new Student("Senya", "KSO", "5"));
        this.addStudent(new Student("Vasya", "PTO", "3"));
        this.addStudent(new Student("Lesha", "STO", "2"));
        this.addStudent(new Student("Petya", "KSO", "1"));
        this.addStudent(new Student("Pitya", "KSO", "3"));
        this.addStudent(new Student("Patya", "STO", "4"));
        this.addStudent(new Student("Potya", "STO", "2"));
        this.addStudent(new Student("Visya", "STO", "4"));
        this.addStudent(new Student("Visya", "PTO", "2"));
        this.addStudent(new Student("Fidya", "PTO", "2"));


    }

    public void addStudent(Student student) {
        STUDENTS.add(student);
    }

    public void removeStudent(String name, String faculty, String year) {
        Student removedStudent = new Student(name, faculty, year);
        for (Student student : STUDENTS) {
            if (student.equals(removedStudent)) {
                STUDENTS.remove(student);
                return;
            }
        }
        System.out.println("Student is not found");
    }

    public void getStudentsByFacultyAndYear(String faculty, String year) {
        Map<Pair, List<Student>> map = listStudentToMap(STUDENTS);
        List<Student> result = map.get(new Pair(faculty, year));
        if (result == null) {
            System.out.println("Students are not found");
        } else {
            for (Student student : result) {
                System.out.println(student.getName() + " " + student.getFaculty() + " " + student.getYear());
            }
        }
    }

    public void showStudentSortByFacultyAndYear() {
        Map<Pair, List<Student>> map = listStudentToMap(STUDENTS);
        for (Map.Entry<Pair, List<Student>> entry : map.entrySet()) {
            for (Student student : entry.getValue()) {
                System.out.println(student.getName() + " " + student.getFaculty() + " " + student.getYear());
            }
        }
    }

    private Map<Pair, List<Student>> listStudentToMap(List<Student> students) {
        Map<Pair, List<Student>> result = new HashMap<>();
        for (Student student : students) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            result.putIfAbsent(pair, new ArrayList<>());
            result.get(pair).add(student);
        }
        return result;
    }
}

class Pair {
    final String FACULTY;
    final String YEAR;

    public Pair(String faculty, String year) {
        FACULTY = faculty;
        YEAR = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return FACULTY.equals(pair.FACULTY) && YEAR.equals(pair.YEAR);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FACULTY, YEAR);
    }
}
