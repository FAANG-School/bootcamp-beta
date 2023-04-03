package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class University {
    private final String faculty;
    private final int year;

    public University(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getFaculty() {
        return faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return year == that.year && Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

    @Override
    public String toString() {
        return "University{" +
                "faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }
}
