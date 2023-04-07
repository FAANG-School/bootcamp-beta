import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws NoSuchMethodException {
        Student.add(new Student("Freddie Mercury", "Musical", 3));
        Student.add(new Student("Robert Downey Jr", "Acting", 1));
        Student.add(new Student("Cristiano Ronaldo", "Football", 2));
        Student.add(new Student("Ivan Urgant", "Journalism", 4));
        Student.add(new Student("Fidel Castro", "Political Science", 5));
        Student.add(new Student("Yuri Dud", "Journalism", 4));
        Student.add(new Student("Valery Miladze", "Musical", 3));
        Student.add(new Student("Sergey Burunov", "Acting", 1));
        Student.add(new Student("Lionel Messi", "Football", 2));
        Student.add(new Student("John Kennedy", "Political Science", 5));
        Student.add(new Student("Petr Petrov", "IT", 5));
        Student.add(new Student("Alexandr Reva", "Musical", 6));

        Student.printAll();

        System.out.println();
                                // Remove operation
//        Student.remove("Lionel Messi", 1); // name
//        Student.remove("Journalism", 2); // faculty
//        Student.remove(5, 3); // year

                                // Get operation
//        Student.getStudent("Lionel Messi", 1); // name
//        Student.getStudent("Journalism", 2); // faculty
//        Student.getStudent(5, 3); // year

                    // Grouping by (Faculty, Year) and print results
        Map<Map.Entry<String, Integer>, List<Student>> groups = Student.groupingStudents(students);
        groups.forEach((k, v) -> System.out.printf("(f: %s, y: %d) ---> %s\n", k.getKey(), k.getValue(), v));

                                // Print all students
//        Student.printAll();
    }


}
