package ru.faang.school.hashmap.task_3;

import java.util.*;

public class Main {
    private Map<Pair, List<Student>> studentsMap = new HashMap<>();

    public void generateMap(List<Student> students) {
        for (Student student : students) {
            Pair pair = new Pair(
                    student.getFaculty(),
                    student.getYear()
            );

            if (studentsMap.get(pair) == null) {
                studentsMap.put(pair, new ArrayList<Student>());
            }

            if (studentsMap.get(pair).contains(student)) continue;

            studentsMap.get(pair).add(student);
        }
    }

    public void addStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        Pair pair = new Pair(
                student.getFaculty(),
                student.getYear()
        );

        if (!studentsMap.containsKey(pair)) {
            studentsMap.put(pair, new ArrayList<>());
        }

        if (studentsMap.get(pair).contains(student)) {
            System.out.println("Студент " + student.getName() + " уже находится в группе " + pair);
        } else {
            studentsMap.get(pair).add(student);
            System.out.println("Студент " + student.getName() + " добавлен в группу " + pair);
        }
    }

    public void removeStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        Pair pair = new Pair(faculty, year);

        if (!studentsMap.containsKey(pair)) {
            System.out.println("Студент " + name + " не найден");
        }

        if (!studentsMap.get(pair).contains(student)) {
            System.out.println("Студент " + name + " отсутствует в указанной группе " + faculty);
        } else {
            studentsMap.get(pair).remove(student);
            System.out.println("Студент " + name + " удален из группы " + faculty);
        }
    }

    public List<Student> findStudentsByGroup(String faculty, int year) {
        Pair pair = new Pair(faculty, year);

        if (!studentsMap.containsKey(pair)) {
            System.out.println("Группа " + pair + " не найдена");
        } else {
            return studentsMap.get(pair);
        }

        return new ArrayList<>();
    }

    public void showStudents() {
        for (Map.Entry<Pair, List<Student>> entry : studentsMap.entrySet()) {
            System.out.println(entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println("\t" + student.getName());
            }
        }
    }

    public void showStudents(String faculty, int year) {
        Pair pair = new Pair(faculty, year);

        if (!studentsMap.containsKey(pair)) {
            System.out.println("Группа " + pair + " не найдена");
        } else {
            List<Student> students = studentsMap.get(pair);
            System.out.println(pair);
            for (Student student : students) {
                System.out.println("\t" + student.getName());
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        List<Student> studentsList = List.of(
                new Student("Miron Yanovich", "Philosophy", 4),
                new Student("Linus Torvalds", "Operating systems", 2),
                new Student("Rodion Raskolnikov", "Сriminalistics", 1),
                new Student("Sonya Marmeladova", "Philosophy", 4),
                new Student("Linus Torvalds", "Operating systems", 2)
        );

        main.generateMap(studentsList);

        main.showStudents();
        System.out.println();

        main.addStudent("Eugene Onegin", "Literature", 2);
        main.addStudent("Winston Smith", "Literature", 2);
        System.out.println();

        main.showStudents();
        System.out.println();

        main.removeStudent("Sonya Marmeladova", "Philosophy", 4);
        main.removeStudent("Miron Yanovich", "Philosophy", 4);
        System.out.println();

        main.showStudents();
        System.out.println();

        main.showStudents("Literature", 2);
        System.out.println();

        main.showStudents("Information security", 1);
        System.out.println();

        List<Student> lst1 = main.findStudentsByGroup("Operating systems", 2);
        List<Student> lst2 = main.findStudentsByGroup("Information security", 1);
        System.out.println();
    }


}
