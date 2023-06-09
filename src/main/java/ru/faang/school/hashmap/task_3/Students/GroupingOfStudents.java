package ru.faang.school.hashmap.task_3.Students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupingOfStudents {

    public static void main(String[] args) {
        addStudent("иван", "IT", 2);
        addStudent("Анна", "IT", 3);
        addStudent("Дмитрий", "IT", 2);
        addStudent("Екатерина", "IT", 4);
        addStudent("Максим", "IT", 4);
        addStudent("Ольга", "Менеджмент", 1);
        addStudent("Сергей", "Менеджмент", 2);
        addStudent("Александра", "Менеджмент", 1);
        addStudent("Роман", "Менеджмент", 3);
        addStudent("Валерия", "Физика", 2);
        addStudent("Алексей", "Физика", 2);
        addStudent("Мария", "Физика", 4);
        addStudent("Никита", "Физика", 2);
        addStudent("Юлия", "иностранные языки", 3);
        addStudent("Павел", "иностранные языки", 3);
        addStudent("Дарья", "иностранные языки", 2);
        addStudent("Артем", "иностранные языки", 1);
        addStudent("Елена", "иностранные языки", 4);
        addStudent("ирина", "IT", 1);
        addStudent("Виктор", "IT", 1);
        addStudent("иннокентий", "IT", 1);

        System.out.println(getStudentsByFacultyAndYear("Менеджмент", 1));

        System.out.println(getAllGroupedStudents());
        removeStudent("Валерия", "Физика", 2);
        System.out.println(getAllGroupedStudents());

    }

    private static final List<Student> students = new ArrayList<>();


    private static class facultyAndYear {
        private final String faculty;
        private final int year;

        public facultyAndYear(Student student) {
            this.faculty = student.getFaculty();
            this.year = student.getYear();
        }

        public facultyAndYear(String faculty, int year) {
            this.faculty = faculty;
            this.year = year;
        }

        public int getYear() {
            return year;
        }

        public String getFaculty() {
            return faculty;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }

            facultyAndYear fAndY = (facultyAndYear) obj;
            return year == fAndY.year && (faculty == fAndY.faculty || (faculty != null && faculty.equals(fAndY.getFaculty())));
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + year;
            result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
            return result;
        }

        @Override
        public String toString() {
            return String.format("%s %s курс:\n", faculty, year);
        }
    }

    static Map<facultyAndYear, List<String>> groupStudents(List<Student> students) {
        Map<facultyAndYear, List<String>> groupedStudents = new HashMap<>();

        for (Student s : students) {
            groupedStudents.put(new facultyAndYear(s), new ArrayList<>());
        }
        for (Map.Entry<facultyAndYear, List<String>> map : groupedStudents.entrySet()) {
            for (Student s : students) {
                if (map.getKey().getFaculty() == s.getFaculty() && map.getKey().getYear() == s.getYear()) {
                    map.getValue().add(s.getName());
                }
            }
        }
        return groupedStudents;
    }

    static void addStudent(String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    static void removeStudent(String name, String faculty, int year) {
        if (students.contains(new Student(name, faculty, year))) {
            students.remove(new Student(name, faculty, year));
            return;
        }
        System.out.println("Student does not exist");
    }

    static List<String> getStudentsByFacultyAndYear(String faculty, int year) {
        Map<facultyAndYear, List<String>> groupedStudent = groupStudents(students);
        if (groupedStudent.containsKey(new facultyAndYear(faculty, year))) {
            return groupedStudent.get(new facultyAndYear(faculty, year));

        }
        System.out.println("Faculty does not exist");
        return null;
    }

    static String getAllGroupedStudents() {
        Map<facultyAndYear, List<String>> groupedStudent = groupStudents(students);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<facultyAndYear, List<String>> map : groupedStudent.entrySet()) {
            sb.append(map.getKey().toString());
            sb.append(map.getValue()).append(("\n"));
        }
        return sb.toString();
    }
}
