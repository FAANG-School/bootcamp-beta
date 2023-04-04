package ru.faang.school.hashmap.task_3.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

  public static HashMap<FacultyAndCourse, Set<Student>> createMap (List<Student> students) {

    if (students!=null) {

      HashMap<FacultyAndCourse, Set<Student>> map = new HashMap<>();

      students.forEach(student -> putStudent(student, map));

      return map;
    }

    return null;
  }

  public static void putStudent(Student student, HashMap<FacultyAndCourse, Set<Student>> map) {

    if (map != null) {

      String faculty = student != null ? student.getFaculty() != null? student.getFaculty() : "Course Absent" : "Course Absent";
      Integer year = student != null ? student.getYear() != null? student.getYear(): 0 : 0;

      var key = new FacultyAndCourse(faculty, year);

      var currentSet = map.getOrDefault(key, new HashSet<>());
      currentSet.add(student);

      map.put(key, currentSet);
    }
  }

  public static void deleteStudent(String name, String faculty, Integer year, HashMap<FacultyAndCourse, Set<Student>> map) {

    if (map != null) {

      var key = new FacultyAndCourse(faculty, year);
      var student = new Student(name, faculty, year);

      map.getOrDefault(key, new HashSet<>()).remove(student);
    }
  }

  public static void printAllStudentsSpecificFacultyAndCourse(String faculty, Integer year, HashMap<FacultyAndCourse, Set<Student>> map) {

    if (map != null) {

      var key = new FacultyAndCourse(faculty, year);
      System.out.printf("\n[faculty: %s, year: %d] -> %s", faculty, year, map.getOrDefault(key, new HashSet<>()));

    } else {
      System.out.println("Map is empty");
    }
  }

  public static void printAllStudents(HashMap<FacultyAndCourse, Set<Student>> map) {

    if (map != null) {

      map.forEach((key, value) -> {

        var faculty = key != null ? key.getFaculty() : null;
        var year = key != null ? key.getYear() : null;

        System.out.printf("\n[faculty: %s, year: %d] -> %s", faculty, year, value);
      });

    } else {
      System.out.println("Map is empty");
    }
  }

  public static void main(String[] args) {
    var student1 = new Student("Billy Morty", "Engineer", 4);
    var student2 = new Student("Andy Filch", "Engineer", 4);

    var student3 = new Student("Jane Morris", "Engineer", 3);
    var student4 = new Student("Billy Morty", "Engineer", 3);

    var student5 = new Student("Alex Bell", "Builder", 1);
    var student6 = new Student("Ali Carson", "Builder", 1);

    var student7 = new Student("Mr Mkay", "Builder", 2);
    var student8 = new Student("Billy Poky", "Builder", 2);

    var student9 = new Student("Martin Schelcy", "Driver", 2);
    var student10 = new Student("Robbert Garrison", "Driver", 3);

    var student11 = new Student("Ju Di", "Driver", 4);
    var student12 = new Student("Kim Realyson", "Driver", 4);

    var student13 = new Student("Kim Realyson", "Driver", null);
    var student14 = new Student(null, "Driver", 4);
    var student15 = new Student("Kim Realyson", null, 4);
    var student16 = new Student(null, null, 4);
    var student17 = new Student(null, null, null);

    var list = List.of(student1, student2, student3, student4, student5, student6, student7, student8,
        student9, student10, student11, student12, student13, student14, student15, student16);

    var map = createMap(list);

    putStudent(student17, map);

    printAllStudents(map);

    printAllStudentsSpecificFacultyAndCourse(student1.getFaculty(), student1.getYear(), map);

    deleteStudent(student2.getName(), student2.getFaculty(), student2.getYear(), map);
    deleteStudent(student3.getName(), student3.getFaculty(), student3.getYear(), map);
    deleteStudent(student15.getName(), student15.getFaculty(), student15.getYear(), map);

    printAllStudents(map);

    printAllStudentsSpecificFacultyAndCourse(student14.getFaculty(), student14.getYear(), map);

  }
}
