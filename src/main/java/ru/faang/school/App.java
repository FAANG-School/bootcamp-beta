package ru.faang.school;

import ru.faang.school.hashmap.task_3.Main;

public class App {
    public static void main(String[] args) {
        Main main = new Main();
        main.getStudentsByFacultyAndYear("PTO","3");
        System.out.println();
        main.showStudentSortByFacultyAndYear();
    }
}
