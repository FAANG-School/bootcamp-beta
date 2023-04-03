package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        Student yami = new Student("Yami", "FOO", 2000);
        Student hachi = new Student("Hachi", "II", 3000);
        Student oleg = new Student("Oleg", "II", 3000);
        Student hashiro = new Student("Hashiro", "FOO", 2000);
        Student kiril = new Student("Kiril", "II", 3000);

        add(yami);
        add(hachi);
        add(oleg);
        add(hashiro);
        add(kiril);

        remove("Hachi", "II", 3000);

        Map<University, List<Student>> university = university(students);

        find("II", 3000, university);

        printAll(university);

    }

    private static void add(Student student) {
        students.add(student);
    }

    private static void remove(String name, String faculty, int year) {
        students.remove(new Student(name, faculty, year));
    }

    private static void find(String faculty, int year, Map<University, List<Student>> university) {
        List<Student> studentList = university.get(new University(faculty, year));

        if (studentList == null) {
            System.out.println("no found");
            return;
        }

        studentList.forEach(student -> System.out.println(student.getName()));
    }

    private static void printAll(Map<University, List<Student>> university) {
        university.forEach((university1, students1) -> {
            System.out.println(university1.toString() + " ");
            students1.forEach(student -> System.out.println(student.getName() + ", "));
        });
    }
    private static Map<University, List<Student>> university(List<Student> students) {

        Map<University, List<Student>> universityListMap = new HashMap<>();

        for (Student student : students) {

            University university = new University(student.getFaculty(), student.getYear());

            List<Student> studentList = universityListMap.get(university);

            if (studentList != null) {

                studentList.add(student);
                universityListMap.put(university, studentList);
                continue;
            }

            studentList = new ArrayList<>();
            studentList.add(student);

            universityListMap.put(university, studentList);
        }

        return universityListMap;
    }
}
