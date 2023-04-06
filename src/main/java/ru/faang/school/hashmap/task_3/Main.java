package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static List<Student> studentList = new ArrayList<>();
    static HashMap<Pair,List> groupedStudents;
    public static void main(String[] args) {

        Student st1 = new Student("Петр","Физфак", 2);
        Student st2 = new Student("Глеб","Физфак", 2);
        Student st3 = new Student("Инна","Физфак", 3);
        Student st4 = new Student("Марго","Физфак", 3);
        Student st5 = new Student("Федор","ВМК", 3);
        Student st6 = new Student("Петр","ВМК", 2);
        Student st7 = new Student("Антон","ВМК", 3);
        Student st8 = new Student("Анна","Мехмат", 2);
        Student st9 = new Student("Петр","Мехмат", 2);
        Student st10 = new Student("Инна","Мехмат", 3);
        Student st11 = new Student("Влад","Махмат", 2);
        Student st12 = new Student("Федор","Мехмат", 3);
        Student st13 = new Student("Федор","Физфак", 2);

        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(st5);
        studentList.add(st6);
        studentList.add(st7);
        studentList.add(st8);
        studentList.add(st9);
        studentList.add(st10);
        studentList.add(st11);
        studentList.add(st12);
        studentList.add(st13);
        addNewStudent("Вася", "ВМК",3);

        delStudent("Анна","Мехмат",2);

        groupedStudents = addNewStudentList(studentList);




        for (var elem: groupedStudents.entrySet()) {
            System.out.println(elem.getKey().faculty + elem.getKey().year + elem.getValue());

        }

//        System.out.println(groupedStudents.get(new Pair("ВМК",3)));
//        groupedStudents.get(new Pair("ВМК",3)).stream().forEach(System.out::println);



        searchStudents("ВМК",3);

        showAllStudents();



    }

    public static HashMap addNewStudentList(List<Student> studentList) {
        HashMap<Pair,ArrayList<String>> groupedStudents = new HashMap<>();

        for (var elem: studentList) {
            Pair pair = new Pair(elem.getFaculty(), elem.getYear());
            if (groupedStudents.containsKey(pair))  {
                groupedStudents.get(pair).add(elem.getName());
            } else {
                groupedStudents.put(pair, new ArrayList<>() );
                groupedStudents.get(pair).add(elem.getName());
            }
        }
        return  groupedStudents;
    }

    public static void addNewStudent(String name, String faculty, int year) {
        Student student = new Student(name,faculty,year);
        studentList.add(student);
    }

    public static void delStudent(String name, String faculty, int year) {
        Student student = new Student(name,faculty,year);
        studentList = studentList.stream().filter(x -> !x.equals(student)).collect(Collectors.toList());
//        studentList.removeIf(x -> x.equals(student)); второй вариант удаления
    }

    public static void searchStudents(String faculty, int year) {
        Pair pair = new Pair(faculty,year);
//        groupedStudents.get(pair).stream().forEach(System.out::println);
        System.out.println("Факультет: " + faculty + " Курс " + String.valueOf(year) + " Список студентов:");
        System.out.println(groupedStudents.get(pair));
    }

    public static void showAllStudents() {
        groupedStudents.entrySet().stream().forEach(System.out::println);
    }
}