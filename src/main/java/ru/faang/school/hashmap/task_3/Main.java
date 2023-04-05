package ru.faang.school.hashmap.task_3;

import java.util.*;

public class Main {
    public static List<Student> studentList = new ArrayList<>();

    private static class Pair {
        private String faculty;
        private int year;

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

    static {
        Student student1 = new Student("Никита", "Прикладная информатика", 5);
        Student student2 = new Student("Олег", "Инженерия", 4);
        Student student3 = new Student("Мария", "Журналистика", 2);
        Student student4 = new Student("Кристина", "Юриспруденция", 2);
        Student student5 = new Student("Валентин", "Прикладная информатика", 4);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
    }
    public static void main(String[] args) {
        getAllStudent();
    }

    public static Map<Pair, List<Student>> getMapAllStudents(List<Student> list) {
        Map<Pair, List<Student>> infoMap = new HashMap<>();

        for (Student student : list) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            if (infoMap.containsKey(pair)) {
                infoMap.get(pair).add(student);
            } else {
                List<Student> innerList = new ArrayList<>();
                innerList.add(student);
                infoMap.put(pair, innerList);
            }
        }
        return infoMap;
    }

    public static void addNewStudent(Student student) {
        studentList.add(student);
    }

    public static String deleteStudent(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        if (studentList.contains(student)) {
            studentList.remove(student);
            return "Студент удален из списка";
        } else {
            return "Такого студента нет в списке";
        }
    }

    public static List<Student> searchingStudent(String faculty, int year) {
        Map<Pair, List<Student>> studentMap = getMapAllStudents(studentList);
        Pair pair = new Pair(faculty, year);
        if (studentMap.containsKey(pair)) {
            return studentMap.get(pair);
        } else {
            return null;
        }
    }

    public static void getAllStudent() {
        for (var entry : getMapAllStudents(studentList).entrySet()) {
            Pair pair = entry.getKey();
            List<Student> list = entry.getValue();
            System.out.println("Факультет: " + pair.faculty + ", курс: " + pair.year);
            for (Student student : list) {
                System.out.print(student.getName() + " ");
            }
            System.out.println();
        }
    }

}
