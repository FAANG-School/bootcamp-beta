package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class PairKey {
    String faculty, year;

    public PairKey(String faculty, String year) {
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public String toString() {
        return "faculty='" + faculty +
                ", year='" + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairKey pairKey = (PairKey) o;
        return Objects.equals(faculty, pairKey.faculty) && Objects.equals(year, pairKey.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

}
