package ru.faang.school.hashmap.task_3;

public class Student {

    private final String name;
    private final Pair pair;

    public Student(String name, Pair pair) {
        this.name = name;
        this.pair = pair;
    }

    public String getName() {
        return name;
    }

    public Pair getPair() {
        return pair;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", pair=" + pair +
                '}';
    }
}
