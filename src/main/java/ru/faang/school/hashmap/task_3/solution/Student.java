package ru.faang.school.hashmap.task_3.solution;

import java.util.Objects;

public class Student {
    private final String name;
    private final String faculty;
    private final byte year;



    public Student(String name, String faculty, int year) {
        if (year < 1 || year > 4) throw new IllegalArgumentException("Illegal year(course).");
        if (Integer.parseInt(faculty) < 1 || Integer.parseInt(faculty) > 8) throw  new IllegalArgumentException("Illegal faculty.");
        this.name = name;
        this.faculty = faculty;
        this.year = (byte) year;
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
        return Objects.hash(name, faculty, year);
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public byte getYear() {
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

    public String getGroup() {
        return getFaculty() + "_" + getYear();
    }
    
}
