package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class Student {
    private static final int YEAR_MAX_VALUE = 7;
    private final String name;
    private final String faculty;
    private final int year;


    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        if (year > 0 && year <= YEAR_MAX_VALUE) {
            this.year = year;
        }
        else {
            throw new IllegalArgumentException("недопустимое значение курса");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getYear() == student.getYear() && Objects.equals(getName(), student.getName()) && Objects.equals(getFaculty(), student.getFaculty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFaculty(), getYear());
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
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }
}
