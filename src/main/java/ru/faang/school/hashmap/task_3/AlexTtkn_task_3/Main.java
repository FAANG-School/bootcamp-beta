package ru.faang.school.hashmap.task_3.AlexTtkn_task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class Main {
        static final List<Student> listOfStudents = new ArrayList<>();
        static final Map<Group, List<Student>> mapOfStudents = new HashMap<>();
        public static void main(String[] args) {
            listOfStudents.add(new Student("Ivan","Faculty of Law", 1));
            listOfStudents.add(new Student("Vlad","Faculty of Sports", 2));
            listOfStudents.add(new Student("Alex","Faculty of Civil Engineering", 3));
            listOfStudents.add(new Student("Petr","Faculty of Energy", 4));

            addStudent(new Student("IGOR","Faculty of Energy", 4));
            invertToHash(listOfStudents);
            printStudents();
        }
        public static void invertToHash(List<Student> students) {
            for (Student student : students) {
                Group group = new Group(student.getFaculty(), student.getYear());
                if (mapOfStudents.containsKey(group)) {
                    mapOfStudents.get(group).add(student);
                } else {
                    List<Student> list = new ArrayList<>();
                    list.add(student);
                    mapOfStudents.put(group,list);
                }
            }
        }

        public static void addStudent(Student student) {
            listOfStudents.add(student);
        }

        public static void removeStudent(String name, String faculty, int year) {
            Student check = new Student(name, faculty, year);
            if (listOfStudents.contains(check)) {
                listOfStudents.remove(check);
            } else {
                System.out.println("Student not found");
            }
        }

        public static void searchStudent(Group group) {
            System.out.println(mapOfStudents.get(group));
        }

        public static void printStudents() {
            for(Map.Entry<Group,List<Student>> entry : mapOfStudents.entrySet()) {
                for(Student student : entry.getValue()) {
                    System.out.println(entry.getKey().getFaculty() + ", " + entry.getKey().getYear() + ": " +
                            student.getName() + ";");
                }
            }
        }
    }

