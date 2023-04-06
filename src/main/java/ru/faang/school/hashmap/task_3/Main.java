package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    static Map<Key, List<Student>> studentsToMap (List<Student> list) {
        Map<Key,List<Student>> mapStudents = new HashMap<>();

        for(var student : list) {
            addStudent(student,mapStudents);
        }

        return mapStudents;
    }

    static void printAll(Map<Key, List<Student>> students) {
        for(var entry : students.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(" : ");
            for(var student : entry.getValue()) {
                System.out.print(student.getName() + "; ");
            }
            System.out.println();
        }
        System.out.println("-----");
    }

    static void addStudent(Student student, Map<Key, List<Student>> mapStudents) {
        Key facultyNyear = new Key(student.getFaculty(), student.getYear());

        if(!mapStudents.containsKey(facultyNyear)) {
            mapStudents.put(facultyNyear, new ArrayList<Student>());
            mapStudents.get(facultyNyear).add(student);
        } else {


            mapStudents.get(facultyNyear).add(student);
        }
    }

    static void deleteStudent(Student student, Map<Key, List<Student>> mapStudents) {
        Key facultyNyear = new Key(student.getFaculty(), student.getYear());
        mapStudents.get(facultyNyear).remove(student);
        if(mapStudents.get(facultyNyear).size()==0) {
            mapStudents.remove(facultyNyear);
        }
    }

    static void findStudents(String faculty, int year, Map<Key, List<Student>> mapStudents) {
        Key facultyNyear = new Key(faculty,year);
        for(var entry : mapStudents.entrySet()) {
            if(entry.getKey().equals(facultyNyear)) {
                System.out.print(entry.getKey());
                System.out.print(" : ");
                for(var student : entry.getValue()) {
                    System.out.print(student.getName() + "; ");
                }
                System.out.println();
            }
        }
        System.out.println("-----");
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivanov Ivan", "Physics", 1));
        students.add(new Student("Petrov Petr", "Physics", 1));
        students.add(new Student("Sidorov Kolya", "VMK", 2));
        students.add(new Student("Zaicev Misha", "Mech-mat", 1));
        students.add(new Student("Taburetkin Pavel", "Mech-mat", 1));
        students.add(new Student("Mishustin Vlad", "VMK", 2));
        students.add(new Student("Kabanov Lesha", "VMK", 2));

        Map<Key, List<Student>> mapStudents = studentsToMap(students);

        Student student = new Student("Kozlov Ilya", "Physics", 2);
        addStudent(student, mapStudents);
        printAll(mapStudents);
        deleteStudent(student,mapStudents);
        printAll(mapStudents);

        findStudents("VMK", 2, mapStudents);

    }
}
