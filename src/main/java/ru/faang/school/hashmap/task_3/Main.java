package ru.faang.school.hashmap.task_3;

import java.security.KeyPair;
import java.util.*;

public class Main {

    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        students.add(new Student("Vasya", "Faculty_1", 3));
        students.add(new Student("Petya", "Faculty_2", 1));
        students.add(new Student("Ivan", "Faculty_2", 2));
        students.add(new Student("Vlad", "Faculty_1", 3));
        students.add(new Student("Alex", "Faculty_3", 5));
        students.add(new Student("Gennadiy", "Faculty_2", 2));

        printAllStudentsGroupByFacultyAndYear();

        System.out.println(findStudentsByFacultyAndYear("Faculty_2", 2, students));
    }

    private static void addStudentToList(Student student) {
        students.add(student);
    }

    private static void removeStudentFromList(Student student) {
        students.remove(student);
    }

    private static List<Student> findStudentsByFacultyAndYear(String faculty, int year, List<Student> listOfStudentsForSeeking) {
        Pair pair = new Pair(faculty, year);
        return getStudents(listOfStudentsForSeeking).get(pair);
    }


    private static void printAllStudentsGroupByFacultyAndYear(){
        Map<Pair, List<Student>> map = getStudents(students);

        for (Map.Entry<Pair, List<Student>> entry : map.entrySet()) {
            for (Student student : entry.getValue()) {
                System.out.println(student);
            }
            System.out.println();
        }
    }

    private static Map<Pair, List<Student>> getStudents(List<Student> studentList) {
        Map<Pair, List<Student>> map = new HashMap<>();
        for (Student student : studentList) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            if (map.containsKey(pair)) {
                map.get(pair).add(student);
            } else {
                List<Student> list = new ArrayList<>();
                list.add(student);
                map.putIfAbsent(pair, list);
            }
        }
        return map;
    }


    private static class Pair {
        String faculty;
        int year;

        public Pair(String faculty, int year) {
            this.faculty = faculty;
            this.year = year;
        }

        public String getFaculty() {
            return faculty;
        }

        public int getYear() {
            return year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return year == pair.year && Objects.equals(faculty, pair.faculty);
        }

        @Override
        public int hashCode() {
            return Objects.hash(faculty, year);
        }
    }


}
