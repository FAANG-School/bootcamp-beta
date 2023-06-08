package ru.faang.school.task_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> studends = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.addStudent("Vitaliy", "Scientist", 3);
        main.addStudent("Vladimir", "Programmer", 1);
        main.addStudent("Yevhenii", "Programmer", 1);
        main.addStudent("Azat", "Programmer", 1);
        main.addStudent("Vlad", "Dancer", 2);
        main.addStudent("Natasha", "Dancer", 2);
        main.addStudent("Inna", "Dancer", 3);
        main.addStudent("Remmi", "Halloween", 1);
        System.out.println(main.groupInfo(studends));
        main.studentSearch("Halloween", 1);
        main.removeStudent("Remmi", "Halloween", 1);
        main.studentSearch("Halloween", 1);
    }

    public Map<Pair, List<Student>> groupInfo(List<Student> studends) {
        Map<Pair, List<Student>> groups = new HashMap<>();
        for (Student student : studends) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            groups.put(pair, studentSearchList(pair.getFaculty(), pair.getYear()));
        }
        return groups;
    }

    public void addStudent(String name, String faculty, int year) {
        studends.add(new Student(name, faculty, year));
    }

    public void removeStudent(String name, String faculty, int year) {
        studends.remove(new Student(name, faculty, year));
    }

    public List<Student> studentSearchList(String faculty, int year) {
        List<Student> list = new ArrayList<>();
        for (Student student : studends) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                list.add(student);
            }
        }
        return list;
    }

    public void studentSearch(String faculty, int year) {
        int count = 0;
        for (Student student : studends) {
            if (student.getFaculty().equalsIgnoreCase(faculty) && student.getYear() == year) {
                ++count;
                System.out.printf("%d: %s%n", count, student.getName());
            }
        }
        if (count == 0) {
            System.out.println("На таком курсе данной группы не существует.");
        }
    }
}
