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

    public Student(){}

    public String getName(){
        return name;
    }

    public String getFaculty(){
        return faculty;
    }

    public int getYear(){
        return year;
    }

}
