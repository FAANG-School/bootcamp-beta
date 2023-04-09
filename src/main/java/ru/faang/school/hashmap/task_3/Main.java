package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<Student> students = new ArrayList<>() {{
        add(new Student("sdfgsdfg", "филологический", 2));
        add(new Student("asdfasdf", "исторический", 4));
        add(new Student("sdfgsdfg", "юридический", 1));
        add(new Student("sadfasdf", "журналистики", 4));
        add(new Student("dsfgsdfg", "исторический", 3));
    }};

    public Map<Pair, List<Student>> returnStudents(List<Student> list) {
        Map<Pair, List<Student>> listMap = new HashMap<>();
        for (Student student : list) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            var list1 = list.stream()
                    .filter(i -> student.getFaculty().equals(i.getFaculty()))
                    .toList();
            listMap.put(pair, list1);
        }
        return listMap;
    }

    public static void addPerson(String name, String faculty, Integer year){
        students.add(new Student(name, faculty, year));
    }

    public static void removePerson(String name, String faculty, Integer year){
        students.remove(new Student(name, faculty, year));
    }

    public static ArrayList<Student> search(String faculty, Integer year) {
        ArrayList<Student> s = new ArrayList<>();
        for (var i : students) {
            if (i.getFaculty().equals(faculty) && i.getYear().equals(year)) {
                s.add(i);
            }
        }
        return s;
    }

    public static Map<String, List<Student>> group(List<Student> students) {
        Map<String, List<Student>> map = new HashMap<>();
        for (var i : students) {
            String value = i.getFaculty() + " " + i.getYear();
            List<Student> list = map.getOrDefault(value, new ArrayList<>());
            list.add(i);
            map.put(value, list);
        }
        return map;
    }

    public static void main(String[] args) {
        addPerson("asdfasdf", "филологический", 2);
        removePerson("asdfasdf", "юридический", 1);
        for (var i : search("юридический", 1)){
            System.out.println(i.getName());
        }
        for (Map.Entry<String, List<Student>> map : group(students).entrySet()) {
            System.out.println(map.getKey() + ": ");
            for (var i : map.getValue()) {
                System.out.println(i.getName());
            }
            System.out.println("---------");
        }
    }
}
