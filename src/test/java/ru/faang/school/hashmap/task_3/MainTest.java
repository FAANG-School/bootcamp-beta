package ru.faang.school.hashmap.task_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main = new Main();

    @Test
    void addStudents() {
        assertFalse(main.addStudents(main.students).isEmpty());
    }

    @Test
    void addNewStudent() {
        Pair pair = new Pair("социологии", 2);
        Student student = new Student("ggg", pair);
        main.addNewStudent(student);
        assertTrue(main.map.get(pair).contains(student));
    }

    @Test
    void searchStudentsByPair() {
        Pair pair = new Pair("филологический", 2);
        main.addStudents(main.students);
        assertFalse(main.searchStudentsByPair(pair).isEmpty());
    }

    @Test
    void printAllStudents() {
        main.addStudents(main.students);
        assertFalse(main.getAllStudents().isEmpty());
    }
}