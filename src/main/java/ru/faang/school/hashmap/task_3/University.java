package ru.faang.school.hashmap.task_3;

import java.util.*;

public class University {

    private final HashMap<StudentKey, List<Student>> students = new HashMap<>();

    public HashMap<StudentKey, List<Student>> groupStudents(List<Student> students) {
        HashMap<StudentKey, List<Student>> result = new HashMap<>();

        for (Student student : students) {
            StudentKey key = new StudentKey(student.faculty(), student.year());
            List<Student> tmp = getStudentsList(result, key);

            tmp.add(student);
        }

        return result;
    }

    public void addStudent(Student student) {
        StudentKey key = new StudentKey(student.faculty(), student.year());

        getStudentsList(students, key).add(student);

        students.entrySet();
    }

    public void removeStudent(Student student) {
        StudentKey key = new StudentKey(student.faculty(), student.year());

        getStudentsList(students, key).remove(student);
    }

    public List<Student> getStudentsByFacultyAndYear(String faculty, String year) {
        StudentKey key = new StudentKey(faculty, year);

        return students.get(key);
    }

    public void print() {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<StudentKey, List<Student>> entry : students.entrySet()) {
            builder.append("key = " + entry.getKey().toString());
            builder.append("; ");
            builder.append("students = " + Arrays.toString(entry.getValue().toArray()));
            builder.append('\n');
        }

        System.out.println(builder);
    }

    private static List<Student> getStudentsList(HashMap<StudentKey, List<Student>> data, StudentKey key) {
        List<Student> tmp;

        if (data.containsKey(key)) {
            tmp = data.get(key);
        } else {
            tmp = new ArrayList<>();
            data.put(key, tmp);
        }

        return tmp;
    }
}
