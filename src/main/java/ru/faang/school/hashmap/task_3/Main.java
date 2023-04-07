package ru.faang.school.hashmap.task_3;

import java.util.*;

public class Main {
    static HashMap<Map.Entry<String, Integer>, List<Student>> facultyHashMap = new HashMap<>();
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Вася", "Экономический", 2019));
        studentList.add(new Student("Петя", "Экономический", 2019));
        studentList.add(new Student("Саша", "Экономический", 2020));
        studentList.add(new Student("Маша", "Филологический", 2019));
        studentList.add(new Student("Вася", "Филологический", 2019));
        studentList.add(new Student("Гриша", "Филологический", 2019));
        studentList.add(new Student("Миша", "Математический", 2020));
        studentList.add(new Student("Илья", "Математический", 2020));
        studentList.add(new Student("Влад", "Математический", 2019));
        studentList.add(new Student("Марина", "Биологический", 2021));
        studentList.add(new Student("Полина", "Биологический", 2021));
        studentList.add(new Student("Анна", "Биологический", 2021));
        studentList.add(new Student("Алексей", "Биологический", 2019));
        studentList.add(new Student("Антон", "Биологический", 2019));
        studentList.add(new Student("Арина", "Экономический", 2019));
        facultyHashMap = sortStudentAndAddFacultyHashMap(studentList);
        printInfo();
        System.out.println("_____________");
        addStudent("Степан", "Экономический", 2019);
        addStudent("Николай", "Экономический", 2019);
        addStudent("Аркадий", "Биологический", 2019);

        removeStudent("Арина", "Экономический", 2019);
        removeStudent("Илья", "Математический", 2020);

        printInfo();
        System.out.println("_____________");
        getStudentList("Экономический", 2019).forEach(System.out::println);
    }

    static  HashMap<Map.Entry<String, Integer>, List<Student>> sortStudentAndAddFacultyHashMap(List<Student> studentList) {
        HashMap<Map.Entry<String, Integer>, List<Student>> facultyHashMap = new HashMap<>();
        for (Student student : studentList) {
            Map.Entry<String, Integer> facultyYearsEntry = Map.entry(student.getFaculty(), student.getYear());
            if(!facultyHashMap.containsKey(facultyYearsEntry)) {
                facultyHashMap.put(facultyYearsEntry, new ArrayList<>());
            }
            facultyHashMap.get(facultyYearsEntry).add(student);
        }
        return facultyHashMap;
    }

    static void removeStudent(String name, String faculty, int year) {
        facultyHashMap.get(Map.entry(faculty, year)).remove(new Student(name, faculty, year));
    }

    static void addStudent(String name, String faculty, int year) {
        facultyHashMap.get(Map.entry(faculty, year)).add(new Student(name, faculty, year));
    }

    static List<Student> getStudentList(String faculty, int year){
        return facultyHashMap.get(Map.entry(faculty, year));
    }

    static void printInfo() {
        for (Map.Entry<String, Integer> stringIntegerEntry : facultyHashMap.keySet()) {
            System.out.printf("Students study at the faculty %s %d: \n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
            facultyHashMap.get(stringIntegerEntry).forEach(System.out::println);
        }
    }


}
