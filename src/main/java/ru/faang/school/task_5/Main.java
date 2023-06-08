package ru.faang.school.task_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> studends = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.addStudent("Виталий Борзников", "Ученый по C#", 3);
        main.addStudent("Владимир Хиль", "Java программист", 1);
        main.addStudent("Евгений Иващенко", "Java программист", 1);
        main.addStudent("Азат Малиев", "Java программист", 1);
        main.addStudent("Влад Коровко", "Учитель танцев", 2);
        main.addStudent("Наташа Безымянная", "Учитель танцев", 2);
        main.addStudent("Инна Копникова", "Учитель танцев", 3);
        main.addStudent("Ремми Магдалиев", "Иностранные языки", 1);
        System.out.println(main.groupInfo(studends));
        main.studentSearch("Иностранные языки", 1);
        main.removeStudent("Ремми Магдалиев", "Иностранные языки", 1);
        main.studentSearch("Иностранные языки", 1);
    }

    public Map<Pair, List<Student>> groupInfo(List<Student> studends) {
        Map<Pair, List<Student>> groups = new HashMap<>();
        for (Student student : studends) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            groups.put(pair, studentSearchList(pair.getFaculty(), pair.getYear()));
        }
        return groups;
    }

    public void addStudent(String name, String faculty, int year) {
        studends.add(new Student(name, faculty, year));
    }

    public void removeStudent(String name, String faculty, int year) {
        studends.remove(new Student(name, faculty, year));
    }

    public List<Student> studentSearchList(String faculty, int year) {
        List<Student> list = new ArrayList<>();
        for (Student student : studends) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                list.add(student);
            }
        }
        return list;
    }

    public void studentSearch(String faculty, int year) {
        int count = 0;
        for (Student student : studends) {
            if (student.getFaculty().equalsIgnoreCase(faculty) && student.getYear() == year) {
                ++count;
                System.out.printf("%d: %s%n", count, student.getName());
            }
        }
        if (count == 0) {
            System.out.println("Данной группы на этом курсе не существует");
        }
    }
}
