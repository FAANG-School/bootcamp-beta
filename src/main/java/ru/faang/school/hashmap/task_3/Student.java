package ru.faang.school.hashmap.task_3;

public class Student {
    private String name;
    private String faculty;
    private String year;

    public Student(String name, String faculty, String year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getYear() {
        return year;
    }
}
