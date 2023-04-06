package ru.faang.school.hashmap.task_3.AlexTtkn_task_3;

import java.util.Objects;

public class Group {
    private String faculty;
    private int year;

    public Group(String faculty, int year) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return year == group.year && Objects.equals(faculty, group.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }
}
