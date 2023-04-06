package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static {
        students.add(new Student("Bohdan", "Computer Science", 1));
        students.add(new Student("Andrii", "Physics", 4));
        students.add(new Student("Yevhenii", "Geography", 1));
        students.add(new Student("Vlad", "Math", 3));
        students.add(new Student("Anhelina", "Math", 1));
        students.add(new Student("Andrii", "Math", 3));
        students.add(new Student("Bohdan", "Physics", 4));
        students.add(new Student("Yulia", "Computer Science", 1));
        students.add(new Student("Liza", "Physics", 4));
    }
    public static void main(String[] args) {
        showAll();
    }

    public static void add(Student student) {
        if(students.contains(student)){
            System.out.println("This student is already recorded;");
            return;
        }
        students.add(student);
    }
    public static void remove(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        if(students.remove(student)){
            System.out.println("Student " + student.getName() +" deleted.");
        } else {
            System.out.println("This student was not recorded yet.");
        }
    }
    public static void search(String faculty, int year){
        List<Student> currentGroup = Group.formGroup(students).get(new Group(faculty, year));
        if(currentGroup != null) {
            System.out.println("Student(-s) from faculty: " + faculty + ". Year: " + year + ".");
            for(Student student : currentGroup) {
                System.out.println("Name: " + student.getName() + " Faculty: " + student.getFaculty() + " Year: " + student.getYear());
            }
        } else {
            System.out.println("Group wasn't recorded.");
        }
    }
    public static void showAll() {
        for(Map.Entry<Group, List<Student>> entry : Group.formGroup(students).entrySet()) {
            System.out.println("Faculty : " + entry.getKey().getFaculty() + ". Year: " + entry.getKey().getYear() + ".");
            for(Student student : entry.getValue()){
             System.out.println("Name: " + student.getName());
            }
            System.out.println();
        }
    }
}
