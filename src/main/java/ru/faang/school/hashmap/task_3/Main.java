package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static HashMap<Pair, List<Student>> mapOfStudents = new HashMap<>();

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Peter", "Architecture", 3));
        students.add(new Student("Eugene", "Data, Systems, and Society", 5));
        students.add(new Student("Alexa", "Political Science", 1));
        students.add(new Student("Eva", "Medical Engineering and Science", 4));

        getStudentsHashMap(students);

        printAll();
        System.out.println("**************************************************************************************");

        put(new Student("Kate", "Architecture", 2));
        put(new Student("Max", "Architecture", 2));

        printAll();
        System.out.println("**************************************************************************************");
        remove("Eugene", "Data, Systems, and Society", 5);

        printAll();
        System.out.println("**************************************************************************************");
    }

    private static HashMap<Pair, List<Student>> getStudentsHashMap(List<Student> listOfStudents) {
        for (Student student : listOfStudents) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            if(mapOfStudents.containsKey(pair)) {
                mapOfStudents.get(pair).add(student);
            } else {
                List<Student> newListOfStudents = new ArrayList<>();
                newListOfStudents.add(student);
                mapOfStudents.put(pair, newListOfStudents);
            }
        }
        return mapOfStudents;
    }

    private static void put(Student student) {
        Pair pair = new Pair(student.getFaculty(), student.getYear());
        List<Student> listOfStudents;
        if(mapOfStudents.containsKey(pair)) {
            listOfStudents = mapOfStudents.get(pair);
        } else {
            listOfStudents = new ArrayList<>();
            mapOfStudents.put(pair, listOfStudents);
        }
        listOfStudents.add(student);
    }

    private static void remove(String name, String faculty, int year) {
        Pair key = new Pair(faculty, year);
        if(mapOfStudents.containsKey(key) && mapOfStudents.get(key) != null) {
            List<Student> students = mapOfStudents.get(key);
            if(students.remove(new Student(name, faculty, year))) {
                mapOfStudents.remove(key);
            }
        }
    }

    private static void printAll() {
        for (Map.Entry<Pair, List<Student>> entry : mapOfStudents.entrySet()) {
            System.out.println("Faculty: " + entry.getKey().getFaculty() + ", year: " + entry.getKey().getYear() + ", "
                    + entry.getValue());
        }
    }
}

