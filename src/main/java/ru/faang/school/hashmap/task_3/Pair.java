package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class Pair {

    private String faculty;
    private int year;

    public Pair(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return year == pair.year && Objects.equals(faculty, pair.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }
}
