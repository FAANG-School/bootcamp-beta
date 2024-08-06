package ru.faang.school.hashmap.task_3.solution;

import java.util.ArrayList;

public class Students extends ArrayList<Student> {

    public Student findStudentByName(String name){
        for (Student student : this){
            if(student.getName().equals(name))
                return student;
        }
        return null;
    }

    public void printStudents(){
        for (Student student : this){
            System.out.println(student);
        }
        System.out.println();
    }
}
