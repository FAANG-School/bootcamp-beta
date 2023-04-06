package ru.faang.school.hashmap.task_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Task3Test {

    @Test
    public void task3Tests() {
        Main main = new Main();
        main.createStudentsMap(main.getStudents());
        Student student = new Student("Testname", "logistics", 4);
        Pair keyPair = new Pair(student.getFaculty(), student.getYear());

        main.addStudent(student);
        Assertions.assertTrue(main.getMap().get(keyPair).contains(student));

        main.deleteStudent("Testname", "logistics", 4);
        Assertions.assertFalse(main.getMap().get(keyPair).contains(student));

        List<Student> students = main.getStudentsByFacultyAndYear(new Pair("logistics", 3));
        for (Student student1 : students) {
            Assertions.assertEquals("logistics", student1.getFaculty());
            Assertions.assertEquals(3, student1.getYear());
        }

        System.out.println(main.groupStudentsByFacultyAndYear());
    }
}
