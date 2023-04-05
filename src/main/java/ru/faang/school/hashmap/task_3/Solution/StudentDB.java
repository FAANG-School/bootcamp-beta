package ru.faang.school.hashmap.task_3.Solution;

import ru.faang.school.hashmap.task_2.solution.Pair;

import java.io.IOException;
import java.util.*;


public class StudentDB {
    private final Map<Pair, List<Student>> map = new HashMap<>();

    public void add(Student s){
        map.computeIfAbsent(new Pair(s.getFaculty(), s.getYear()),
                k -> new ArrayList<>()).add(s);
    }

    public void add(String name, String faculty, int year) throws IOException {
        add(new Student(name, faculty, year));
    }

    /**
     *
     * @param s student to be removed
     * @return false if student is not in that map
     */
    public boolean remove(Student s){
        try {
            boolean isRemoved =  map.get(new Pair(s.getFaculty(), s.getYear()))
                    .remove(s);
            if(isRemoved &&
                    map.get(new Pair(s.getFaculty(), s.getYear())).size() == 0) {
                map.remove(new Pair(s.getFaculty(), s.getYear()));
            }
            //delete node from hashmap if list of students is empty
            return isRemoved;
        } catch(NullPointerException e){
            return false;
        }
    }

    /**
     *
     * @param name of the student to be removed
     * @param faculty of the student to be removed
     * @param year of the student to be removed
     * @return false if student is not present in the map
     * or if year field is incorrect
     */

    public boolean remove(String name, String faculty, int year){
        try {
            return remove(new Student(name, faculty, year));
        } catch(IOException e){
            return false;
        }
    }

    public Student[] get(String faculty, int year){
        try {
            return map.get(new Pair(faculty, year))
                    .toArray(new Student[0]);
        } catch(NullPointerException e){
            return new Student[]{};
        }
    }

    @SuppressWarnings("unused")
    public List<List<Student>> getAll(){
        List<List<Student>> l = new ArrayList<>();
        for(var entry : map.keySet()){
            l.add(map.get(entry));
        }
        return l;
    }

    /**
     *
     * @param o object to compare with
     * @return true if current map contains the same keys as given map
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDB studentDB = (StudentDB) o;
        return Objects.equals(map, studentDB.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}
