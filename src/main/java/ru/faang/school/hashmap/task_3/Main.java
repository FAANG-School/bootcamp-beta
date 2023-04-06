package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private final Map<Pair, List<Student>> map = new HashMap<>();

    private final List<Student> students = new ArrayList<>() {{
        add(new Student("Student1", "economics", 1));
        add(new Student("Student2", "maths", 1));
        add(new Student("Student3", "logistics", 2));
        add(new Student("Student4", "logistics", 3));
        add(new Student("Student5", "logistics", 3));
        add(new Student("Student6", "economics", 4));
    }};

    public Map<Pair, List<Student>> getMap() {
        return map;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void createStudentsMap(List<Student> students) {
        for (Student student : students) {
            insertStudentIntoMap(student);
        }
    }

    public void addStudent(Student student) {
        insertStudentIntoMap(student);
    }

    private void insertStudentIntoMap(Student student) {
        Pair keyPair = new Pair(student.getFaculty(), student.getYear());
        if (!map.containsKey(keyPair)) {
            map.put(keyPair, new ArrayList<>());
            map.get(keyPair).add(student);
        } else {
            map.get(keyPair).add(student);
        }
    }

    public void deleteStudent(String name, String faculty, int year) {
        Pair keyPair = new Pair(faculty, year);
        if (map.containsKey(keyPair)) {
            for (Map.Entry<Pair, List<Student>> entry : map.entrySet()) {
                entry.getValue().removeIf(x -> x.getName().equals(name) && x.getFaculty().equals(faculty) && x.getYear() == year);

            }
        }
    }

    public List<Student> getStudentsByFacultyAndYear(Pair pair) {
        return map.get(pair).stream().toList();
    }

    public Map<List<Student>, List<Pair>> groupStudentsByFacultyAndYear() {
        return map.keySet().stream().collect(Collectors.groupingBy(map::get));
    }
}
