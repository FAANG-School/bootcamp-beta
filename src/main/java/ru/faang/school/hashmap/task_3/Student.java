package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class Student {

    private final String name;

    private final String faculty;

    private final int year;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && name.equals(student.name) && faculty.equals(student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculty, year);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }
}
