package ru.faang.school.hashmap.task_3.solution;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Student implements Comparable<Student> {

    private String name;

    private Faculty faculty;

    private int year;

    public PairOfKeys getPairKeys(){
        return new PairOfKeys(faculty, year);
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }

    @AllArgsConstructor
    @EqualsAndHashCode
    @ToString
    public static class PairOfKeys{
        private Faculty faculty;
        private int year;
    }

    public enum Faculty{
        Gryffindor, Hufflepuff, Ravenclaw, Slytherin
    }
}
