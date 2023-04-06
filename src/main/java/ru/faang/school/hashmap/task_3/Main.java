package ru.faang.school.hashmap.task_3;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static final private Map<Map.Entry<String, String>, List<Student>> studentByCourse = new HashMap<>();

    static final private List<Student> studentList = List.of(
            new Student("John", "Java", "2013"),
            new Student("Jack", "Database", "2013"),
            new Student("Jam", "Python", "2016"),
            new Student("Julia", "Java", "2015"),
            new Student("James", "Java", "2013"),
            new Student("Jerry", "Python", "2020")
    );



    public Map loadStudentsBase(List<Student> studentList) {
        for (Student student : studentList) {
            String faculty = student.getFaculty();
            String year = student.getYear();
            if (!studentByCourse.containsKey(Map.entry(faculty, year))) {
                studentByCourse.put(Map.entry(faculty, year), studentList.stream()
                        .filter(stu -> Objects.equals(stu.getFaculty(),faculty) && Objects.equals(stu.getYear(), year))
                        .collect(Collectors.toList()));
            }
        }
        return studentByCourse;
    }

    public void addNewStudent(Student student) {
        String faculty = student.getFaculty();
        String year = student.getYear();
        if (studentByCourse.containsKey(Map.entry(faculty, year)))
            studentByCourse.get(Map.entry(faculty, year)).add(student);
        else {
          studentByCourse.put(Map.entry(faculty,year), new ArrayList<>());
          studentByCourse.get(Map.entry(faculty,year)).add(student);
        }
    }

    public void searchStudentsByFacultyAndYear(String faculty, String year) {
        for(var key : studentByCourse.keySet()) {
           if (Objects.equals(key.getKey(), faculty) && Objects.equals(key.getValue(), year)) {
               System.out.println(studentByCourse.get(key).toString());
           }
        }
    }

    public void printAllStudents() {
        studentByCourse.forEach((Key, Value) -> System.out.println(Key + "\n" + Value));
    }



    public static void main(String[] args) {
        Main base = new Main();
        base.loadStudentsBase(studentList);
        base.addNewStudent(new Student("Dada","Python", "2020"));
        System.out.println();
        studentByCourse.forEach((Key, Value) -> System.out.println(Key + " " + Value));
        System.out.println();
        base.searchStudentsByFacultyAndYear("Java", "2013");
        System.out.println();
        base.printAllStudents();
    }



}

class Student{
    final private String name;
    final private String faculty;
    final private String year;

    public Student(String name, String faculty, String year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
