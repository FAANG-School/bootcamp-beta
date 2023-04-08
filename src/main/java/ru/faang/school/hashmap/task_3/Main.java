package ru.faang.school.hashmap.task_3;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    List<Student> students = new ArrayList<>() {{
        add(new Student("aaa", new Pair("филологический", 2)));
        add(new Student("bbb", new Pair("филологический", 2)));
        add(new Student("ccc", new Pair("журналистики", 3)));
        add(new Student("ddd", new Pair("журналистики", 4)));
        add(new Student("eee", new Pair("исторический", 1)));
        add(new Student("fff", new Pair("юридический", 3)));
    }};

    public Map<Pair, List<Student>> map = new HashMap<>();

    public Map<Pair, List<Student>> addStudents(List<Student> list) {
        for (Student student : students) {
            Pair pair = student.getPair();
            if (!map.containsKey(pair))
                map.put(pair, students.stream()
                        .filter(i -> Objects.equals(pair, i.getPair())).collect(Collectors.toList()));
        }
        return map;
    }


    public void addNewStudent(Student student) {
        Pair pair = student.getPair();
        if (map.containsKey(pair))
            map.get(pair).add(student);
        else
            map.put(pair, new ArrayList<>(List.of(student)));
    }

    public String searchStudentsByPair(Pair pair) {
        for (var key : map.keySet()) {
            if (Objects.equals(key, pair)) {
                return (map.get(key).toString());
            }
        }
        return null;
    }

    public String getAllStudents() {
        StringBuilder sb = new StringBuilder();
        map.forEach((Key, Value) -> sb.append(Key).append("\n").append(Value));
        return sb.toString();
    }

}
