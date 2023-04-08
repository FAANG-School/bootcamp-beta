package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class PairFacultyYear {
    private String faculty;
    private int year;

    public PairFacultyYear(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return faculty + " - " + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PairFacultyYear that = (PairFacultyYear) o;

        if (year != that.year) return false;
        return Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        int result = faculty != null ? faculty.hashCode() : 0;
        result = 31 * result + year;
        return result;
    }
}
