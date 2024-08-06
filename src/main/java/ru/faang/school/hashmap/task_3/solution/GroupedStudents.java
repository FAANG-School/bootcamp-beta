package ru.faang.school.hashmap.task_3.solution;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupedStudents extends HashMap<Student.PairOfKeys, Students> {

    public static GroupedStudents groupStudent(Students students){
        GroupedStudents groupedStudents = new GroupedStudents();

        for(Student student : students){
            if(groupedStudents.containsKey(student.getPairKeys())) {
                if (!groupedStudents.get(student.getPairKeys()).contains(student))
                    groupedStudents.get(student.getPairKeys()).add(student);
            } else{
                Students newStudentsList = new Students();
                newStudentsList.add(student);
                groupedStudents.put(student.getPairKeys(), newStudentsList);
            }
        }
        return groupedStudents;
    }

    public Students findStudents(Student.Faculty faculty, int year){
        Students students = new Students();

        for (Entry<Student.PairOfKeys, Students> set : entrySet()){
            if(set.getKey().equals(new Student.PairOfKeys(faculty, year)))
                students.addAll(set.getValue());
        }
        return students;
    }

    public GroupedStudents deleteStudent(String name, Student.Faculty faculty, int year){
        Student.PairOfKeys keys = new Student.PairOfKeys(faculty, year);

        if(containsKey(keys)){
            Student student = get(keys).findStudentByName(name);
            if(student != null)
                get(keys).remove(student);
        }
        return this;
    }

    public GroupedStudents addStudent(Student student){
        if(containsKey(student.getPairKeys())){
            if(!get(student.getPairKeys()).contains(student))
                get(student.getPairKeys()).add(student);
        }else {
            Students newStudentList = new Students();
            newStudentList.add(student);
            put(student.getPairKeys(), newStudentList);
        }

        return this;
    }

    public Students getAllStudents(){
        Students students = new Students();
        for (Entry<Student.PairOfKeys, Students> set : entrySet()){
            students.addAll(set.getValue());
        }
        return students;
    }

    public void printStudents(){
        for (Entry<Student.PairOfKeys, Students> set : entrySet()){
            System.out.println(set.getKey()+" "+set.getValue());
        }
        System.out.println();
    }
}
