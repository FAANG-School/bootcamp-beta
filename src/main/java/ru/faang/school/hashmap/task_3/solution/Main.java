package ru.faang.school.hashmap.task_3.solution;

import lombok.val;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    private GroupedStudents groupedStudents = new GroupedStudents();

    public static void main(String[] args) {
        new Main().start();
    }

    private void start(){
        Students students = new Students();

        students.add(new Student("Dima", Student.Faculty.Gryffindor, 1));
        students.add(new Student("Danil", Student.Faculty.Ravenclaw, 1));
        students.add(new Student("Igor", Student.Faculty.Hufflepuff, 3));
        students.add(new Student("Alina", Student.Faculty.Ravenclaw, 3));
        students.add(new Student("Alice", Student.Faculty.Slytherin, 1));
        students.add(new Student("Garry", Student.Faculty.Gryffindor, 1));
        students.add(new Student("Malfoy", Student.Faculty.Slytherin, 2));
        students.add(new Student("Snape", Student.Faculty.Slytherin, 2));
        students.add(new Student("Germiona", Student.Faculty.Hufflepuff, 1));
        students.add(new Student("Ron", Student.Faculty.Gryffindor, 2));

        groupedStudents = GroupedStudents.groupStudent(students);
        groupedStudents.printStudents();

        groupedStudents.findStudents(Student.Faculty.Gryffindor, 1).printStudents();

        groupedStudents.deleteStudent("Garry", Student.Faculty.Gryffindor, 1).printStudents();

        groupedStudents.addStudent(new Student("Vasya", Student.Faculty.Gryffindor, 2)).printStudents();

        groupedStudents.getAllStudents().printStudents();

        val s = groupedStudents.getAllStudents();
        Collections.sort(s);
        s.printStudents();

        s.sort((o1, o2) -> o1.getYear() - o2.getYear());
        s.printStudents();
    }
}
