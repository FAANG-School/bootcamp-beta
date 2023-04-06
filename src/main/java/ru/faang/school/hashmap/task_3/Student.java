package ru.faang.school.hashmap.task_3;

public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
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

    @Override
    public boolean equals(Object o) {
        Student student = (Student) o;
        return this.faculty.equals(student.faculty)
                && this.name.equals(student.name)
                && this.year == student.year;
    }
}
