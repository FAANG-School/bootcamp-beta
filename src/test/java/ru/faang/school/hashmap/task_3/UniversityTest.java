package ru.faang.school.hashmap.task_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {

    private University university;

    @BeforeEach
    void setup() {
        university = new University();
    }

    @Test
    void addStudent() {
        Student student = new Student("test_1", "1", "2000");
        assertNull(university.getStudentsByFacultyAndYear(student.faculty(), student.year()));
        university.addStudent(student);
        assertTrue(university.getStudentsByFacultyAndYear(student.faculty(), student.year()).contains(student));
    }

    @Test
    void removeStudent() {
        Student student = new Student("test_1", "1", "2000");
        university.addStudent(student);
        assertNotNull(university.getStudentsByFacultyAndYear(student.faculty(), student.year()));
        university.removeStudent(student);
        assertArrayEquals(university.getStudentsByFacultyAndYear(student.faculty(), student.year()).toArray(), new Student[0]);
    }

    @Test
    void getStudentsByFacultyAndYear() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("test_1", "1", "2000"));
        students.add(new Student("test_2", "1", "2000"));

        for (Student student : students) {
            university.addStudent(student);
        }

        List<Student> foundStudents = university.getStudentsByFacultyAndYear("1", "2000");

        assertNotNull(foundStudents);
        assertTrue(students.containsAll(foundStudents) && students.size() == foundStudents.size());
        assertNull(university.getStudentsByFacultyAndYear("2", "2000"));
    }
}