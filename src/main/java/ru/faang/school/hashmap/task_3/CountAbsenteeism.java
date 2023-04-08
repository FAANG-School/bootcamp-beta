package ru.faang.school.hashmap.task_3;

import java.util.*;

public class CountAbsenteeism {
    public static void main(String[] args){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("John Doe", "Engineering", 2));
        studentList.add(new Student("Jane Smith", "Engineering", 2));
        studentList.add(new Student("Alice Johnson", "Medicine", 4));
        studentList.add(new Student("Bob Brown", "Law", 1));
        Map<Pair, List<Student>> studentMap = createStudentMap(studentList);
        outputMap(studentMap);
        put(studentMap, new Student("Jane Brown", "Medicine", 4));
        outputMap(studentMap);
        remove(studentMap , "Alice Johnson", "Medicine", 4);
        outputMap(studentMap);
        searchByFacultyAndYear(studentMap,"Engineering", 2);
    }

    public static void searchByFacultyAndYear(Map<Pair, List<Student>> studentMap, String faculty, int year){
        Pair pair = new Pair(faculty, year);
        System.out.println();
        System.out.println("-----------------Search result-----------------");
        for (Map.Entry<Pair, List<Student>> entry : studentMap.entrySet()) {
            Pair key = entry.getKey();
            if (key.equals(pair)) {
                List<Student> value = entry.getValue();
                System.out.println("Faculty and Year: " + key);
                for (Student student : value) {
                    System.out.println(student.toString());
                }
            }
        }
    }

    public static void remove(Map<Pair, List<Student>> studentMap, String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        Pair key = new Pair(student.getFaculty(), student.getYear());
        studentMap.get(key).remove(student);
    }


    public static Map<Pair, List<Student>> createStudentMap(List<Student> studentList) {
        Map<Pair, List<Student>> studentMap = new HashMap<>();

        for (Student student : studentList) {
            Pair key = new Pair(student.getFaculty(), student.getYear());
            if (!studentMap.containsKey(key)) {
                studentMap.put(key, new ArrayList<>());
            }
            studentMap.get(key).add(student);
        }
        return studentMap;
    }

    public static void put( Map<Pair, List<Student>> studentMap, Student student){
        Pair key = new Pair(student.getFaculty(), student.getYear());
        if (!studentMap.containsKey(key)) {
            studentMap.put(key, new ArrayList<>());
        }
        studentMap.get(key).add(student);
    }

    public static void outputMap( Map<Pair, List<Student>> studentMap){
        System.out.println();
        System.out.println("-----------------Output result-----------------");
        for (Map.Entry<Pair, List<Student>> entry : studentMap.entrySet()) {
            Pair key = entry.getKey();
            List<Student> value = entry.getValue();
            System.out.println("Faculty and Year: " + key.toString());
            for (Student student : value) {
                System.out.println(student.toString());
            }
        }
    }


}

