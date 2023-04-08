package ru.faang.school.hashmap.task_3.models;

import java.util.Objects;

public class Student {
    private String _name;
    private String _faculty;
    private int _year;

    public Student(String name, String faculty, int year) {
        _name = name;
        _faculty = faculty;
        _year = year;
    }

    public String getName() {
        return _name;
    }
    public String getFaculty() {
        return _faculty;
    }
    public void setFaculty(String value) {
        _faculty = value;
    }
    public int getYear() {
        return _year;
    }
    public void setYear(int value) {
        if (value <= 0)
            throw new IllegalArgumentException("Incorrect year.");

        _year = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }

        var s = (Student)obj;
        return getName().equals(s.getName()) &&
                getFaculty().equals(s.getFaculty()) &&
                getYear() == s.getYear();
    }
}
