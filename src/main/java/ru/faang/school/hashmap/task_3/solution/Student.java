package ru.faang.school.hashmap.task_3.solution;

public class Student {

  private String name;

  private String faculty;

  private Integer year;

  public Student(String name, String faculty, Integer year) {
    this.name = name;
    this.faculty = faculty;
    this.year = year;
  }

  public String getName() {
    return name;
  }

  public String getFaculty() {
    return faculty;
  }

  public Integer getYear() {
    return year;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", faculty='" + faculty + '\'' +
        ", year=" + year +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Student student = (Student) o;

    if (getName() != null ? !getName().equals(student.getName()) : student.getName() != null) {
      return false;
    }
    if (getFaculty() != null ? !getFaculty().equals(student.getFaculty())
        : student.getFaculty() != null) {
      return false;
    }
    return getYear() != null ? getYear().equals(student.getYear()) : student.getYear() == null;
  }

  @Override
  public int hashCode() {
    int result = getName() != null ? getName().hashCode() : 0;
    result = 31 * result + (getFaculty() != null ? getFaculty().hashCode() : 0);
    result = 31 * result + (getYear() != null ? getYear().hashCode() : 0);
    return result;
  }
}
