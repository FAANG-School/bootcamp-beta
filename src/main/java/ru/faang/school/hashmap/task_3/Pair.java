package ru.faang.school.hashmap.task_3;

public class Pair {
    private String faculty;
    private Integer year;

    public Pair(String faculty, Integer year) {
        this.faculty = faculty;
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public String getFaculty() {
        return faculty;
    }
}
