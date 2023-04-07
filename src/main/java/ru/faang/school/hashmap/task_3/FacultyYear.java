package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class FacultyYear {
    private String faculty;
    private Integer year;

    public FacultyYear(String faculty, Integer year) {
        this.faculty = faculty;
        this.year = year;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyYear that = (FacultyYear) o;
        return Objects.equals(faculty, that.faculty) && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

    @Override
    public String toString() {
        return "Курс "+year+" факультета "+faculty;
    }
}
