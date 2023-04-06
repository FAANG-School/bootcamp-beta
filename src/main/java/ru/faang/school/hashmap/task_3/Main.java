package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student("Ivanov", "Physic",  5));
        students.add(new Student("Petrov", "Physic",  5));
        students.add(new Student("Metrov", "Math",  5));
        students.add(new Student("Litrov", "Physic",  1));
        students.add(new Student("Vetrov", "Math",  5));
    }

    public static void main(String[] args) {
        printAllStudentsGrouped(students);
        addStudent(students, "Козявин", "Math", 4);
        System.out.println(getStudentsByFacultyAndYear("Physic", 5, students));
        System.out.println(removeStudent(students, "Litrov", "Physic", 1));
        printAllStudentsGrouped(students);

    }

    public static Map<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> allStudents){
        Map<String, List<Student>> map = new HashMap<>();
        String facultyAndYear;
        for (Student student : allStudents) {
            facultyAndYear = student.getFaculty() + student.getYear();
            if(map.containsKey(facultyAndYear)){
                map.get(facultyAndYear).add(student);
            }else {
                List<Student> groupedStudents = new ArrayList<>();
                groupedStudents.add(student);
                map.put(facultyAndYear, groupedStudents);
            }
        }
        return map;
    }

    public static boolean addStudent(List<Student> allStudents, String name, String faculty, int year){
        return allStudents.add(new Student(name, faculty, year));
    }

    public static boolean removeStudent(List<Student> allStudents, String name, String faculty, int year){
        return allStudents.remove(new Student(name, faculty, year));
    }

    public static List<Student> getStudentsByFacultyAndYear(String faculty, int year, List<Student> allstudents){
        return groupStudentsByFacultyAndYear(allstudents).get(faculty + year);
    }

    public static void printAllStudentsGrouped(List<Student> allStudents){
        var groupedMap = groupStudentsByFacultyAndYear(allStudents);
        for (String facultyAndYear : groupedMap.keySet()) {
            System.out.println(facultyAndYear + ":");
            for (Student student : groupedMap.get(facultyAndYear)) {
                System.out.println("   - " + student);
            }
        }
    }
}
