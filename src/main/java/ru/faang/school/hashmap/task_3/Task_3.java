package ru.faang.school.hashmap.task_3;

import ru.faang.school.hashmap.task_3.models.Student;
import java.util.*;

public class Task_3 {
    public static void main(String[] args) {
        var students = new ArrayList<Student>();
        students.add(new Student("Олег", "Горное дело", 4));
        students.add(new Student("Григорий", "Ядерная физика", 2));
        students.add(new Student("Хазар", "Горное дело", 3));
        students.add(new Student("Леонид", "Ядерная физика", 3));
        students.add(new Student("Генадий", "Горное дело", 4));
        students.add(new Student("Максим", "Горное дело", 3));
        students.add(new Student("Николай", "Ядерная физика", 2));

        var map = GetStudentsMap(students);

        RemoveStudent(map, "Леонид", "Ядерная физика", 3);
        PrintStudents(map);

        System.out.println("\n");
        var stds = SearchStudents(map, "Горное дело", 3);
        for (var s : stds) {
            System.out.println(s.getName());
        }
    }

    private static Map<Map.Entry<String, Integer>, List<Student>> GetStudentsMap(List<Student> students) {
        var map = new HashMap<Map.Entry<String, Integer>, List<Student>>();

        for (var student : students) {
            AddStudent(map, student);
        }

        return map;
    }
    private static Map<Map.Entry<String, Integer>, List<Student>> AddStudent(Map<Map.Entry<String, Integer>,List<Student>> map, Student student) {
        var key = new AbstractMap.SimpleEntry<>(student.getFaculty(), student.getYear());
        var entry = map.getOrDefault(key, null);

        if (entry == null) {
            var list = new ArrayList<Student>();
            list.add(student);
            map.put(key, list);
            return map;
        }

        entry.add(student);
        return map;
    }
    private static Map<Map.Entry<String, Integer>, List<Student>> RemoveStudent(Map<Map.Entry<String, Integer>, List<Student>> map, String name, String faculty, int year) {
        var key = new AbstractMap.SimpleEntry<String, Integer>(faculty, year);

        if (!map.containsKey(key)) {
            return map;
        }

        var list = map.get(key);
        list.remove(new Student(name, faculty, year));
        if (list.isEmpty())
            map.remove(key);

        return map;
    }
    private static List<Student> SearchStudents(Map<Map.Entry<String, Integer>,List<Student>> map, String faculty, int year) {
        var key = new AbstractMap.SimpleEntry<>(faculty, year);

        return map.get(key);
    }
    private static void PrintStudents(List<Student> students) {
        var map = GetStudentsMap(students);

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey().getKey() + " " + entry.getKey().getValue());
            for (var s : entry.getValue()) {
                System.out.println("\t" + s.getName());
            }
        }
    }
    private static void PrintStudents(Map<Map.Entry<String, Integer>,List<Student>> map) {
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey().getKey() + " " + entry.getKey().getValue());
            for (var s : entry.getValue()) {
                System.out.println("\t" + s.getName());
            }
        }
    }
}
