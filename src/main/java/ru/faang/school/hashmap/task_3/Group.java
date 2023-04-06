package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class Group {
    private String faculty;
    private int year;

    public Group(Student student) {
    this.faculty = student.getFaculty();
    this.year = student.getYear();
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

    @Override
    public String toString() {
        return faculty + " " + year;
    }
}
