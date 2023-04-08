package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentDAO {
    Map<Pair, List<Student>> groupedStudents;

    public StudentDAO(List<Student> students) {
        this.groupedStudents = groupByFacultyAndYear(students);
    }

    public void add(Student student) {
        isValid(student.name(), student.faculty(), student.year());
        Pair group = Pair.of(student.faculty(), student.year());

        // Если добавляется новый студент без группы, инициализируем значение мапы(список)
        groupedStudents.putIfAbsent(group, new ArrayList<>());
//        // Если такая группа сущуествует, то просто добавляем студента в список
        groupedStudents.get(group).add(student);
    }

    public void remove(String name, Faculty faculty, int year) {
        isValid(name, faculty, year);
        Pair group = Pair.of(faculty, year);
        if (!groupedStudents.containsKey(group))
            throw new GroupNotFoundException();

        Student toBeRemoved = groupedStudents.get(group)
                .stream()
                .filter(student -> student.name().equals(name))
                .findFirst()
                .orElseThrow(StudentNotFoundException::new);


    }

    public List<Student> findAll(Faculty faculty, int year) {
        isValid(faculty, year);

        // Возвращает пустой список, если группы не существует
        return groupedStudents.getOrDefault(Pair.of(faculty, year), Collections.emptyList());
    }

    private static Map<Pair, List<Student>> groupByFacultyAndYear(List<Student> students) {
        return students
                .stream()
                .collect(Collectors.groupingBy(student -> Pair.of(student.faculty(), student.year())));
    }

    public void printAll() {
        for (Map.Entry<Pair, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
            System.out.println("--------------------------------------------------------");
        }
    }

    private void isValid(String name, Faculty faculty, int year) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException();
        isValid(faculty, year);
    }

    private void isValid(Faculty faculty, int year) {
        if (faculty == null || (year <= 0 || year > 4))
            throw new IllegalArgumentException();
    }
}
