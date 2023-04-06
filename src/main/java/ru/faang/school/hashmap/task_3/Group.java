package ru.faang.school.hashmap.task_3;

import java.util.*;

public class Group {
    private String faculty;
    private int year;
    Group(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }
    public String getFaculty() {
        return faculty;
    }
    public int getYear() {
        return year;
    }
    public static HashMap<Group, List<Student>> formGroup(List<Student> students) {
        HashMap<Group, List<Student>> groups = new HashMap<>();
        for(Student student : students) {
            Group temp = new Group(student.getFaculty(), student.getYear());
            if(groups.containsKey(temp)) {
                groups.get(temp).add(student);
            } else {
                ArrayList<Student> newGroup = new ArrayList<>();
                newGroup.add(student);
                groups.put(temp,newGroup);
            }
        }
        return groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (year != group.year) return false;
        return Objects.equals(faculty, group.faculty);
    }

    @Override
    public int hashCode() {
        int result = faculty != null ? faculty.hashCode() : 0;
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return "Faculty :" + faculty + " Year: " + year;
    }
}