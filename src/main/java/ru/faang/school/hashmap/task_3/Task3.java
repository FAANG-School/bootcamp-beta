package ru.faang.school.hashmap.task_3;
import java.util.*;

public class Task3 {
    public static final String SPLITTER = "-----------------------------------";
    public static final String INFO_TEXT = "Выбирите действие" + "\n" + "1. - Добавить студента в список;" + "\n" + "2. - Посмотреть содержимое списка;" + "\n" + "3. - Заполнить HashMap по факутетам;" + "\n" + "4. - Показать содержимое HashMap;" + "\n" + "5. - Удалить студента по факультету и курсу;" + "\n"+ "6. - Поиска всех студентов определенного факультета и курса;" + "\n" + "0. - Выход;" + "\n" + SPLITTER;

    public static void main(String[] args) {
        boolean isExit = false;
        Scanner scan = new Scanner(System.in);
        Map<Para, ArrayList<Student>> hashMapStudents = new HashMap<>();
        ArrayList<Student> studentsList = new ArrayList<>();

        studentsList.add(new Student("Максим", "МАТ", 1));
        studentsList.add(new Student("Иван", "ФИЗ", 2));
        studentsList.add(new Student("Валентин", "МАТ", 2));
        studentsList.add(new Student("Сергей", "ФИЗ", 2));
        studentsList.add(new Student("Егор", "РУС", 5));
        studentsList.add(new Student("Алексей", "РУС", 5));

        hashMapStudents = getHashMap(studentsList);


        System.out.println(SPLITTER);
        while (!isExit) {
            System.out.println(INFO_TEXT);
            try {
                int value = scan.nextInt();
                System.out.println(SPLITTER);
                switch (value) {
                    case 1:
                        studentsList = addNewStudent(studentsList,"");
                        break;
                    case 2:
                        getStudentsListInfo(studentsList);
                        break;
                    case 3:
                        hashMapStudents = getHashMap(studentsList);
                        break;
                    case 4:
                        getHashMapInfo(hashMapStudents);
                        break;
                    case 5:
                        deleteStudentFromList(studentsList);
                        break;
                    case 6:
                        findStudentHashMap(hashMapStudents);
                        break;
                    case 0:
                        System.out.println("Выход...");
                        isExit = true;
                        break;
                }
                System.out.println(SPLITTER);
            } catch (NumberFormatException nfe) {
                System.out.println("Не верный тип попробуйте еще раз");
            }
        }
    }

    private static void findStudentHashMap(Map<Para, ArrayList<Student>> map) {
        boolean isCorrect = false;
        int yearPara = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите факултет: ");
        String facultPara = scan.nextLine();
        System.out.print("Введите курс: ");
        while (!isCorrect) {
            try {
                yearPara = Integer.parseInt(scan.nextLine());
                isCorrect = true;
            } catch (NumberFormatException nfe) {
                System.out.print("Не верный тип попробуйте еще раз: ");
            }
        }
        Para para = new Para(facultPara, yearPara);
        for (Map.Entry maps : map.entrySet()) {
            if (maps.getKey().equals(para)){
                System.out.println(maps.getKey() + "\n" +  "    Студенты: " + maps.getValue() + "");
                System.out.println("");
            }
        }
    }

    public static void getHashMapInfo(Map<Para, ArrayList<Student>> Map) {
        for (Map.Entry maps : Map.entrySet()) {
            System.out.println(maps.getKey() + "\n" +  "    Студенты: " + maps.getValue() + "");
            System.out.println("");
        }
    }

    public static ArrayList<Student> deleteStudentFromList(ArrayList<Student> list){
        boolean isCorrect = false;
        ArrayList<Student> workList = new ArrayList<>();
        addNewStudent(workList, "AddClear");
        for (Student students : list) {
            if (students.equals(workList.get(0))){
                isCorrect = true;
            }
        }
        if (isCorrect){
            list.remove(workList.get(0));
            System.out.println(SPLITTER + "\n" + "Студент был найден и удален");
        } else {
            System.out.println(SPLITTER + "\n" + "Студент не был найден");
        }

        return list;
    }

    public static void getStudentsListInfo(ArrayList<Student> list) {
        for (Student students : list) {
            System.out.println(students);
        }
    }

    public static Map<Para, ArrayList<Student>> getHashMap(ArrayList<Student> list) {
        Map<Para, ArrayList<Student>> returnMap = new HashMap<>();
        for (Student student : list) {
            Para para = new Para(student.getFaculty(), student.getYear());
            returnMap.computeIfAbsent(para, k -> new ArrayList<>()).add(student);
        }
        return returnMap;
    }

    public static ArrayList<Student> addNewStudent(ArrayList<Student> studentArrayList, String Mode) {
        ArrayList<Student> returnList = studentArrayList;
        boolean isCorrect = false;
        int yearStudent = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите имя студента: ");
        String nameStudent = scan.nextLine();
        System.out.print("Введите факультет студента: ");
        String facultStudent = scan.nextLine();
        System.out.print("Введите курс студента: ");
        while (!isCorrect) {
            try {
                yearStudent = Integer.parseInt(scan.nextLine());
                isCorrect = true;
            } catch (NumberFormatException nfe) {
                System.out.print("Не верный тип попробуйте еще раз: ");
            }
        }
        Student student = new Student(nameStudent, facultStudent, yearStudent);
        isCorrect = true;
        for (Student students : studentArrayList) {
            if (students.equals(student)) {
                isCorrect = false;
            }
        }
        if (isCorrect) {
            if (!Mode.equals("AddClear")) {  System.out.println(SPLITTER + "\n" + "Студент добавлен в список");}
            returnList.add(student);
        } else {
            if (!Mode.equals("AddClear")) { System.out.println(SPLITTER + "\n" + "Такой студент уже есть в списке");}
        }
        return returnList;
    }
}

class Student {
    public String name;
    public String faculty;
    public int year;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getYear() == student.getYear() && Objects.equals(getName(), student.getName()) && Objects.equals(getFaculty(), student.getFaculty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculty, year);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "(Имя = '" + name  + "', faculty = '" + faculty + "', year = '" + year + "')";
    }
}

class Para {
    public String facult;
    public int year;

    public String getFacult() {
        return facult;
    }

    public void setFacult(String facult) {
        this.facult = facult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Para para = (Para) o;
        return year == para.year && Objects.equals(facult, para.facult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facult, year);
    }

    public int getYear() {
        return year;
    }

    public Para(String facult, int year) {
        this.facult = facult;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Факультет = '" + facult + "'" + ", Курс = '" + year + "'";
    }

    public void setYear(int year) {
        this.year = year;
    }
}
