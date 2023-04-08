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


    }

    public static Map<Pair, List<Student>> createStudentMap(List<Student> studentList) {
        Map<Pair, List<Student>> studentMap = new HashMap<>();

        for (Student student : studentList) {
            Pair key = new Pair(student.getFaculty(), student.getYear());
            if (!studentMap.containsKey(key)) {
                studentMap.put(key, new ArrayList<>());
                System.out.println(key.toString());
            }
            studentMap.get(key).add(student);
        }

        return studentMap;
    }


}

