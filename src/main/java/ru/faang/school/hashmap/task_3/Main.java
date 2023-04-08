package hashmap.task_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ruslan", "Math", 1));
        students.add(new Student("Vlad", "Physics", 2));
        students.add(new Student("Lena", "Math", 1));
        students.add(new Student("Bob", "History", 3));

        Map<Pair, List<Student>> studentsMap = getMap(students);
        System.out.println(studentsMap);

        addStudent(studentsMap, new Student("Kirill", "Chemistry", 4));
        addStudent(studentsMap, new Student("Vika", "Physics", 2));

        System.out.println(studentsMap);

        removeStudent(studentsMap, "Bob", "History", 3);
        removeStudent(studentsMap, "Clara", "History", 3);
        removeStudent(studentsMap, "Vika", "Physics", 2);

        System.out.println(studentsMap);

        System.out.println(findStudentsByFacultyAndYear(studentsMap, "Math", 1));
        System.out.println(findStudentsByFacultyAndYear(studentsMap, "Physics", 3));

        List<List<Student>> groupedStudentsList = getGroupedStudents(studentsMap);
        System.out.println(groupedStudentsList);
    }

    public static Map<Pair, List<Student>> getMap(List<Student> students) {
        Map<Pair, List<Student>> info = new HashMap<>();
        Pair pair;
        for (Student student: students) {
            pair = new Pair(student.getFaculty(), student.getYear());
            if (info.containsKey(pair)) {
                info.get(pair).add(student);
            } else {
                List<Student> list = new ArrayList<>();
                list.add(student);
                info.put(pair, list);
            }
        }

        return info;
    }

    public static void addStudent(Map<Pair, List<Student>> students, Student student) {
        Pair pair = new Pair(student.getFaculty(), student.getYear());

        if (students.containsKey(pair))
            students.get(pair).add(student);

        else {
            List<Student> list = new ArrayList<>();
            list.add(student);
            students.put(pair, list);
        }
    }

    public static void removeStudent(Map<Pair, List<Student>> students, String name, String faculty, int year) {
        Pair pair = new Pair(faculty, year);

        if (students.containsKey(pair)) {
            List<Student> list = students.get(pair);
            for (Student student: list) {
                if (student.getName().equals(name)) {
                    list.remove(student);
                    if (list.size() == 0) {
                        students.remove(pair);
                    }
                    return;
                }
            }
        }
    }

    public static List<Student> findStudentsByFacultyAndYear(Map<Pair, List<Student>> students, String faculty, int year) {
        Pair pair = new Pair(faculty, year);

        if (students.containsKey(pair))
            return students.get(pair);

        return new ArrayList<>();
    }

    public static List<List<Student>> getGroupedStudents(Map<Pair, List<Student>> students) {
        List<List<Student>> allStudents = new ArrayList<>();

        for (Map.Entry<Pair, List<Student>> studentsList: students.entrySet()) {
            allStudents.add(studentsList.getValue());
        }

        return allStudents;
    }
}

class Pair {
    String faculty;
    int year;

    public Pair(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    public String toString() {
        return "(" + faculty + ", " + year + ")";
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