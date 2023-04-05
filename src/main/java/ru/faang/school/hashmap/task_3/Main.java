package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        students.add(new Student("Tregulov", "Computer Science", 2));
        students.add(new Student("Alishev", "Computer Science", 1));
        students.add(new Student("Fukuyama", "History", 3));
        students.add(new Student("Dreiser", "Economy", 2));
        students.add(new Student("Herodotus", "History", 1));
        students.add(new Student("Ronaldo", "Sport", 5));
        students.add(new Student("Messi", "Sport", 4));
        students.add(new Student("Kant", "Philosophy", 3));
        students.add(new Student("Marks", "Philosophy", 3));

        //0. Converting List of Students to Map
        Map<String ,List<Student>> studentMap = StudentUtils.groupStudentsByFacultyAndYear(students);

        // 1. Adding new student to list
        StudentUtils.addNewStudent("Einstein", "Physics", 5);


        //2. Removing Student from list
        StudentUtils.removeStudent("Messi", "Sport", 4);

        //3. Find all Students by specific faculty and year
        System.out.println(StudentUtils.findStudentsByFacultyAndYear("Philosophy", 5, studentMap));

        //4. Printing all Students
        StudentUtils.printAllStudents(studentMap);
    }
}
