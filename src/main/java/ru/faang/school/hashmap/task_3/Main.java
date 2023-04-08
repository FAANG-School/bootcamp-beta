package ru.faang.school.hashmap.task_3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(new Student("David", Faculty.EDUCATION_AND_HUMANITIES, 2),
                new Student("Mark", Faculty.ENGINEERING_AND_NATURAL_SCIENCES, 4),
                new Student("Roza", Faculty.BUSINESS_SCHOOL, 3),
                new Student("Jack", Faculty.ENGINEERING_AND_NATURAL_SCIENCES, 2),
                new Student("Sam", Faculty.LAW_AND_SOCIAL_SCIENCES, 1),
                new Student("Mickey", Faculty.BUSINESS_SCHOOL, 3),
                new Student("Alex", Faculty.ENGINEERING_AND_NATURAL_SCIENCES, 2));

        StudentDAO studentDAO = new StudentDAO(students);
        studentDAO.printAll();
        // Несуществующий студент
        studentDAO.remove("Mark", Faculty.EDUCATION_AND_HUMANITIES, 4);
    }

}
