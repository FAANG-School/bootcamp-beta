package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class Pair {
    String faculty;
    int year;

    public Pair(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty,year);
    }

    @Override
    public boolean equals(Object object) {
        Pair pair = (Pair) object;
        return (this.faculty.equals(pair.faculty) && this.year == pair.year);
    }

    @Override
    public String toString() {
        return this.faculty + " " + this.year;
    }
}

