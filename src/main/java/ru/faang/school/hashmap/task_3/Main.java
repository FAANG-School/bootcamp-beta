package ru.faang.school.hashmap.task_3;

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<Student> students = new ArrayList<>();
        printStudents(students);

        fillStudents(students);
        printStudents(students);

        Map<PairKey, List<String>> studentsMapByFacultyYear = createMapByFacultyYear(students);
        printMapByFacultyYear(studentsMapByFacultyYear);

        System.out.println();
        searchStudentByFacultyYear(studentsMapByFacultyYear, "Факультет2", "1999");

        System.out.println();
        removeStudent(students, "Джейсон", "Факультет1", "1999");
        printStudents(students);

        System.out.println();
        addStudent(students, "Джейсон", "Факультет1", "1999");
        printStudents(students);
    }

    public static void fillStudents(List<Student> students){
        String[] names = {"Джейсон", "Брюс", "Джонни", "Киану", "Дуэйн",
                "Марк", "Адам", "Уилл", "Том", "Леонардо"};
        String[] faculty = {"Факультет1", "Факультет2"};
        String[] years = {"1999", "2000", "2005"};
        int i =0;
        int j = 0;
        for (String i_name:
             names) {
            students.add(new Student(i_name, faculty[i++], years[j++]));
            if (i > faculty.length - 1) i = 0;
            if (j > years.length - 1) j = 0;
        }
        System.out.println("Список студентов заполнен значениями.");
    }

    public static void removeStudent(List<Student> students,
                                     String name,
                                     String faculty,
                                     String year){
        Student student = new Student(name, faculty, year);
        students.remove(student);
    }

    public static void addStudent(List<Student> students,
                                     String name,
                                     String faculty,
                                     String year){
        Student student = new Student(name, faculty, year);
        students.add(student);
    }

    public static void printStudents(List<Student> students){
        System.out.println("Состояние списка:");
        if (!students.isEmpty()) {
            for (Student student :
                    students) {
                System.out.println(student);
            }
        }
        else System.out.println("Список пуст.");
        System.out.println();
    }

    public static Map<PairKey, List<String>> createMapByFacultyYear(List<Student> students){
        Map<PairKey, List<String>> mapStudents = new HashMap<>();
        // на каждом проходе кидать в мапу студента
        // проверять есил в мапе уже такой ключ,
        // если да то нужно получить значение по этому ключу и в него добавить имя студента.
        for (Student i_student:
             students) {
            PairKey key = new PairKey(i_student.faculty, i_student.year);
            if (mapStudents.containsKey(key)){
                mapStudents.get(key).add(i_student.name);
            }
            else
            {
                ArrayList<String> students_names = new ArrayList<>();
                students_names.add(i_student.name);
                mapStudents.put(key, students_names);
            }
        }
        return mapStudents;
    }

    public static  void printMapByFacultyYear(Map<PairKey, List<String>> mapFacultyYear){
        System.out.println("Состояине мапы.");
        if (!mapFacultyYear.isEmpty()){
            for (Map.Entry<PairKey, List<String>> entry:
                 mapFacultyYear.entrySet()) {
                System.out.println("Ключ: " + entry.getKey() + ", список студентов: " + entry.getValue());
            }
        }
        else System.out.println("Мапа пустая.");
    }

    public static void searchStudentByFacultyYear(Map<PairKey, List<String>> map,
                                                  String faculty, String year) {
        PairKey key = new PairKey(faculty, year);
        System.out.println("Поиск в мапе.");
        if (map.isEmpty()) System.out.println("Мапа пустая");

        if (map.containsKey(key)) {
            System.out.println("ключ: " + key + ", найдены студенты: " + map.get(key));
        }
        else System.out.println("Студенты соответсвующее ключу не найдены.");
    }

}
