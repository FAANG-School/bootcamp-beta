package ru.faang.school.hashmap.task_3.Solution;

import java.io.IOException;
import java.util.Objects;

public class Student {
    private final String name;
    private final String faculty;
    private final int year;

    public Student(String name, String faculty, int year) throws IOException {
        this.name = name;
        this.faculty = faculty;
        if(year < 1 || year > 6)
            throw new IOException("year must be from 1 to 5");
        this.year = year;
    }

    public Student(Student s){
        this.name = s.name;
        this.faculty = s.faculty;
        this.year = s.year;
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
        return Objects.hash(name, faculty, year);
    }
}
