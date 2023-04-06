package ru.faang.school.hashmap.task_3.solution;

import java.util.*;

public class Main {
    private static final List<Student> students = new ArrayList<>();
    private static final Map<String, List<Student>> studentsByGroups = new HashMap<>();

    // Заполняем список студентов
    static {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            students.add(new Student(
                    String.valueOf(random.nextInt(100) + 1),
                    String.valueOf(random.nextInt(8) + 1),
                    (int) (random.nextInt(4) + 1))
            );
        }
    }

    public static void main(String[] args) {
        groupStudents(students);
        showStudentsByGroups();
        addStudentToGroup(new Student("Anton", "4", 2));
        showStudentsByGroups();
        removeStudent("Anton", "4", 2);
        showStudentsByGroups();
        searchGroup("9", 2);
        searchGroup("4", 2);
    }

    public static void groupStudents(List<Student> students) {
        Set<String> groups = new HashSet<>(); // Сет, который содержит все группы
        students.forEach(student -> groups.add(student.getGroup()));

        groups.forEach(group -> { // Заполняем мапу по группам
            List<Student> studentsByGroup = new ArrayList<>(); // временный список для студентов конкрентной группы
            students.forEach(student -> {
                if ((student.getGroup()).equals(group)) studentsByGroup.add(student);
            });
            studentsByGroups.put(group, studentsByGroup);
        });
    }

    public static void addStudentToGroup(Student student) {
        students.add(student);
        studentsByGroups.get(student.getGroup()).add(student);
    }

    public static void removeStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.remove(student);
        studentsByGroups.get(student.getGroup()).remove(student);
    }

    public static void showStudentsByGroups() {
        for (Map.Entry<String, List<Student>> entry : studentsByGroups.entrySet()) {
            System.out.println("Группа: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }

    public static void searchGroup(String faculty, int year) {
        try {
            System.out.println("Студенты группы #" + faculty + "_" + year);
            studentsByGroups.get(faculty + "_" + year).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Группа не найдена :(");
        }
    }
    
    public static void removeAllStudents() {
        students.clear();
        studentsByGroups.clear();
    }


}
