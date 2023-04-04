import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        addStudent(students, "Pavel", "Phys", 1);
        addStudent(students, "Vlad", "English", 2);
        addStudent(students, "Kate", "Economics", 3);
        addStudent(students, "Matthew", "Math", 1);
        addStudent(students, "Oleg", "Phys", 4);
        addStudent(students, "Mikhail", "Math", 1);
        addStudent(students, "Vasya", "Economics", 3);
        addStudent(students, "TestName", "TestFac", 9);
        System.out.println("Size before removing: " + students.size());

        deleteStudent(students, "TestName", "TestFac", 9);
        System.out.println("Size after removing: " + students.size());
        System.out.println();

        Map<Pair, List<Student>> map = groupStudents(students);
        printStudents(map);
    }

    public static void addStudent(List<Student> students, String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    public static void deleteStudent(List<Student> students, String name, String faculty, int year) {
        students.remove(new Student(name, faculty, year));
    }

    public static HashMap<Pair, List<Student>> groupStudents(List<Student> students) {
        HashMap<Pair, List<Student>> gropedStudents = new HashMap<>();

        for (Student student : students) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            if (gropedStudents.containsKey(pair)) {
                gropedStudents.get(pair).add(student);
            } else {
                List<Student> list = new ArrayList<>();
                list.add(student);
                gropedStudents.put(pair, list);
            }
        }

        return gropedStudents;
    }

    public static void printStudents(Map<Pair, List<Student>> students) {
        for (Map.Entry<Pair, List<Student>> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

