package ru.faang.school.hashmap.task_3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	private static final Set<Student> STUDENTS = new HashSet<>();
	private static Map<Tuple, Set<Student>> STUDENTS_MAP = new HashMap<>();

	static {
		STUDENTS.add(new Student("Jack London", "Literature", 2020));
		STUDENTS.add(new Student("Bob Marley", "Music", 2021));
		STUDENTS.add(new Student("Donald Ervin Knuth", "Computer Science", 2020));
		STUDENTS.add(new Student("Joshua J. Bloch", "Computer Science", 2023));
		STUDENTS.add(new Student("James Gosling", "Computer Science", 2020));
		STUDENTS.add(new Student("Andy Warhol", "Design", 2022));
		STUDENTS_MAP = mapByFacultyAndYear();
	}

	private static class Tuple {

		private final String faculty;
		private final int year;

		private Tuple(String faculty, int year) {
			this.faculty = faculty;
			this.year = year;
		}

		private int getYear() {
			return year;
		}

		@Override
		public int hashCode() {
			return Objects.hash(faculty, year);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tuple other = (Tuple) obj;
			return Objects.equals(faculty, other.faculty) && Objects.equals(year, other.year);
		}

		@Override
		public String toString() {
			return "faculty: " + faculty + ", year: " + year;
		}
	}

	public static Map<Tuple, Set<Student>> mapByFacultyAndYear() {

		return STUDENTS.stream().collect(Collectors
				.groupingBy(student -> new Tuple(student.getFaculty(), student.getYear()), Collectors.toSet()));
	}

	public static void add(Student student) {
		if (student == null)
			throw new IllegalArgumentException("Student can't be null");

		if (STUDENTS.contains(student)) {
			System.out.println("This student already exists");
		} else {
			Tuple key = new Tuple(student.getFaculty(), student.getYear());
			STUDENTS.add(student);
			STUDENTS_MAP.computeIfAbsent(key, set -> new HashSet<>()).add(student);
		}
	}

	public static void remove(String name, String faculty, Integer year) {
		if (name == null || faculty == null || year == null) {
			throw new IllegalArgumentException("Null args");
		}
		
		Student student = new Student(name, faculty, year);
		
		if (!STUDENTS.remove(student)) {
			System.out.println("No such student in list");
		}
		else {
			STUDENTS_MAP.values().forEach(value -> value.remove(student));
			STUDENTS_MAP.values().removeIf(Set::isEmpty); 
				
		}
	}

	public static Set<Student> searchByFacultyAndYear(String faculty, Integer year) {
		if (faculty == null || year == null) {
			throw new IllegalArgumentException("Null args");
		}
		return STUDENTS_MAP.get(new Tuple(faculty, year));
	}

	public static void printByFacultyAndYear() {

		if (STUDENTS.isEmpty())
			System.out.println("Students list is empty");
		else
			STUDENTS_MAP.entrySet().stream()
					.sorted(Map.Entry.comparingByKey(Comparator.comparing(Tuple::getYear))).forEach(e -> {
						System.out.println(e.getKey() + "\n  Students list:");
						e.getValue().forEach(System.out::println);
						System.out.println();
					});
	}

	/*
	 * just for testing. pending delete
	 */
	public static void clearTest() {
		STUDENTS.clear();
	}

	/*
	 * just for testing. pending delete
	 */
	public static int sizeTest() {
		return STUDENTS.size();
	}

	/*
	 * just for testing. pending delete
	 */
	public static boolean containsTest(Student student) {
		return STUDENTS.contains(student);
	}

	/*
	 * just for testing. pending delete
	 */
	public static void removeTest(Student student) {
		STUDENTS.remove(student);
		STUDENTS_MAP.values().forEach(value -> value.remove(student));
		STUDENTS_MAP.values().removeIf(Set::isEmpty);
	}

	/*
	 * just for testing. pending delete
	 */
	public static void addTest(Student student) {
		Tuple key = new Tuple(student.getFaculty(), student.getYear());
		STUDENTS.add(student);
		STUDENTS_MAP.computeIfAbsent(key, set -> new HashSet<>()).add(student);
	}

	public static void main(String[] args) {
		/*
		 * unsorted print map just for testing. pending delete
		 */
		mapByFacultyAndYear().forEach((k, v) -> {
			System.out.println(k + "\n  Students list: ");
			v.forEach(System.out::println);
			System.out.println();
		});
	}

}
