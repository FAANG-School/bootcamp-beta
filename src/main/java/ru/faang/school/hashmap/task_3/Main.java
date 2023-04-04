package ru.faang.school.hashmap.task_3;

import java.util.*;

public class Main {
    private List<Student> STUDENTS;

    public Main() {
        STUDENTS = new ArrayList<>();
    }

    public void addStudent(Student student) {
        STUDENTS.add(student);
    }

    public void getStudentByFacultyAndYear(String faculty, String year) {
        Map<Pair, List<Student>> map =
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
