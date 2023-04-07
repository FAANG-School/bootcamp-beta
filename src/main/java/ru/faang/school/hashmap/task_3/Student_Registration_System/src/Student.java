import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private String faculty;
    private Integer year;

    private Student() {}

    public Student(String name, String faculty, Integer year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public String getName() { return name; }

    public String getFaculty() { return faculty; }

    public Integer getYear() { return year; }

    public static void printAll() {
        Main.students.forEach(System.out::println);
    }

    public static void add(Student student) {
        Main.students.add(student);
    }

    public static Map<Map.Entry<String, Integer>, List<Student>> groupingStudents(List<Student> students) {
        return students.stream().collect(Collectors.groupingBy(e -> Pair.of(e.getFaculty(), e.getYear())));
    }

    public static void remove(Object field, int fieldPos) throws NoSuchMethodException {
        Set<Student> toRemove = new HashSet<>(findStudents(field, fieldPos));
        Set<Student> baseList = new LinkedHashSet<>(Main.students);
        toRemove.forEach(stud -> System.out.println(stud.getName() + " was deleted"));
        baseList.removeAll(toRemove);
        Main.students = baseList.stream().toList();
    }

    public static void getStudent(Object field, int fieldPos) throws NoSuchMethodException {
        List<Student> students = findStudents(field, fieldPos);
        String category = fieldPos == 1 ? "'Name'" : fieldPos == 2 ? "'Faculty'" : "'Year'";
        System.out.println("List of students you searched by " + category + " category:");
        students.forEach(str -> System.out.println("\t" + str));
        System.out.println("---".repeat(30));
    }

    private static List<Student> findStudents(Object field, int fieldPos) throws NoSuchMethodException {
        Student student = new Student();
        Method method = fieldPos == 1 ? student.getClass().getDeclaredMethod("getName")
                : fieldPos == 2 ? student.getClass().getDeclaredMethod("getFaculty")
                : student.getClass().getDeclaredMethod("getYear");
        return Main.students.stream().filter(stud -> {
            try {
                return method.invoke(stud).equals(field);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }

    static class Pair {
        public static <K, V> Map.Entry<K, V> of(K first, V second) {
            return new AbstractMap.SimpleEntry<>(first, second);
        }
    }

    @Override
    public String toString() {
        return "Student{" + "name: "
                + name + ", faculty: "
                + faculty + ", year: "
                + year + '}';
    }
}
