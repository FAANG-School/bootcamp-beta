package ru.faang.school.hashmap.task_3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * В заданиях мне не понятно следующее:
 * - добавления нового студента в список
 * - удаления студента из списка по его имени, факультету и курсу
 * - поиска всех студентов определенного факультета и курса
 * - вывода списка всех студентов сгруппированных по факультетам и курс
 * Не написано нигде. что надо добавлять в Мару, которая создавалась 3 пунктом.
 * Вряд ли же в теме HashMap я должен добавлять просто в лист, который был создан в пункте 2.
 * И почему бы не назвать поле course, а не year (курс) ?
 * <p>
 * P.S. Все замечания даны в целях улучшения курса и только.
 * God save the King!
 */
public class Main {

    public static List<Student> students = List.of(
            new Student("Vitaliy", "economy", 2),
            new Student("Zhenya", "philology", 4),
            new Student("Mike", "IT", 3),
            new Student("Bob", "economy", 3),
            new Student("Jane", "philology", 4),
            new Student("Michele", "IT", 2),
            new Student("Martin", "economy", 2)
    );

    public static void main(String[] args) {
        Main main = new Main();
        Map<String, List<Student>> mapByFacultyAndYear = main.createMapWithFacultyYearKeyAndStudensValue(students);
        System.out.println(mapByFacultyAndYear);

        System.out.println("*********************************");
        Student newStudent = new Student("Mirana", "Politology", 5);
        main.addNewStudent(newStudent, mapByFacultyAndYear);
        System.out.println(mapByFacultyAndYear);

        System.out.println("*********************************");
        Student newStudent2 = new Student("Marci", "economy", 2);
        main.addNewStudent(newStudent2, mapByFacultyAndYear);
        System.out.println(mapByFacultyAndYear);

        System.out.println("*********************************");
        System.out.println(main.findByFacultyAndCourse("economy", 2, mapByFacultyAndYear));

        System.out.println("*********************************");
        main.deleteStudent(students.get(0), mapByFacultyAndYear);
        System.out.println(mapByFacultyAndYear);

        System.out.println("*********************************");
        System.out.println(main.createMapWithFacultyYearKeyAndStudensValue(students));
    }

    public Map<String, List<Student>> createMapWithFacultyYearKeyAndStudensValue(List<Student> students) {
        Map<String, List<Student>> map = new HashMap<>();
        for (Student s : students) {
            List<Student> forMap;
            forMap = students.stream()
                    .filter(e -> e.getFaculty().equals(s.getFaculty()))
                    .filter(e -> e.getYear() == s.getYear())
                    .collect(Collectors.toList());
            map.put(s.getFaculty() + " " + s.getYear(), forMap);
        }
        return map;
    }

    public void addNewStudent(Student newStudent, Map<String, List<Student>> mapByFacultyAndYear) {
        String key = newStudent.getFaculty() + " " + newStudent.getYear();
        List<Student> listByFacultyAndYear = mapByFacultyAndYear.get(key);
        if (listByFacultyAndYear == null) {
            mapByFacultyAndYear.put(key, List.of(newStudent));
        } else {
            listByFacultyAndYear.add(newStudent);
        }
    }

    public void deleteStudent(Student newStudent, Map<String, List<Student>> mapByFacultyAndYear) {
        String key = newStudent.getFaculty() + " " + newStudent.getYear();
        List<Student> listByFacultyAndYear = mapByFacultyAndYear.get(key);
        if (listByFacultyAndYear == null) {
            System.out.println("There is no this student! " + newStudent + " in the map");
        } else {
            listByFacultyAndYear.remove(newStudent);
        }
    }

    public List<Student> findByFacultyAndCourse(String faculty, int course, Map<String, List<Student>> mapByFacultyAndYear) {
        return mapByFacultyAndYear.get(faculty + " " + course);
    }

}
