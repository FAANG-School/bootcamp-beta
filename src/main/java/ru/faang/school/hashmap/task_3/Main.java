package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private List<Student> students;
    private Map<FacultyYear, List<Student>> facultyYearMap;

    public Main() {
        students = new ArrayList<>();
        facultyYearMap = new HashMap<>();
    }

    public static void main(String[] args) {
        Main main = new Main();
        Student s1 = new Student("Ivan", "Phys-tech", 1);
        Student s2 = new Student("Kolya", "IKSS", 2);
        Student s3 = new Student("Maksim", "IKSS", 2);
        Student s4 = new Student("Ilya", "Phys-tech", 1);
        Student s5 = new Student("Andrey", "IKSS", 4);
        List<Student> list = new ArrayList<>(List.of(s1, s2, s3));
        main.setStudents(list);
        main.addStudent(s4);
        main.addStudent(s5);
        main.remove("Andrey", "IKSS", 4);
        System.out.println(main.getFacultyYearMap());
        System.out.println(main.getStudentsByFacultyYear("Phys-tech", 1));
        main.printStudentsGroupedByFacultyYear();
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        facultyYearMap = generateStudentsMap();
    }

    public Map<FacultyYear, List<Student>> generateStudentsMap() {
        Map<FacultyYear, List<Student>> map = new HashMap<>();
        for (Student s : students) {
            if (!map.containsKey(s.getPair())) {
                map.put(s.getPair(), new ArrayList<>());
            }
            map.get(s.getPair()).add(s);
        }
        return map;
    }

    public Map<FacultyYear, List<Student>> getFacultyYearMap() {
        return facultyYearMap;
    }

    public void addStudent(Student s) {
        students.add(s);
        FacultyYear pair = s.getPair();
        List<Student> students = facultyYearMap.getOrDefault(pair, new ArrayList<>());
        students.add(s);
        facultyYearMap.put(pair, students);
    }

    public void remove(String name, String faculty, Integer year) {
        Student s = new Student(name, faculty, year);
        students.remove(s);
        FacultyYear pair = new FacultyYear(faculty, year);
        if (facultyYearMap.get(pair).size()<=1) {
            facultyYearMap.remove(pair);
        }
        else {
            facultyYearMap.get(pair).remove(s);
        }
    }

    public List<Student> getStudentsByFacultyYear(String faculty, Integer year) {
        return facultyYearMap.get(new FacultyYear(faculty, year));
    }

    public void printStudentsGroupedByFacultyYear() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Список всех студентов сгруппированных по факультетам и курсам:");
        for (Map.Entry<FacultyYear, List<Student>> entry : facultyYearMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Student s : entry.getValue()) {
                System.out.println("\t"+s.getName());
            }
        }
        System.out.println("--------------------------------------------------------------");
    }

}
