package ru.faang.school.hashmap.task_3.Students;

import ru.faang.school.hashmap.task_2.Westeros_Library.Book;

public class Student {
    private final String name;
    private final String faculty;
    private final int year;

    public Student(String name, String faculty, int year) {
        if (name == null || faculty == null || year < 0 || year > 5)
        {
            throw new RuntimeException("Invalid value!");
        }
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
    public int getYear() {
        return year;
    }
}

