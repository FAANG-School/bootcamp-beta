package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Student> list = new ArrayList<>();
    static Map<Pair, List<Student>> map = new HashMap<>();

    public static Map<Pair, List<Student>> addMap(List<Student> list){
        for (Student student: list){
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            if (map.containsKey(pair)){
                map.get(pair).add(student);
            } else {
                List<Student> newList = new ArrayList<>();
                newList.add(student);
                map.put(pair, newList);
            }
        }
        return map;
    }

    public static void listOfAllStudent(){
        for (Map.Entry<Pair, List<Student>> entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void addStudent(Student student){
        list.add(student);
    }

    public static void removeStudent(Student student){
        list.remove(student);
    }

    public static void findStudentOfFaculty(Pair pair){
        map.get(pair);
    }

    public static void main(String[] args) {
        addStudent(new Student("Мынта Павел", "Судомеханический факультет", 4));
        addStudent(new Student("Романов Леонид", "Судомеханический факультет", 3));
        System.out.println(addMap(list));
        listOfAllStudent();
    }

}
