package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class Pair {
    private String faculty;
    private int year;

    public Pair(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (year != pair.year) return false;
        return Objects.equals(faculty, pair.faculty);
    }

    @Override
    public int hashCode() {
        int result = faculty != null ? faculty.hashCode() : 0;
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return "Факультет : " + faculty + " Курс : " + year;
    }
}
