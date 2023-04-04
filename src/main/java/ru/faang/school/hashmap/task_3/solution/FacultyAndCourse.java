package ru.faang.school.hashmap.task_3.solution;

import java.util.Objects;

public class FacultyAndCourse {

  private String faculty;

  private Integer year;

  public String getFaculty() {
    return faculty;
  }

  public Integer getYear() {
    return year;
  }

  public FacultyAndCourse(String faculty, Integer year) {
    this.faculty = faculty;
    this.year = year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    FacultyAndCourse that = (FacultyAndCourse) o;

    if (!Objects.equals(faculty, that.faculty)) {
      return false;
    }
    return Objects.equals(year, that.year);
  }

  @Override
  public int hashCode() {
    int result = faculty != null ? faculty.hashCode() : 0;
    result = 31 * result + (year != null ? year.hashCode() : 0);
    return result;
  }
}
