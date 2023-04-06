package BootCamp;

import java.util.*;

public class Main {

    static HashMap<String, List<Student>> getStudentsGroup(List<Student> students){

        Set<String> facultyYearSet = new HashSet<>();
        students.forEach(student -> facultyYearSet.add(student.getFaculty() + "," + student.getYear()));
        HashMap<String, List<Student>> map = new HashMap<>();
        List<Student> studentGroup = new ArrayList<>();
        for (String faculty : facultyYearSet) {
            for (Student student : students) {
                if (faculty.split(",")[0].equals(student.getFaculty()) && faculty.split(",")[1].equals(student.getYear())) {
                    studentGroup.add(student);
                    map.put(faculty, studentGroup);
                }
            }
            studentGroup = new ArrayList<>();
        }

        return map;
    }

    static void showInfo(Map<String, List<Student>> map){
        map.entrySet().forEach(System.out::println);
    }

    static void addNewStudent(Map<String, List<Student>> map, Student student){
        try{
        List<Student> students = new ArrayList<>(map.get(student.getFaculty() + "," + student.getYear()));
        students.add(student);
        map.put(student.getFaculty() + "," + student.getYear(), students);
        }
        catch (NullPointerException ex){
            List<Student> students = new ArrayList<>();
            students.add(student);
            map.put(student.getFaculty() + "," + student.getYear(), students);
        }
    }

    static void deleteStudent(Map<String, List<Student>> map, Student student){
        try{
            List<Student> students = new ArrayList<>(map.get(student.getFaculty() + "," + student.getYear()));
            students.remove(student);
            map.put(student.getFaculty() + "," + student.getYear(), students);
        }
        catch (NullPointerException ex){
            System.out.println("Студента " + student +" нет на данном курсе факультета!!!");
        }
    }

    static void searchByFacultyAndYear(Map<String, List<Student>> map, String faculty, String year){
        System.out.println(map.get(faculty + "," + year) == null ? "Нет студентов!!!" : map.get(faculty + "," + year));
    }

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Петров Пётр Петрович", "1 курс", "Физика-Математика"));
        studentList.add(new Student("Иванов Иван Иванович", "2 курс", "Педагогика"));
        studentList.add(new Student("Тихий Тихон Тихонов", "2 курс", "Физика-Математика"));
        studentList.add(new Student("Быков Анатолий Иванович", "3 курс", "Иностранные дела"));
        studentList.add(new Student("Белый Александр Александрович", "3 курс", "Иностранные дела"));

        HashMap<String, List<Student>> studentsGroup = getStudentsGroup(studentList);
        showInfo(studentsGroup);
        System.out.println("Добавление...");
        addNewStudent(studentsGroup, new Student("Быков Анатолий Иванович", "3 курс", "Иностранные дела"));
        addNewStudent(studentsGroup, new Student("Ульянов Анатолий Евгеньевич", "2 курс", "Педагогика"));
        addNewStudent(studentsGroup, new Student("Ульянова Мария Евгеньевна", "1 курс", "Географический"));
        showInfo(studentsGroup);
        System.out.println("Удаление...");
        deleteStudent(studentsGroup, new Student("Ульянов Анатолий Евгеньевич", "2 курс", "Педагогика"));
        deleteStudent(studentsGroup, new Student("Ульянов Василий Евгеньевич", "2 курс", "Педагогика"));
        showInfo(studentsGroup);
        System.out.println("Поиск...");
        searchByFacultyAndYear(studentsGroup, "Педагогика", "2 курс");
        searchByFacultyAndYear(studentsGroup, "Педагогика", "1 курс");
    }
}
