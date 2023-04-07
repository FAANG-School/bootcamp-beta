package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class Student {
    private String name;
    private String faculty;
    private Integer year;

    public Student(String name, String faculty, Integer year) {
        this.name = name;
        this.faculty = faculty;
        if (year<1 || year>5) {
            throw new IllegalArgumentException("Невалидный курс");
        }
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        if (year<1 || year>5) {
            throw new IllegalArgumentException("Невалидный курс");
        }
        this.year = year;
    }

    public FacultyYear getPair() {
        return new FacultyYear(faculty,year);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year=" + year +
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
