package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John", "CS", 1);
        Student student2 = new Student("Jessy", "CS", 1);
        Student student3 = new Student("Marry", "CS", 2);

        List<Student> students = new ArrayList<>(){{
            add(student1);
            add(student2);
            add(student3);
        }};

        Map<String, List<Student>> map = createMap(students);

        getAllStudents(map);

        addNewStudent(new Student("Christian", "CS", 2), map);

        getAllStudents(map);

        removeStudent("John", "CS", 1, map);

        getAllStudents(map);
    }

    public static Map<String, List<Student>> createMap(List<Student> list) {
        Map<String, List<Student>> map = new HashMap<>();

        for(int i = 0; i < list.size(); i ++){
            StringBuilder key = new StringBuilder();
            key.append(list.get(i).getFaculty() + " " + list.get(i).getYear());

            List<Student> students = map.get(key.toString());
            if(students == null){
                students = new ArrayList<>();
                students.add(list.get(i));
            }
            else
                students.add(list.get(i));

            map.put(key.toString(), students);
        }


        return map;
    }

    public static void getAllStudents(Map<String, List<Student>> map){
        for(Map.Entry<String, List<Student>> entry : map.entrySet()){
            System.out.println(entry.getKey() +  " years's " + " : ");
            int k = 0;
            for(Student i: entry.getValue()){
                System.out.println(i.getName());
            }
            System.out.println();
        }
    }

    public static void addNewStudent(Student student, Map<String, List<Student>> map){
        StringBuilder key = new StringBuilder();
        key.append(student.getFaculty() + " " + student.getYear());

        List<Student> students = map.get(key.toString());

        students.add(student);

        map.put(key.toString(), students);
    }

    public static void removeStudent(String name, String faculty, int year, Map<String, List<Student>> map){
        StringBuilder key = new StringBuilder(faculty + " " + year);

        List<Student> students = map.get(key.toString());
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getName() == name){
                students.remove(students.get(i));
            }
        }

        map.put(key.toString(), students);
    }
}
