package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class Key {
    private String faculty;
    private int year;

    public Key(String faculty, int year) {
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
        if (!(o instanceof Key)) return false;
        Key key = (Key) o;
        return getYear() == key.getYear() && Objects.equals(getFaculty(), key.getFaculty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFaculty(), getYear());
    }

    @Override
    public String toString() {
        return "faculty='" + faculty + '\'' +
                ", year=" + year;
    }
}
