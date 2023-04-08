package ru.faang.school.hashmap.task_3;

import java.util.*;


public class Main {
    public static void main(String[] args) {

    List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("John", "Computer Science", 2));
        studentList.add(new Student("Jane", "Mathematics", 1));
        studentList.add(new Student("David", "Computer Science", 3));
        studentList.add(new Student("Mary", "Mathematics", 2));
        studentList.add(new Student("Alex", "Computer Science", 1));
        studentList.add(new Student("Dan", "Computer Science", 1));
        studentList.add(new Student("Lisa", "Mathematics", 3));
        System.out.println(getStudentsByFacultyAndYear(studentList, "Computer Science", 1));

        Map<String, List<Student>> groupedStudents = groupStudentsByFacultyAndYear(studentList);
        printGroupedStudents(groupedStudents);




}

    public static void printGroupedStudents(Map<String, List<Student>> groupedStudents) {
        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println("Faculty: " + entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println("    " + student.getName() + " - Year: " + student.getYear());
            }
        }
    }
    public static Map<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> studentList) {
        Map<String, List<Student>> groupedStudents = new HashMap<>();

        for (Student student : studentList) {
            String key = student.getFaculty() + "-" + student.getYear();
            if (!groupedStudents.containsKey(key)) {
                groupedStudents.put(key, new ArrayList<>());
            }
            groupedStudents.get(key).add(student);
        }

        return groupedStudents;
    }


    public static void addStudentToList(List<Student> studentList, String name, String faculty, int year) {
        studentList.add(new Student(name, faculty, year));
        System.out.println("Student " + name + " has been added to faculty " + faculty + "on " + year + " year of university" );
    }

    public static void removeStudentFromList(List<Student> studentList, String name, String faculty, int year) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equals(name) && student.getFaculty().equals(faculty) && student.getYear() == year) {
                iterator.remove();
                return;
            }
        }
    }

    public static List<Student> getStudentsByFacultyAndYear(List<Student> studentList, String faculty, int year) {
        List<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                students.add(student);
            }
        }
        return students;
    }

}
