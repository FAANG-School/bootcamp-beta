package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class Pair {

    private final String faculty;
    private final Integer year;

    public Pair(String faculty, Integer year) {
        this.faculty = faculty;
        this.year = year;
    }

    public String getFaculty() {
        return faculty;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (!Objects.equals(faculty, pair.faculty)) return false;
        return Objects.equals(year, pair.year);
    }

    @Override
    public int hashCode() {
        int result = faculty != null ? faculty.hashCode() : 0;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }
}
