package ru.faang.school.task3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {


    @Test
    void createMap() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("A", "B", 1));
        students.add(new Student("B", "B", 1));
        students.add(new Student("BA", "B", 1));
        students.add(new Student("C", "C", 2));
        students.add(new Student("CC", "C", 1));

        Map<String, List<Student>> data = Student.createMap(students);

        assertEquals(3, data.size());
    }

    @Test
    void addStudent() {
        List<Student> students = new ArrayList<>();
        Student.addStudent(students, new Student("Test", "AFTV", 1));

        assertEquals("Test", students.get(0).getName());
        assertEquals("AFTV", students.get(0).getFaculty());
        assertEquals(1, students.get(0).getYear());
    }

    @Test
    void deleteStudent() {
        List<Student> students = new ArrayList<>();
        Student student = new Student("Test", "AFTV", 1);
        students.add(student);

        Student.deleteStudent(students, student);

        assertEquals(0, students.size());
    }

    @Test
    void findStudentsGroupByFacultAndYear() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("A", "B", 1));
        students.add(new Student("B", "B", 1));
        students.add(new Student("BA", "B", 1));
        students.add(new Student("C", "C", 2));
        students.add(new Student("CC", "C", 1));
        Map<String, List<Student>> data = Student.createMap(students);

        List<Student> result = Student.findStudentsGroupByFacultAndYear(data, "B : 1");

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("B", result.get(0).getFaculty());
    }

    @Test
    void printAllStudentsGroupByFacultAndYear() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("A", "B", 1));
        students.add(new Student("B", "B", 1));
        students.add(new Student("BA", "B", 1));
        students.add(new Student("C", "C", 2));
        students.add(new Student("CC", "C", 1));
        Map<String, List<Student>> data = Student.createMap(students);

        Student.printAllStudentsGroupByFacultAndYear(data);

    }
}