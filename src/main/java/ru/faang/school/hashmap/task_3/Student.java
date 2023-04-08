package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class Student {
    String name, faculty, year;

    public Student(String name, String faculty, String year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(faculty, student.faculty) && Objects.equals(year, student.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculty, year);
    }
}
