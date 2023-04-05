package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{
    private static List<Student> allStudents=new ArrayList<>();

    public static void main(String[] args)
    {
        addStudent(new Student("Dima", "Computer Science", 1));
        addStudent(new Student("Ivan", "Computer Science", 1));
        addStudent(new Student("Artem", "Computer Science", 2));
        printStudentsByFaculty();
    }
    public static Map<String, List<Student>> getMapOfStudents(List<Student> allStudents)
    {
        Map<String, List<Student>> result=new HashMap<>();
        for(Student student:allStudents)
        {
            String key=student.getFaculty()+"="+String.valueOf(student.getYear());
            if (result.containsKey(key)){
                List<Student> subList=result.get(key);
                subList.add(student);
                result.put(key, subList);
            }
            else
            {
                List<Student> newList=new ArrayList<>();
                newList.add(student);
                result.put(key, newList );
            }
        }
        return result;
    }
    public static void addStudent(Student student){
        allStudents.add(student);
    }
    public static void deleteStudent(Student student){
        allStudents.remove(student);
    }
    public static List<Student> findSpecificGroupOfStudents(String faculty, int year)
    {
        Map<String, List<Student>> studentMap=getMapOfStudents(allStudents);
        String keySearch=faculty+"="+String.valueOf(year);
        return  studentMap.get(keySearch);
    }
    public static void printStudentsByFaculty()
    {
        Map<String, List<Student>> studentMap=getMapOfStudents(allStudents);
        for(String key:studentMap.keySet()){
            String [] facultyAndYear=key.split("=");
            System.out.println("Faculty:"+facultyAndYear[0]+" Year:"+facultyAndYear[1]);
            for(Student student:studentMap.get(key)){
                System.out.println("Name:"+student.getName());
            }
        }
    }
}
