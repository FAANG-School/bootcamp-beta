package ru.faang.school.hashmap.task_3;

import java.util.Objects;

public class Student {

	private final String name;
	private final String faculty;
	private final int year;

	public Student(String name, String faculty, int year) {
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

	public int getYear() {
		return year;
	}

	@Override
	public int hashCode() {
		return Objects.hash(faculty, name, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(faculty, other.faculty) && Objects.equals(name, other.name) && year == other.year;
	}

	@Override
	public String toString() {
		return name;
	}
}
